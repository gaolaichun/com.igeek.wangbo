package com.sm.dao;

import com.sm.model.ShopPicture;
import com.sm.model.ShopPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopPictureMapper {
    int countByExample(ShopPictureExample example);

    int deleteByExample(ShopPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopPicture record);

    int insertShopPic(ShopPicture record);//添加新的门店照片
    
    int insertSelective(ShopPicture record);

    List<ShopPicture> selectByExample(ShopPictureExample example);

    ShopPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopPicture record, @Param("example") ShopPictureExample example);

    int updateByExample(@Param("record") ShopPicture record, @Param("example") ShopPictureExample example);

    int updateByPrimaryKeySelective(ShopPicture record);

    int updateByPrimaryKey(ShopPicture record);
    
    List<ShopPicture> selectShopPicture(ShopPicture record);//根据参数查询门店照片
    
//    List<ShopPicture> selectShopCountpic(ShopPicture record);
    int selectShopCountpic(@Param("sid")Integer sid, @Param("pictureCategory")Integer pictureCategory);
    
    int updateShopPic(ShopPicture record);
    
    ShopPicture selectShopPicStatus(Integer id);//查询个人身份认证认证状态
    
    ShopPicture selectAll();
}