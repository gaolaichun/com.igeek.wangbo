package com.sm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.model.Package;
import com.sm.model.PackageCategory;
import com.sm.model.PackageDetail;
import com.sm.service.PackageService;
import com.sm.util.CommonUtil;
import com.sm.util.MapValueSortUtils;
import com.sm.util.Msg;

@Controller
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	private static final int GROUNDING = 1;//套餐状态		1.上架
	private static final int UNDERCARRIAGE = 0;//套餐状态	0.下架
	private static final int NOTHING = -1;//套餐状态		-1售罄
	private static final int STOCK = 0;//库存数。			0为库存不足
	private static final int OPENS = 1;//套餐自动置满状态	1.自动置满
	private static final int CLOSE = 0;//套餐自动置满状态	0.不自动置满
	
	
	/**
	 * 查询所有套餐根据销量排序。热销，并查询当前商家有哪些套餐分类
	 * @param sid 商家id
	 * @param sortOrder 排序方式（默认1，升序。0为降序）
	 * @param times 日期，1表示昨天 ，7表示近7日，30表示近三十日
	 * @return
	 */
	@RequestMapping(value = "/selectPackageAllBySid", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectPackageAllBySid(Integer sid, @RequestParam(value="times", defaultValue="1")Integer times, @RequestParam(value="sortOrder", defaultValue="1")Integer sortOrder) {
		//定义一个map，key作为套餐对象，value作为套餐的日销售数量
		Map<Package,Integer> packageSale = new HashMap<Package, Integer>();
		
		//判断是否是昨日的
		if(times == 1) {
			//通过商家id查询所有套餐
			List<Package> packages = packageService.selectPackageAllBySid(sid);
			for (Package pack : packages) {
				//通过套餐id查询昨天的套餐个数
				int i = packageService.selectNumberByOneDay(pack.getId());
				//将查询到的日销售数量和套餐对象存入map中
				packageSale.put(pack, i);
			}
			
			//判断是否是近七日/近30日的
		}else if(times == 7 || times == 30) {
			//通过商家id查询所有套餐
			List<Package> packages = packageService.selectPackageAllBySid(sid);
			for (Package pack : packages) {
				//通过套餐id查询昨天的套餐个数
				int i = packageService.selectNumberByWeek(pack.getId(),times);
				//将查询到的日销售数量和套餐对象存入map中
				packageSale.put(pack, i);
			}
			
		}else {
			//没有传数据或者数据传输错误。
			return Msg.fail().add("msg", "页面飞走了哈哈哈哈");
		}
		
		//如果排序方式sortOrder为默认的1就是升序否则是降序
		if(sortOrder == 1) {
			//调用通过map的value值进行排序的工具类
			packageSale = MapValueSortUtils.sortAscend(packageSale);
			
		}else if(sortOrder == 0){
			packageSale = MapValueSortUtils.sortDescend(packageSale);
			
		}else {
			//没有传数据或者数据传输错误。
			return Msg.fail().add("msg", "页面飞走了哈哈哈哈");
		}
		
		//将map返回
		return Msg.success().add("msg", packageSale);
	}
	
	/**
	 * 自定义日期查询所有套餐的销量排行
	 * 因为数据库中查询的时间段，结束时间的当当天是不查询的。所以需要把结束时间增加一天。
	 * @param sid 商家id
	 * @param startTime 自定义的开始日期
	 * @param endTime 自定义的结束日期
	 * @param sortOrder 排序方式（默认1，升序。0为降序）
	 * @return
	 */
	@RequestMapping(value = "/selectPackageAllBySidTime", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectPackageAllBySidTime(Integer sid,String startTime,String endTime,@RequestParam(value="sortOrder", defaultValue="1")Integer sortOrder) {

		//创建SimpleDateFormat并设置时间格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTime = null;
		try {
			//将以上格式的的字符串endTime转换成时间
			dateTime = simpleDateFormat.parse(endTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//获取一个Calendar实例
		Calendar calendar = Calendar.getInstance();
		//设置转换成时间的dateTime
		calendar.setTime(dateTime);
		//获取dateTime时间的天数
		int day = calendar.get(Calendar.DATE);
		//将tateTime的天数加一
		calendar.set(Calendar.DATE,day + 1);
		//将dateTiem转换成固定格式的字符串赋值给endTime
		endTime = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		
		//定义一个map，key作为套餐对象，value作为套餐的日销售数量
		Map<Package,Integer> packageSale = new HashMap<Package, Integer>();
		
		//通过商家id查询所有套餐
		List<Package> packages = packageService.selectPackageAllBySid(sid);
		for (Package pack : packages) {
			//通过套餐id查询在用户选择的时间段套餐个数
			int i = packageService.selectNumberByTimeInterval(pack.getId(),startTime,endTime);
			//将查询到的销售数量和套餐对象存入map中
			packageSale.put(pack, i);
		}
		
		//如果排序方式sortOrder为默认的1就是升序否则是降序
		if(sortOrder == 1) {
			//调用通过map的value值进行排序的工具类
			packageSale = MapValueSortUtils.sortAscend(packageSale);
			
		}else if(sortOrder == 0){
			packageSale = MapValueSortUtils.sortDescend(packageSale);
			
		}else {
			//没有传数据或者数据传输错误。
			return Msg.fail().add("msg", "页面飞走了哈哈哈哈");
		}
		
		//将map返回
		return Msg.success().add("msg", packageSale);
	}
	
	/**
	 * 查询所有套餐根据销量排序。热销，并查询当前商家有哪些套餐分类
	 * @param sid 商家id
	 * @return
	 */
	@RequestMapping(value = "/selectBySid", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectBySid(Integer sid) {
		//通过商家id查询所有套餐并按销量降序排列存储到List集合中
		List<Package> packages = packageService.selectBySid(sid);
		
		//通过商家id查询所有套餐类别并按category_order进行排序
		List<PackageCategory> packageCategory = packageService.selectCategoryBySid(sid);
		
		//将查询到的所有套餐集合和套餐类别集合返回
		return Msg.success().add("packages", packages).add("packageCategory", packageCategory);
	}
	
	/** 
	 *  通过商家id和套餐类别查询当前类的所有套餐，根据0默认的package_sort排序，1销量排序，-1库存排序
	 * @param sid 商家id
	 * @param packageCategory 套餐类别名
	 * @return
	 */
	@RequestMapping(value = "/selectByPackageCategory", method = RequestMethod.POST )
	@ResponseBody
	public Msg selectByPackageCategory(Integer packageCategory) {
		PackageCategory packCate = packageService.selectCategoryByPackageId(packageCategory);
		System.out.println("packCate.getSortMode()=="+packCate.getSortMode());
		//根据套餐类别排序，1.根据销量排序，-1。根据库存排序，0，根据默认package_sort的排序
		if(packCate.getSortMode() == 1) {
			//通过套餐类别id查询所有套餐
			List<Package> packages = packageService.selectByPackageCategorySale(packageCategory);
			System.out.println("packages=="+packages);
			//将查询到的所有套餐集合返回
			return Msg.success().add("packages", packages);
			
		}else if(packCate.getSortMode() == -1) {
			//通过套餐类别id查询所有套餐
			List<Package> packages = packageService.selectByPackageCategoryStock(packageCategory);
			System.out.println("packages=="+packages);
			//将查询到的所有套餐集合返回
			return Msg.success().add("packages", packages);
			
		}else {
			//通过套餐类别id查询所有套餐
			List<Package> packages = packageService.selectByPackageCategory(packageCategory);
			System.out.println("packages=="+packages);
			//将查询到的所有套餐集合返回
			return Msg.success().add("packages", packages);
		}
	}
	
	/** 
	 * 点击全部商品的下拉选之后显示套餐相关属性的个数（上架，下架，库存等）
	 * @return 返回状态与个数
	 * @param sid 商家id
	 */
	@ResponseBody
	@RequestMapping(value="/selectRelevantSum",method = RequestMethod.POST)
	public Msg selectRelevantSum(Integer sid) {
		
		//通过商家id查询所有套餐数量
		int PackageAll = packageService.selectByPackageAll(sid);
		//查询上架个数
		int grounding = packageService.selectByPackageStatus(sid, GROUNDING);
		//查询下架个数
		int undercarriage = packageService.selectByPackageStatus(sid, UNDERCARRIAGE);
		//库存不足数量
		int stock = packageService.selectByCurrentStock(sid, STOCK);
		
		System.out.println("PackageAll"+PackageAll+":stock="+stock+":undercarriage="+undercarriage+":grounding="+grounding);
		
		return Msg.success().add("PackageAll", PackageAll)
						.add("grounding", grounding)
						.add("undercarriage", undercarriage)
						.add("stock", stock);
	}
	
	/** 
	 *  通过商家id和套餐类别id查询商家当前类上架的所有套餐
	 * @param sid 商家id
	 * @param packageCategory 套餐类别id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectGround",method = RequestMethod.POST)
	public Msg selectGround(Integer sid,Integer packageCategory) {
		//查询上架的所有商品
		List<Package> packages = packageService.selectBySidStatus(sid, GROUNDING,packageCategory);
		
		return Msg.success().add("packages", packages);
	}
	
	/** 
	 *  通过商家id和套餐类别id查询商家当前类下架的所有套餐
	 * @param sid 商家id
	 * @param packageCategory 套餐类别id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectUnder",method = RequestMethod.POST)
	public Msg selectUnder(Integer sid,Integer packageCategory) {
		//查询下架的所有商品
		List<Package> packages = packageService.selectBySidStatus(sid, UNDERCARRIAGE,packageCategory);
		return Msg.success().add("package", packages);
	}
	
	/**
	 *  通过商家id和套餐类别id查询商家当前类库存为0的所有套餐
	 * @param sid 商家id
	 * @param packageCategory 套餐类别id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectStock",method = RequestMethod.POST)
	public Msg selectStock(Integer sid,Integer packageCategory) {
		//查询库存不足的所有商品
		List<Package> packages = packageService.selectBySidStock(sid, STOCK,packageCategory);
		return Msg.success().add("package", packages);
	}
	
	/**
	 * 套餐点击上下架
	 * @param id 要修改上下架的套餐id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateGroundUnder",method = RequestMethod.POST)
	public Msg updateGroundUnder(Integer id) {
		//通过套餐id查询套餐。
		Package pack = packageService.selectById(id);
		//获取套餐状态
		int state = pack.getPackageStatus();
		//判断若上下架状态为1
		if(state == 1) {
			//就将其状态修改为0
			pack.setPackageStatus(0);
			//通过修改了状态后的对象进行更新数据库操作
			int i = packageService.updateByPrimaryKeySelective(pack);
			//若更新成功返回
			if(i == 1) {
				return Msg.success();
			}else {
				return Msg.fail().add("msg", "下架失败");
			}
		}else if(state == 0) {//判断若上下架状态为0
			//获取库存
			int j = pack.getCurrentStock();
			//判断库存是否为0
			if(j == 0) {
				pack.setPackageStatus(-1);
				//更新数据库
				int i = packageService.updateByPrimaryKeySelective(pack);
				if(i == 1) {
					//-1表示已售罄
					return Msg.success().add("-1", -1);
				}else {
					return Msg.fail().add("msg", "修改失败");
				}
			}else {
				pack.setPackageStatus(1);
				int i = packageService.updateByPrimaryKeySelective(pack);
				if(i == 1) {
					//1表示已上架
					return Msg.success().add("1", 1);
				}else {
					return Msg.fail().add("msg", "修改失败");
				}
			}
		}else {
			pack.setPackageStatus(0);
			//通过修改了状态后的对象进行更新数据库操作
			int i = packageService.updateByPrimaryKeySelective(pack);
			//若更新成功返回
			if(i == 1) {
				//0表示下架状态
				return Msg.success().add("0", 0);
			}else {
				return Msg.fail().add("msg", "下架失败");
			}
		}
	}
	
	/**
	 *  批量下架套餐
	 * @param ids 选中的套餐id集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/batchUnder",method = RequestMethod.POST)
	public Msg batchUnder(Integer[] ids) {
		int count = 0;
		//遍历选中的套餐id集合
		for (Integer id : ids) {
			//通过套餐id查询到套餐
			Package pack = packageService.selectById(id);
			//将套餐状态修改为0(下架状态)
			pack.setPackageStatus(0);
			//更新数据库
			int i = packageService.updateByPrimaryKeySelective(pack);
			if(i == 1) {
				//修改一次count自增1
				count++;
			}else {
				return Msg.fail().add("msg", "批量下架失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "批量下架成功");
		}else {
			return Msg.fail().add("msg", "批量下架失败");
		}
	}
	
	/**
	 * 	批量上架
	 * @param ids 选中的套餐id集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/batchGround",method = RequestMethod.POST)
	public Msg batchGround(Integer[] ids) {
		int count = 0;
		//遍历选中的套餐id集合
		for (Integer id : ids) {
			//通过套餐id查询到套餐
			Package pack = packageService.selectById(id);
			
			//获取库存
			int kc = pack.getCurrentStock();
			if(kc > 0) {
				//将套餐状态修改为1(上架状态)
				pack.setPackageStatus(1);
				int i = packageService.updateByPrimaryKeySelective(pack);
				if(i == 1) {
					count++;
				}else {
					return Msg.fail().add("msg", "批量上架失败");
				}
			} else {
				//将套餐状态修改为-1(上架状态)
				pack.setPackageStatus(-1);
				int i = packageService.updateByPrimaryKeySelective(pack);
				if(i == 1) {
					count++;
				}else {
					return Msg.fail().add("msg", "批量上架失败");
				}
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "批量上架成功");
		}else {
			return Msg.fail().add("msg", "批量上架失败");
		}
	}
	
	/** 
	 *  沽清选中套餐库存
	 * @param ids 选中套餐id数组
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/clearStock", method = RequestMethod.POST)
	public Msg clearStock(Integer[] ids) {
		int count = 0;
		for (Integer id : ids) {
			//通过套餐id查询套餐
			Package pack = packageService.selectById(id);
			//将套餐的库存设置为0
			pack.setCurrentStock(STOCK);
			//通过对象修改套餐
			int i = packageService.updateByPrimaryKeySelective(pack);
			
			if(i == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "全部沽清失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("Msg", "全部沽清成功");
		}else {
			return Msg.fail().add("msg", "全部沽清失败");
		}
	}
	
	/**
	 *  批量置满库存
	 * @param ids 选中的套餐的id数组
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "/fillStock", method = RequestMethod.POST)
	public Msg fillStock(Integer[] ids) {
		int count = 0;
		for (Integer id : ids) {
			//通过套餐id查询套餐
			Package pack = packageService.selectById(id);
			//获取最大库存量
			int maxStock = pack.getMaxStock();
			//将套餐的库存设置为最大库存量
			pack.setCurrentStock(maxStock);
			//通过对象修改套餐
			int i = packageService.updateByPrimaryKeySelective(pack);
			
			if(i == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "全部置满失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("Msg", "全部置满成功");
		}else {
			return Msg.fail().add("msg", "全部置满失败");
		}
	}
	
	/**
	 *  批量自定义库存
	 * @param ids 选中的要批量自定义库存的套餐的id数组
	 * @param packageStock 批量自定义库存的库存数。
	 * @param maxStock 最大库存量
	 * @param falg  是否自动次日置满库存状态(ture false)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/customStock", method = RequestMethod.POST)
	public Msg customStock(Integer[] ids, Integer packageStock,Integer maxStock,boolean falg) {
		int count = 0;
		for (Integer id : ids) {
			//通过套餐id查询套餐
			Package pack = packageService.selectById(id);
			//将套餐的库存和最大库存设置为用户输入的的数量
			pack.setCurrentStock(packageStock);
			pack.setMaxStock(maxStock);
			//判断置满状态为true
			if(falg ==true) {
				//将状态修改为1
				pack.setOpens(OPENS);
			}else {
				//否则修改为0
				pack.setOpens(CLOSE);
			}
			//通过套餐对象修改套餐
			int i = packageService.updateByPrimaryKeySelective(pack);
			if(i == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "自定义库存失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("Msg", "自定义库存成功");
		}else {
			return Msg.fail().add("msg", "自定义库存失败");
		}
	}
	
	
	/**
	 *  搜索套餐(模糊搜索)
	 * @param sid 商家id
	 * @param packageName 用户搜索输入的套餐名字
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectPackage",method = RequestMethod.POST)
	public Msg selectPackage(Integer sid, String packageName) {
		
		List<Package> packages = packageService.selectBySidPackageName(sid, packageName);
		return Msg.success().add("packages", packages);
		
	}
	
	/**
	 *  批量修改价格
	 * @param ids 选中的要批量修改价格的套餐id数组
	 * @param price 要修改的套餐价格
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePriceByPackageId",method = RequestMethod.POST)
	public Msg updatePriceByPackageId(Integer[] ids,Double price) {
		//创建一个对象
		Package pack = new Package();
		//设置套餐价格
		pack.setPrice(price);
		//定义一个计数器
		int count = 0;
		//遍历选中的套餐的id
		for (Integer id : ids) {
			//设置套餐id
			pack.setId(id);
			//更新套餐
			int i = packageService.updateByPrimaryKeySelective(pack);
			if(i == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "批量修改价格失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "批量修改价格成功");
		}else {
			return Msg.fail().add("msg", "批量修改价格失败");
		}
	}
	
	
	/**
	 *  批量移动套餐类别
	 * @param ids 要移动的套餐的id的数组
	 * @param categroyId 要移动到的套餐类别的id。
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/movePackage",method = RequestMethod.POST)
	public Msg movePackage(Integer[] ids,Integer categroyId) {
		
		int count = 0;
		for (Integer id : ids) {
			//通过套餐id查询到套餐。
			Package pack = packageService.selectById(id);
			//将查询到的套餐类别id设置为要修改的套餐类别的id
			pack.setPackageCategory(categroyId);
			//通过套餐对象进行更新操作
			int i = packageService.updateByPrimaryKeySelective(pack);
			if(i == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "套餐移动失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "套餐移动成功");
		}else {
			return Msg.fail().add("msg", "套餐移动失败");
		}
	}
	
	
	/**
	 * 批量修改套餐人数
	 * @param ids 选中的要修改套餐人数的id的数组
	 * @param peopleNumber 要修改成的数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePackageNumber",method = RequestMethod.POST)
	public Msg updatePackageNumber(Integer[] ids,Integer peopleNumber) {
		
		//创建一个对象
		Package pack = new Package();
		//设置套餐人数
		pack.setPeopleNumber(peopleNumber);
		//定义一个计数器
		int count = 0;
		//遍历选中的套餐的id
		for (Integer id : ids) {
			//设置套餐id
			pack.setId(id);
			//更新套餐
			int i = packageService.updateByPrimaryKeySelective(pack);
			if(i == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "批量修改人数失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "批量修改人数成功");
		}else {
			return Msg.fail().add("msg", "批量修改人数失败");
		}
	}
	
	/** 
	 *  批量删除套餐
	 * @param ids 要删除的套餐的id的数组
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delectPackageAll",method = RequestMethod.POST)
	public Msg delectPackageAll(Integer[] ids) {
		int count = 0;
		for (Integer id : ids) {
			//通过套餐id删除套餐
			int i = packageService.delectById(id);
			int j = packageService.delectByIdPackage(id);
			
			if(i == 1 && j > 0) {
				count++;
			}else {
				return Msg.fail().add("msg", "批量删除失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "批量删除成功");
		}else {
			return Msg.fail().add("msg", "批量删除失败");
		}
	}
	
	/** 
	 *  一键按销量或者库存排序商家修改后的排序
	 * @param id 套餐类别id
	 * @param sortMode 排序方式 0默认的package_sort排序，1销量排序，-1库存排序
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateSortModeByPackageId",method = RequestMethod.POST)
	public Msg updateSortModeByPackageId(Integer id,Integer sortMode) {
		
		//通过套餐类别id查询套餐类别对象
		PackageCategory packCate = packageService.selectCategoryByPackageId(id);
		//设置有修改的排序方式
		packCate.setSortMode(sortMode);
		
		//更新排序方式
		int i = packageService.updateSortModeByPackageCategory(packCate);
		if(i == 1) {
			return Msg.success().add("msg", "排序保存成功");
		}else {
			return Msg.fail().add("msg", "排序保存失败");
		}
	}
	
	/** 套餐类别排序，保存置顶排序之后的套餐类别的id数组(有序)
	 * @param ids 套餐的id数组(有序)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePackageCategorySortModeTop",method = RequestMethod.POST)
	public Msg updatePackageCategorySortModeTop(Integer[] ids) {
		int count = 0;
		//遍历套餐数组（有序）
		for (int i = 0; i < ids.length; i++) {
			//通过id查询套餐别
			Package pack = packageService.selectById(ids[i]);
			//将套餐的排序设置为当前这个套餐对象的在ids数组中的索引
			pack.setPackageSort(ids[i]);
			
			//通过对象进行更新操作
			int j = packageService.updateByPrimaryKeySelective(pack);
			if(j == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "置顶失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "置顶排序成功");
		}else {
			return Msg.fail().add("msg", "置顶失败");
		}
	}
	
	/** 套餐中单品排序，保存置顶排序之后的单个菜品的id数组(有序)
	 * @param ids 套餐中的单个菜品的id数组(有序)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePackageDetailSortModeTop",method = RequestMethod.POST)
	public Msg updatePackageDetailSortModeTop(Integer[] ids) {
		int count = 0;
		//遍历菜品数组（有序）
		for (int i = 0; i < ids.length; i++) {
			//通过id查询单个菜品
			PackageDetail packageDetail = packageService.selectDetailByPackageId(ids[i]);
			//将单品的排序设置为当前这个单品对象的在ids数组中的索引
			packageDetail.setGoodsSort(ids[i]);
			
			//通过对象进行更新操作
			int j = packageService.updateSortModeByDetail(packageDetail);
			if(j == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "置顶失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "置顶排序成功");
		}else {
			return Msg.fail().add("msg", "置顶失败");
		}
	}
	
	
	/** 套餐排序，保存置顶排序之后的套餐的id数组(有序)
	 * @param ids 套餐的id数组(有序)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePackageSortModeTop",method = RequestMethod.POST)
	public Msg updatePackageSortModeTop(Integer[] ids) {
		int count = 0;
		//遍历套餐类别数组（有序）
		for (int i = 0; i < ids.length; i++) {
			//通过id查询套套餐类别
			PackageCategory packageCategory = packageService.selectCategoryByPackageId(ids[i]);
			//将套餐类别的排序设置为当前这个套餐类对象的在ids数组中的索引
			packageCategory.setSortMode(ids[i]);
			
			//通过对象进行更新操作
			int j = packageService.updateSortModeByPackageCategory(packageCategory);
			if(j == 1) {
				count++;
			}else {
				return Msg.fail().add("msg", "置顶失败");
			}
		}
		if(count == ids.length) {
			return Msg.success().add("msg", "置顶排序成功");
		}else {
			return Msg.fail().add("msg", "置顶失败");
		}
	}
	
	/**
	 *  点击管理分类。通过商家id查询所有的套餐分类类别
	 *  或者点击添加商品中的店内分类，查询所有套餐类别。
	 * @param sid 商家id
	 * @return 返回所有套餐类别对象。
	 */
	@ResponseBody
	@RequestMapping(value="/manageCategories",method = RequestMethod.POST)
	public Msg manageCategories(Integer sid) {
		List<PackageCategory> packageCategorys = packageService.selectCategoryBySid(sid);
		return Msg.success().add("msg", packageCategorys);
	}
	
	/**
	 *  通过商家id添加(新建)套餐类别。
	 * @param sid 商家id
	 * @param packageCategoryName 要添加的套餐类别的类别名
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertCategroyBySid",method = RequestMethod.POST)
	public Msg insertCategroyBySid(Integer sid,String packageCategoryName) {
		//判断用户输入的套餐类别名称是否为空
		if(packageCategoryName == null || packageCategoryName == "") {
			return Msg.fail().add("msg", "请输入套餐类别名称");
		}
		//创建一个list存放套餐类别排序方式中的顺序
		List<Integer> orderList = new ArrayList<Integer>();
		
		int maxOrder = -1;
		//通过商家查询所有套餐类别
		List<PackageCategory> packageCategorys = packageService.selectCategoryBySid(sid);
		if(packageCategorys == null || packageCategorys.size() == 0) {
			maxOrder = -1;
		}else {
			//遍历将套餐类别中的排序顺序获取并存入到集合中。
			for (PackageCategory pc : packageCategorys) {
				//判断当前用户输入的套餐类别名是否存在
				if(packageCategoryName.equals(pc.getPackageCategoryName())) {
					return Msg.fail().add("msg", "套餐类别名已经存在了，请重新输入");
				}else {
					orderList.add(pc.getCategoryOrder());
				}
			}
			//获取其中最大值
			maxOrder = Collections.max(orderList);
		}
		
		//创建一个套餐类别对象
		PackageCategory packageCategory = new PackageCategory();
		//给套餐类别对象赋值商家id，套餐类别名，套餐排序顺序最大值加1
		packageCategory.setSid(sid);
		packageCategory.setPackageCategoryName(packageCategoryName);
		packageCategory.setCategoryOrder(maxOrder+1);
		
		//根据套餐类别对象插入套餐类别
		int i = packageService.insertCategoryBySid(packageCategory);
		if(i == 1) {
			return Msg.success().add("msg", "添加分类成功");
		}else {
			return Msg.fail().add("msg", "添加分类失败");
		}
	}
	
	/** 
	 *  通过套餐类别id修改套餐名称
	 * @param id 套餐类别id
	 * @param packageCategoryName 要修改成的套餐新名称
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateCategroyNameByid",method = RequestMethod.POST)
	public Msg updateCategroyNameByid(Integer id,String packageCategoryName) {
		
		//通过套餐类别id查询套餐类别对象
		PackageCategory packCate = packageService.selectCategoryByPackageId(id);
		//设置套餐类新类名
		packCate.setPackageCategoryName(packageCategoryName);
		
		//更新套餐类别名
		int i = packageService.updateSortModeByPackageCategory(packCate);
		if(i == 1) {
			return Msg.success().add("msg", "修改分类成功");
		}else {
			return Msg.fail().add("msg", "修改分类失败");
		}
	}
	
	/** 
	 *  通过套餐类别id删除套餐类别。并同时删除此套餐类别下的所有套餐以及套餐中的所有单品
	 * @param id 套餐类别id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delectPackageCategoryByid",method = RequestMethod.POST)
	public Msg delectPackageCategoryByid(Integer id) {
		
		//通过套餐类别id查询所有套餐。
		List<Package> packages = packageService.selectByPackageCategory(id);
		int coun = 0;
		
		//遍历查询到的所有的套餐
		for (Package pack : packages) {
			//获取套餐的id
			Integer tid = pack.getId();
			
			//通过套餐id查询所有的单品
			List<PackageDetail> packageDetail = packageService.selectPackageDetailById(tid);
			int count = 0;
			
			//遍历所有单品
			for (PackageDetail pd : packageDetail) {
				//获取单品id
				Integer pid = pd.getId();
				//删除套餐单品
				int d = packageService.delectByIdPackage(pid);
				
				if(d == 1) {
					count++;
				}else {
					return Msg.fail().add("msg", "删除套餐类别失败");
				}
			}
			
			if(count == packageDetail.size()) {
				//删除套餐
				int t = packageService.delectById(tid);
				
				if(t == 1) {
					coun++;
				}else {
					return Msg.fail().add("msg", "删除套餐类别失败");
				}
			}else {
				return Msg.fail().add("msg", "删除套餐类别失败");
			}
		}
		
		if(coun == packages.size()) {
			//删除套餐类别
			int c = packageService.delectCategoryById(id);
			
			if(c == 1) {
				return Msg.success().add("msg", "套餐类别删除成功");
			}else {
				return Msg.fail().add("msg", "删除套餐类别失败");
			}
		}else {
			return Msg.fail().add("msg", "删除套餐类别失败");
		}
	}
	
	public Msg insertPackageBySelective() {
		return null;
		
	}
	
	/**
	 *  点击新建商品时获取套餐名
	 * @param id 套餐类别id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/newPackage",method = RequestMethod.POST)
	public Msg newPackage(Integer id) {
		//通过套餐类别id查询套餐类别对象
		PackageCategory packageCategory = packageService.selectCategoryByPackageId(id);
		//将套餐类别对象返回。
		return Msg.success().add("msg", packageCategory);
	}
	
	/**
	 * 	新建商品。点击保存商品的时候。
	 * @param id 套餐类别id（店内分类id）
	 * @param packagePicture 套餐商品图片
	 * @param packageName 商品名称
	 * @param packageDetail 套餐内容(套餐中的菜品)
	 * @param peopleNumber 套餐人数
	 * @param price 套餐价格
	 * @param currentStock 当前库存
	 * @param maxStock 最大库存
	 * @param opens 库存是否次日置满。
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insterPackage",method = RequestMethod.POST)
	public Msg insterPackage(Integer id,String packagePicture,String packageName,PackageDetail[] packageDetails,Integer peopleNumber,Double price,Integer currentStock,Integer maxStock,Boolean opens) {
		
		//判断用户输入的套餐名称是否为空
		if(packageName == null || packageName == "") {
			return Msg.fail().add("msg", "请输入套餐名称");
		}
		
		//查询套餐类别对象
		PackageCategory packageCategory = packageService.selectCategoryByPackageId(id);
		int sid = packageCategory.getSid();//获取获取商家id
		int packageCategoryId = packageCategory.getId();//套餐类别id
		//创建一个list存放套餐类别排序方式中的顺序
		List<Integer> orderList = new ArrayList<Integer>();
		
		int maxOrder = -1;
		//通过套餐类别id查询所有套餐
		List<Package> packages = packageService.selectByPackageCategory(packageCategoryId);
		
		if(packages == null || packages.size() == 0) {
			maxOrder = -1;
		}else {
			//遍历将套餐中的排序顺序获取并存入到集合中。
			for (Package pk : packages) {
				//判断当前用户输入的套餐类别名是否存在
				if(packageName.equals(pk.getPackageName())) {
					return Msg.fail().add("msg", "套餐名已经存在了，请重新输入");
				}else {
					orderList.add(pk.getPackageSort());
				}
			}
			//获取其中最大值
			maxOrder = Collections.max(orderList);
		}
		
		//创建一个套餐对象
		Package pack = new Package();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(packagePicture, "C:/upload"+path);
		
		pack.setSid(sid);
		pack.setPackagePicture(path);//设置套餐图片(可以没哟)
		pack.setPackageName(packageName);//设置套餐名
		pack.setPeopleNumber(peopleNumber);//设置套餐人数
		pack.setPackageCategory(packageCategoryId);//设置套餐类别id
		pack.setPrice(price);//设置套餐价格
		pack.setCurrentStock(currentStock);//设置套餐库存
		pack.setMaxStock(maxStock);//设置套餐最大库存
		
		if(opens) {//判断是否是自动置满状态
			pack.setOpens(OPENS);
		}else {
			pack.setOpens(CLOSE);
		}
		if(currentStock == 0) {//判断用户设置的库存是否为0
			pack.setPackageStatus(NOTHING);//若为0自动设置套餐状态为-1(售罄状态)
		}else {
			pack.setPackageStatus(GROUNDING);//若不等于0默认设置为1(上架状态)
		}
		pack.setPackageSort(maxOrder+1);//设置排序功能的顺序，套餐排序顺序最大值加1
		
		//通过套餐对象插入套餐。
		int i = packageService.insertSelective(pack);
		if(i == 1) {
			
			//创建一个套餐中的一个单品的对象
//			PackageDetail packageDetail = new PackageDetail();
			int count = 0;
			//遍历传过来的单品对象数组
			for (int j = 0; j < packageDetails.length; j++) {
				//为单品设置套餐id
				packageDetails[j].setPackageId(pack.getId());
				//设置单品的排序序号(单品数组的索引作为排序序号规则)
				packageDetails[j].setGoodsSort(j);
				
				int m = packageService.updateSortModeByDetail(packageDetails[j]);
				count++;
			}
			
			if(count == packageDetails.length) {
				return Msg.success().add("msg", "套餐添加成功");
			}else {
				return Msg.fail().add("msg", "套餐添加失败");
			}
			
		}else {
			return Msg.fail().add("msg", "套餐添加失败");
		}
	}
	
	
	/**
	 * 	点击编辑套餐，查询套餐详情展示在编辑页面上
	 * @param id 套餐id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/editPackage",method = RequestMethod.POST)
	public Msg editPackage(Integer id) {
		//通过套餐id查询套餐
		Package pack = packageService.selectById(id);
		return Msg.success().add("msg", pack);
	}
	
	/**
	 * 	编辑商品。点击保存商品的时候。
	 * @param id 套餐id
	 * @param packageCategoryId 套餐类别id
	 * @param packagePicture 套餐商品图片
	 * @param packageName 商品名称
	 * @param packageDetail 套餐内容(套餐中的菜品)
	 * @param peopleNumber 套餐人数
	 * @param price 套餐价格
	 * @param currentStock 当前库存
	 * @param maxStock 最大库存
	 * @param opens 库存是否次日置满。
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/editPackagePreserve",method = RequestMethod.POST)
	public Msg editPackagePreserve(Integer id,Integer packageCategoryId,String packagePicture,String packageName,PackageDetail[] packageDetails,Integer peopleNumber,Double price,Integer currentStock,Integer maxStock,Boolean opens) {
		
		//判断用户输入的套餐名称是否为空
		if(packageName == null || packageName == "") {
			return Msg.fail().add("msg", "请输入套餐名称");
		}
		//通过套餐id查询套餐
		Package pack = packageService.selectById(id);
		
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(packagePicture, "C:/upload"+path);
		
		pack.setPackagePicture(path);//设置套餐图片(可以没哟)
		pack.setPackageName(packageName);//设置套餐名
		pack.setPeopleNumber(peopleNumber);//设置套餐人数
		pack.setPackageCategory(packageCategoryId);//设置套餐类别id
		pack.setPrice(price);//设置套餐价格
		pack.setCurrentStock(currentStock);//设置套餐库存
		pack.setMaxStock(maxStock);//设置套餐最大库存
		
		if(opens) {//判断是否是自动置满状态
			pack.setOpens(OPENS);
		}else {
			pack.setOpens(CLOSE);
		}
		if(currentStock == 0) {//判断用户设置的库存是否为0
			pack.setPackageStatus(NOTHING);//若为0自动设置套餐状态为-1(售罄状态)
		}else {
			pack.setPackageStatus(GROUNDING);//若不等于0默认设置为1(上架状态)
		}
		
		//通过套餐对象修改套餐。
		int i = packageService.updateByPrimaryKeySelective(pack);
		if(i == 1) {
			//通过套餐id查询所有套餐中的单品
			int delSum = packageService.delectByIdPackage(id);
			if(delSum >= 1) {
				int count = 0;
				//遍历传过来的单品对象数组
				for (int j = 0; j < packageDetails.length; j++) {
					//为单品设置套餐id
					packageDetails[j].setPackageId(pack.getId());
					//设置单品的排序序号(单品数组的索引作为排序序号规则)
					packageDetails[j].setGoodsSort(j);
					
					int m = packageService.updateSortModeByDetail(packageDetails[j]);
					count++;
				}
				
				if(count == packageDetails.length) {
					return Msg.success().add("msg", "套餐修改成功");
				}else {
					return Msg.fail().add("msg", "套餐修改失败");
				}
			}else {
				return Msg.fail().add("msg", "套餐修改失败");
			}
			
		}else {
			return Msg.fail().add("msg", "套餐修改失败");
		}
	}
	
	/** 编辑套餐界面点击删除套餐
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delectPackage",method = RequestMethod.POST)
	public Msg delectPackage(Integer id) {
		
		//通过套餐id删除套餐
		int i = packageService.delectById(id);
		int j = packageService.delectByIdPackage(id);
		
		if(i == 1 && j > 0) {
			return Msg.success();
		}else {
			return Msg.fail().add("msg", "删除失败");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
