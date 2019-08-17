package com.igeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Administrator
 * @create 2019/05/10
 */
@Controller
public class UploadController {

    private static final String UPLOAD_BASE_PATH = "D:\\files\\";//定义图片上传根路径
    private static final String IMAGE_BASE_URL = "http://localhost:8086/pic/";//定义图片访问根路径
    /*
    * MultipartFile file 用于绑定前台传过来文件对象 file 形参名 必须与前台表单中的name属性一致
    * */
    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        //获取唯一的标识符作为文件名
        String fileName = UUID.randomUUID().toString();

        //获取文件原始文件名
        //System.out.println(file.getOriginalFilename());//a.b.jpg
        String originalFileName = file.getOriginalFilename();

        //拼接上传文件名
        fileName = fileName + originalFileName.substring(originalFileName.lastIndexOf("."));

        String uploadPath = UPLOAD_BASE_PATH+fileName;
        System.out.println("上传路径:"+uploadPath);


        try {
            //执行上传操作即可
            file.transferTo(new File(uploadPath));
            //将图片路径保存至数据库 http://localhost:8086/pic/c88ba14e-2a4b-4a8c-8516-63bb0f7b8b94.jpg
            String imageUrl = IMAGE_BASE_URL+fileName;//保存数据库
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
