package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.OrderMapper;
import com.sm.dao.PackageCategoryMapper;
import com.sm.dao.PackageDetailMapper;
import com.sm.dao.PackageMapper;
import com.sm.model.Package;
import com.sm.model.PackageCategory;
import com.sm.model.PackageDetail;

@Service
public class PackageService {
	
	@Autowired
	private PackageMapper packageMapper;
	@Autowired
	private PackageDetailMapper packageDetailMapper;
	@Autowired
	private PackageCategoryMapper packageCategoryMapper;
	@Autowired
	private OrderMapper orderMapper;
	
	//通过商家id查询到套餐并排序
	public List<Package> selectBySid(Integer sid){
		return packageMapper.selectBySid(sid);
	}
	
	//通过商家id查询到所有套餐不排序
	public List<Package> selectPackageAllBySid(Integer sid){
		return packageMapper.selectPackageAllBySid(sid);
	}
	
	//通过商家id查询所有套餐类别
	public List<PackageCategory> selectCategoryBySid(Integer sid){
		return packageCategoryMapper.selectCategoryBySid(sid);
	}
	
	//通过套餐类别id查询套餐当前类的所有套餐
	public List<Package> selectByPackageCategory(Integer packageCategory){
		return packageMapper.selectByPackageCategory(packageCategory);
	}
	public List<Package> selectByPackageCategorySale(Integer packageCategory){
		return packageMapper.selectByPackageCategorySale(packageCategory);
	}
	public List<Package> selectByPackageCategoryStock(Integer packageCategory){
		return packageMapper.selectByPackageCategoryStock(packageCategory);
	}
	
	
	//通过套餐id查询到套餐
	public Package selectById(Integer id){
		return packageMapper.selectById(id);
	}
	
	//通过套餐库存为0的查询库存不足的个数
	public int selectByPackageAll(Integer sid) {
		return packageMapper.selectByPackageAll(sid);
	}
	
	//通过套餐状态（上下架） 查询此状态的个数
	public int selectByPackageStatus(Integer sid, Integer packageStatus) {
		return packageMapper.selectByPackageStatus(sid, packageStatus);
	}
	
	//通过套餐库存为0的查询库存不做的个数
	public int selectByCurrentStock(Integer sid, Integer CurrentStock) {
		return packageMapper.selectByCurrentStock(sid, CurrentStock);
	}
	
	//通过套餐对象修改套餐
	public int updateByPrimaryKeySelective(Package record) {
		return packageMapper.updateByPrimaryKeySelective(record);
	}
	
	//通过套餐类别id删除套餐类别
    public int delectCategoryById(Integer id) {
    	return packageCategoryMapper.deleteByPrimaryKey(id);
    }
	
	//通过套餐id删除套餐
	public int delectById(Integer id) {
		return packageMapper.deleteByPrimaryKey(id);
	}
	
	//通过套餐id删除套餐详情
	public int delectByIdPackage(Integer packageId) {
		return packageDetailMapper.delectByPackageId(packageId);
	}
	
	//通过商家id和上下架状态查询套餐
	public List<Package> selectBySidStatus(Integer sid, Integer packageStatus,Integer packageCategory) {
		return packageMapper.selectBySidStatus(sid, packageStatus,packageCategory);
	}
	
	//通过商家id和库存为0的查询套餐
	public List<Package> selectBySidStock(Integer sid, Integer currentStock,Integer packageCategory) {
		return packageMapper.selectBySidStock(sid, currentStock,packageCategory);
	}
	
	//通过商家id和库存为0的查询套餐
	public List<Package> selectBySidPackageName(Integer sid, String packageName) {
		return packageMapper.selectBySidPackageName(sid, packageName);
	}
	
	//通过次日置满开关查询有哪些套餐。
    public List<Package> selectPackageByOpen(Integer opens){
		return packageMapper.selectPackageByOpen(opens);
    }
    
    //通过套餐分类id查询套餐类别
    public PackageCategory selectCategoryByPackageId(Integer id) {
    	return packageCategoryMapper.selectByPrimaryKey(id);
    }
    
    //通过单个菜品id查询单个菜品对象
    public PackageDetail selectDetailByPackageId(Integer id) {
    	return packageDetailMapper.selectByPrimaryKey(id);
    }
    
    //通过套餐类别对象修改套餐排序方式
    public int updateSortModeByPackageCategory(PackageCategory record) {
    	return packageCategoryMapper.updateByPrimaryKeySelective(record);
    }
    
    //通过菜品对象修改菜品排序方式
    public int updateSortModeByDetail(PackageDetail record) {
    	return packageDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    //通过套餐类别对象插入套餐类别
    public int insertCategoryBySid(PackageCategory record) {
    	return packageCategoryMapper.insertSelective(record);
    }
    
    //通过套餐id查询套餐中的单品详情
    public List<PackageDetail> selectPackageDetailById(Integer packageId){
    	return packageDetailMapper.selectPackageDetailById(packageId);
    }
    
    //通过套餐对象插入套餐
    public int insertSelective(Package record) {
		return packageMapper.insertSelective(record);
    }

    //通过套餐id查询昨日的销量并按当日销量排序
	public int selectNumberByOneDay(Integer packageId) {
		return orderMapper.selectNumberByOneDay(packageId);
	}
	
    //通过套餐id查询近七日/近30日的销量并按当周/当月销量排序
	public int selectNumberByWeek(Integer packageId,Integer times) {
		return orderMapper.selectNumberByWeek(packageId,times);
	}
	
	//通过套餐id和用户输入的时间段查询套餐以及销量排序
	public int selectNumberByTimeInterval(Integer packageId,String startTime, String endTime) {
		return orderMapper.selectNumberByTimeInterval(packageId,startTime,endTime);
	}

    
}
