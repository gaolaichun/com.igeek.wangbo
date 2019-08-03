package com.sm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sm.model.Package;

public interface PackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(Integer id);

    
    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKey(Package record);
    
    //通过商家id查询套餐不排序
    List<Package> selectPackageAllBySid(Integer sid);
    
    //通过商家id查询所有套餐
    List<Package> selectBySid(Integer sid);
    
    //通过套餐类别id查询套餐当前类的所有套餐并按默认排序
    List<Package> selectByPackageCategory(@Param("packageCategory")Integer packageCategory);
    //通过套餐类别id查询套餐当前类的所有套餐并按销量排序
    List<Package> selectByPackageCategorySale(@Param("packageCategory")Integer packageCategory);
    //通过套餐类别id查询套餐当前类的所有套餐并按库存排序
    List<Package> selectByPackageCategoryStock(@Param("packageCategory")Integer packageCategory);
    
    //通过套餐id查询套餐
    Package selectById(Integer id);
    
    //通过商家id查询商家全部商品数量
    int selectByPackageAll(Integer sid);
    
    //通过上下架状态查询其数量
    int selectByPackageStatus(@Param("sid")Integer sid, @Param("packageStatus")Integer packageStatus);
    
    //通过库存数为0的查询库存不足的数量
    int selectByCurrentStock(@Param("sid")Integer sid, @Param("currentStock")Integer currentStock);
    
    //通过商家id和上架状态查询套餐
    List<Package> selectBySidStatus(@Param("sid")Integer sid, @Param("packageStatus")Integer packageStatus,@Param("packageCategory")Integer packageCategory);
    
    //通过商家id和库存量查询套餐
    List<Package> selectBySidStock(@Param("sid")Integer sid, @Param("currentStock")Integer currentStock,@Param("packageCategory")Integer packageCategory);
    
    //通过商家id和套餐名查询套餐
    List<Package> selectBySidPackageName(@Param("sid")Integer sid, @Param("packageName")String packageName);
    
    //通过次日置满开关查询有哪些套餐(查询所有次日置满状态为1的套餐)。
    List<Package> selectPackageByOpen(Integer opens);
    
//    //根据套餐id修改套餐的是否置满状态
//    int updateOpensById(Integer id);
    
    //通过套餐类别id删除套餐
    int delectPackageByCategory(Integer packageCategory);
    
}

























