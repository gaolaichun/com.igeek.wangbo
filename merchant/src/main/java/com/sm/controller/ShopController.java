package com.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.model.Shop;
import com.sm.model.ShopCategory;
import com.sm.model.ShopPicture;
import com.sm.service.ShopCategoryService;
import com.sm.service.ShopPictureService;
import com.sm.service.ShopService;
import com.sm.util.CommonUtil;
import com.sm.util.Msg;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@Autowired
	private ShopCategoryService shopCategoryService;

	@Autowired
	private ShopPictureService shopPictureService;

	/**
	 * 修改头像
	 * 
	 * @param id     门店id
	 * @param imgStr 头像Base64
	 * @return
	 */
	@RequestMapping(value = "/updateHeadlink", method = RequestMethod.POST)
	@ResponseBody
	public Msg updatePortrait(Integer id, String imgStr) {
		// 创建一个对象
		Shop shop = new Shop();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置门店id
		shop.setId(id);
		shop.setHeadlink(path);
		// 执行sql
		int val = shopService.updateByPrimaryKeySelective(shop);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 修改商家相关信息
	 * 
	 * @param id                门店id
	 * @param shopName          商家用户名
	 * @param password          商家密码
	 * @param name              商家名称
	 * @param phone             商家电话
	 * @param phoneSec          商家电话（选填）
	 * @param phoneThr          商家电话（选填）
	 * @param address           商家地址
	 * @param mainCategory      商家主营业务
	 * @param secondCategory    商家次营业务
	 * @param businessHourone   营业时间段一
	 * @param businessHourtwo   营业时间段二
	 * @param businessHourthree 营业时间段三
	 * @param announcement      门店公告
	 * @param shopIntroduction  门店简介
	 * @param bill              发票
	 * @return
	 */
	@RequestMapping(value = "/updateShopInfo", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateShopInfo(Integer id, String shopName, String password, String name, String phone, String phoneSec,
			String phoneThr, String address, String mainCategory, String secondCategory, String businessHourone,
			String businessHourtwo, String businessHourthree, String announcement, String shopIntroduction,
			String bill) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		Shop shop = new Shop();
		// 设置门店id
		shop.setId(id);
		// 设置商家用户名
		shop.setShopName(shopName);
		// 设置商家密码
		shop.setPassword(password);
		// 设置商家名称
		shop.setName(name);
		// 设置商家电话
		shop.setPhone(phone);
		// 设置商家电话（选填）
		shop.setPhoneSec(phoneSec);
		// 设置商家电话（选填）
		shop.setPhoneThr(phoneThr);
		// 设置商家主营业务
		shop.setMainCategory(mainCategory);
		// 设置商家次营业务
		shop.setSecondCategory(secondCategory);
		// 设置商家地址
		shop.setAddress(address);
		// 设置营业时间段一
		shop.setBusinessHourone(businessHourone);
		// 设置营业时间段二
		shop.setBusinessHourtwo(businessHourtwo);
		// 设置营业时间段三
		shop.setBusinessHourthree(businessHourthree);
		// 设置门店公告
		shop.setAnnouncement(announcement);
		// 设置门店简介
		shop.setShopIntroduction(shopIntroduction);
		// 设置是否发票
		shop.setBill(bill);
		// 执行sql
		int val = shopService.updateByPrimaryKeySelective(shop);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 添加商家相关信息
	 * 
	 * @param id                门店id
	 * @param shopName          商家用户名
	 * @param password          商家密码
	 * @param name              商家名称
	 * @param phone             商家电话
	 * @param phoneSec          商家电话（选填）
	 * @param phoneThr          商家电话（选填）
	 * @param address           商家地址
	 * @param mainCategory      商家主营业务
	 * @param secondCategory    商家次营业务
	 * @param businessHourone   营业时间段一
	 * @param businessHourtwo   营业时间段二
	 * @param businessHourthree 营业时间段三
	 * @param announcement      门店公告
	 * @param shopIntroduction  门店简介
	 * @param bill              发票
	 * @return
	 */
	@RequestMapping(value = "/insertShopInfo", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertShopInfo(Integer id, String shopName, String password, String name, String phone, String phoneSec,
			String phoneThr, String address, String mainCategory, String secondCategory, String businessHourone,
			String businessHourtwo, String businessHourthree, String announcement, String shopIntroduction,
			String bill) {
//		if (id == null) {
//			return Msg.fail().add("msg", "参数不为空！");
//		}
		// 创建一个对象
		Shop shop = new Shop();
		// 设置门店id
		shop.setId(id);
		// 设置商家用户名
		shop.setShopName(shopName);
		// 设置商家密码
		shop.setPassword(password);
		// 设置商家名称
		shop.setName(name);
		// 设置商家电话
		shop.setPhone(phone);
		// 设置商家电话（选填）
		shop.setPhoneSec(phoneSec);
		// 设置商家电话（选填）
		shop.setPhoneThr(phoneThr);
		// 设置商家主营业务
		shop.setMainCategory(mainCategory);
		// 设置商家次营业务
		shop.setSecondCategory(secondCategory);
		// 设置商家地址
		shop.setAddress(address);
		// 设置营业时间段一
		shop.setBusinessHourone(businessHourone);
		// 设置营业时间段二
		shop.setBusinessHourtwo(businessHourtwo);
		// 设置营业时间段三
		shop.setBusinessHourthree(businessHourthree);
		// 设置门店公告
		shop.setAnnouncement(announcement);
		// 设置门店简介
		shop.setShopIntroduction(shopIntroduction);
		// 设置是否发票
		shop.setBill(bill);
		// 执行sql
		int val = shopService.insertSelective(shop);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 查询营业时间
	 * 
	 * @param id 门店id
	 * @return
	 */
	@RequestMapping(value = "/selectOpenHours", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectOpenHours(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shopPhone = shopService.selectOpenHours(id);
		if (shopPhone == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shopPhone", shopPhone);
	}

	/**
	 * 查询门店公告
	 * 
	 * @param id 门店id
	 * @return
	 */
	@RequestMapping(value = "/selectAnnouncement", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectAnnouncement(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shopPhone = shopService.selectAnnouncement(id);
		if (shopPhone == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shopPhone", shopPhone);
	}

	/**
	 * 查询温馨提示
	 * 
	 * @param id 门店id
	 * @return
	 */
	@RequestMapping(value = "/selectWarmPrompt", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectWarmPrompt(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		String shopPhone = shopService.selectWarmPrompt(id).toString();
//		String result = shopPhone.replace(" ", ",");

		if (shopPhone == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shopPhone", shopPhone);
	}

	/**
	 * 查询商家订餐电话
	 * 
	 * @param id 门店id
	 * @return
	 */
	@RequestMapping(value = "/selectPhone", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectPhone(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shopPhone = shopService.selectPhone(id);
		if (shopPhone == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shopPhone", shopPhone);
	}

	/**
	 * 编辑商家订餐电话
	 * 
	 * @param id       门店id
	 * @param phone    商家订餐电话
	 * @param phoneSec 商家订餐电话（选填）
	 * @param phoneThr 商家订餐电话（选填）
	 * @return
	 */
	@RequestMapping(value = "/editPhone", method = RequestMethod.POST)
	@ResponseBody
	public Msg editPhone(Integer id, String phone, String phoneSec, String phoneThr) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		Shop shop = new Shop();
		// 设置门店id
		shop.setId(id);
		// 设置商家订餐电话
		shop.setPhone(phone);
		// 设置商家订餐电话（选填）
		shop.setPhoneSec(phoneSec);
		// 设置商家订餐电话（选填）
		shop.setPhoneThr(phoneThr);
		// 执行sql
		int val = shopService.updateByPrimaryKeySelective(shop);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 查询门店地址
	 * 
	 * @param id 门店id
	 * @return
	 */
	@RequestMapping(value = "/selectLocation", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectLocation(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}

		Shop location = shopService.selectLocation(id);
		if (location == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("location", location);
	}

	/**
	 * 编辑门店地址
	 * 
	 * @param id        门店id
	 * @param area      所在地区
	 * @param address   详细地址
	 * @param longitude 定位的经度
	 * @param latitude  定位的纬度
	 * @return
	 */
	@RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateLocation(Integer id, String area, String address, String longitude, String latitude) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		Shop shop = new Shop();
		// 设置门店id
		shop.setId(id);
		// 设置所在地区
		shop.setArea(area);
		// 设置详细地址
		shop.setAddress(address);
		// 设置定位的经度
		shop.setLongitude(longitude);
		// 设置定位的纬度
		shop.setLatitude(latitude);
		//执行sql
		int val = shopService.updateByPrimaryKeySelective(shop);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 查询商家门店二维码
	 * 
	 * @param id         门店id
	 * @param shopQrCode 商家二维码
	 * @return
	 */
	@RequestMapping(value = "/selectShopQrCode", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectShopQrCode(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shopQrCode = shopService.selectShopQrCode(id);
		if (shopQrCode == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shopQrCode", shopQrCode);
	}

	/**
	 * 查询商家门店主营分类
	 * 
	 * @param id           商家分类表id
	 * @param categoryName 分类名称
	 * @return
	 */
	@RequestMapping(value = "/selectShopCategory", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectShopCategory(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shop = shopService.selectByPrimaryKey(id);
		if (shop == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shop", shop);
	}

	/**
	 * 查询门店基本信息
	 * 
	 * @param id 门店id
	 * @return
	 */
	@RequestMapping(value = "/selectShopBaseInfo", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectShopBaseInfo(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shop = shopService.selectShopBaseInfo(id);

		if (shop == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shop", shop);
	}

	/**
	 * 通过id查门店所有信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getShopById", method = RequestMethod.POST)
	@ResponseBody
	public Msg getShopById(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shop = shopService.selectByPrimaryKey(id);
		if (shop == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shop", shop);
	}

	/**
	 * 查门店信息
	 * 
	 * @param id 商家ID
	 * @return
	 */
	@RequestMapping(value = "/getShopInfo", method = RequestMethod.POST)
	@ResponseBody
	public Msg getShopInfo(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shop = shopService.getShopInfo(id);
		if (shop == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shop", shop);
	}

	/**
	 * 编辑门店信息
	 * 
	 * @param id             商家ID
	 * @param name           商家门店名称
	 * @param mainCategory   主营分类
	 * @param secondCategory 次营分类
	 * @return
	 */
	@RequestMapping(value = "/editShopInfo", method = RequestMethod.POST)
	@ResponseBody
	public Msg editShopInfo(Integer id, String name, String mainCategory, String secondCategory) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		Shop shop = new Shop();
		// 设置门店id
		shop.setId(id);
		// 设置商家门店名称
		shop.setName(name);
		// 设置主营分类
		shop.setMainCategory(mainCategory);
		// 设置次营分类
		shop.setSecondCategory(secondCategory);
		// 执行sql
		int val = shopService.updateByPrimaryKeySelective(shop);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 通过id查门店营业信息
	 * 
	 * @param id 商家表id
	 * @return
	 */
	@RequestMapping(value = "/getShopBusinessInfoById", method = RequestMethod.POST)
	@ResponseBody
	public Msg getShopBusinessInfoById(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		Shop shop = shopService.selectShopBusinessInfo(id);
		if (shop == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("shop", shop);
	}

	/**
	 * 查门店所有分类名称
	 * 
	 * @param id 门店分类id
	 * @return
	 */
	@RequestMapping(value = "/getCategoryName", method = RequestMethod.POST)
	@ResponseBody
	public Msg getCategoryName(Integer id) {
		// 执行sql
		List<ShopCategory> categoryNames = shopCategoryService.selectCategory(id);
		return Msg.success().add("categoryName", categoryNames);
	}

	/**
	 * 添加新的门店分类名称
	 * 
	 * @param id 门店分类id
	 * @return
	 */
	@RequestMapping(value = "/insertNewCategoryName", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertNewCategoryName(String categoryName) {
		// 创建一个对象
		ShopCategory ShopCategory = new ShopCategory();
		ShopCategory.setCategoryName(categoryName);
		// 执行sql
		int val = shopCategoryService.insertNewCategoryName(ShopCategory);
		if (val == 1) {
			return Msg.success().add("msg", "添加成功！");
		} else {
			return Msg.fail().add("msg", "添加失败！");
		}
	}

	/**
	 * 删除门店分类名称
	 * 
	 * @param id 门店分类id
	 * @return
	 */
	@RequestMapping(value = "/deleCategoryName", method = RequestMethod.POST)
	@ResponseBody
	public Msg deleCategoryName(Integer id) {
		// 创建一个对象
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setId(id);
		// 执行sql
		int val = shopCategoryService.deleteByPrimaryKey(id);
		if (val == 1) {
			return Msg.success().add("msg", "删除成功！");
		} else {
			return Msg.fail().add("msg", "删除失败！");
		}
	}

	/**
	 * 修改门店分类名称
	 * 
	 * @param id           门店分类表ID
	 * @param categoryName 分类名称
	 * @return
	 */
	@RequestMapping(value = "/updateCategoryName", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateCategoryName(Integer id, String categoryName) {
		// 创建一个对象
		ShopCategory shopCategory = new ShopCategory();
		// 设置 门店分类表ID
		shopCategory.setId(id);
		// 设置分类名称
		shopCategory.setCategoryName(categoryName);
		// 执行sql
		int val = shopCategoryService.updateByPrimaryKeySelective(shopCategory);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 查询商家门店图片
	 * 
	 * @param sid             门店sid
	 * @param pictureCategory 图片分类：1门店，2大堂，3后厨，4其他
	 * @return
	 */
	@RequestMapping(value = "/selectShopPicture", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectShopPicture(Integer sid, Integer pictureCategory) {
		if (sid == null || pictureCategory == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		ShopPicture shopPic = new ShopPicture();
		// 设置门店sid
		shopPic.setSid(sid);
		// 设置图片分类
		shopPic.setPictureCategory(pictureCategory);
		// 执行sql
		List<ShopPicture> pic = shopPictureService.selectShopPicture(shopPic);

		return Msg.success().add("pic", pic);

	}

	/**
	 * 查询商家门店图片某个分类的数量
	 * 
	 * @param sid             门店sid
	 * @param pictureCategory 图片分类：1门店，2大堂，3后厨，4其他
	 * @return
	 */
	@RequestMapping(value = "/selectShopCountpic", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectShopCountpic(Integer sid, Integer pictureCategory) {
		// 判断参数不为空
		if (sid == null || pictureCategory == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行SQL
		int num = shopPictureService.selectShopCountpic(sid, pictureCategory);
		System.out.println("------" + num);
		return Msg.success().add("num", num);

	}

	/**
	 * 修改门店照片
	 * 
	 * @param id 商家相册表 id
	 * @return
	 */
	@RequestMapping(value = "/updateShopPic", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateShopPic(Integer id, String imgStr) {
		// 创建一个对象
		ShopPicture pic = new ShopPicture();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置商家相册表 id
		pic.setId(id);
		// 设置照片路径
		pic.setPicture(path);
		// 执行sql
		int val = shopPictureService.updateByPrimaryKeySelective(pic);
		System.out.println("-----" + val);
		if (val > 0) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 删除门店照片
	 * 
	 * @param id 商家相册表 id
	 * @return
	 */
	@RequestMapping(value = "/deleteShopPic", method = RequestMethod.POST)
	@ResponseBody
	public Msg deleteShopPic(Integer id) {
		// 执行sql
		int val = shopPictureService.deleteByPrimaryKey(id);
		System.out.println("-----" + val);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 添加门店照片
	 * 
	 * @param id              商家相册表 id
	 * @param sid             商家门店ID
	 * @param pictureCategory 商家照片分类
	 * @return
	 */
	@RequestMapping(value = "/insertShopPic", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertShopPic(String imgStr, Integer sid, Integer pictureCategory) {
		// 创建一个对象
		ShopPicture pic = new ShopPicture();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置商家门店ID
		pic.setSid(sid);
		// 设置商家照片分类
		pic.setPictureCategory(pictureCategory);
		// 设置照片路径
		pic.setPicture(path);
		// 执行sql
		int val = shopPictureService.insertShopPic(pic);

		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 查询门店照片认证状态
	 * 
	 * @param id 商家相册表 id
	 * @return
	 */
	@RequestMapping("/selectShopPicStatus")
	@ResponseBody
	public Msg selectShopPicStatus(Integer id) {
		if (id == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql
		ShopPicture sps = shopPictureService.selectShopPicStatus(id);

		if (sps == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("sps", sps);

	}
	//测试用
//	@RequestMapping("/selectAll")
//	@ResponseBody
//	public void selectAll(Integer id) {
//      ShopPicture sps = shopPictureService.selectAll();
//      System.out.println("====="+sps);
//     
//	}
}
