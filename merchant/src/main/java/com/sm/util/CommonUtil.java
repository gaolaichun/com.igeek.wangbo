package com.sm.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.springframework.web.multipart.MultipartFile;

import com.sm.util.SMSBean;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import Decoder.BASE64Decoder;



public class CommonUtil {
	public static ConcurrentHashMap<String, Object> MSG_MAP = new ConcurrentHashMap<String, Object>();
	public static long MOBILECODEEXPIRETIME=5*60*1000;
	
	
	
	/**获取客户端真实IP地址*/  
	public static String getIpAddr(HttpServletRequest request) {  
	       String ip = request.getHeader("x-forwarded-for");  
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	           ip = request.getHeader("Proxy-Client-IP");  
	       }  
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	           ip = request.getHeader("WL-Proxy-Client-IP");  
	       }  
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	           ip = request.getRemoteAddr();  
	       }  
	       return ip;  
	  }
	
	
	
	public static String saveFile(MultipartFile pic) throws IllegalStateException, IOException{
		Date date = new Date();
		String path = "C:\\upload\\file\\";
		String filePath = DateUtil.formatTime(date, "yyyy-MM") +"/" +DateUtil.formatTime(date, "yyyy-MM-dd");
		File fileDirDay = new File((path.replace("\\","/") + filePath));
		if(!fileDirDay.exists()){
			fileDirDay.mkdirs();
		}
		path += filePath.replace("/","\\") + "\\";
        String originalFileName = pic.getOriginalFilename();
        // 新的图片名称
        String newFileName = UUIDUtils.getUUID()+ originalFileName.substring(originalFileName.lastIndexOf("."));
        // 新的图片
        File newFile = new File(path + newFileName);
        // 将内存中的数据写入磁盘
        pic.transferTo(newFile);
		return "/file/" + filePath + "/" + newFileName;
	}
	/**
	 * 
	 * 保存文件
	 * @param pic
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String saveFileNotTime(MultipartFile pic) throws IllegalStateException, IOException{
		//Date date = new Date();
		String path = "C:\\upload\\app\\";
		File fileDirDay = new File(path.replace("\\","/"));
		if(!fileDirDay.exists()){
			fileDirDay.mkdirs();
		}
		String originalFileName = pic.getOriginalFilename();
		
		File newFile = new File(path + originalFileName);
		// 将内存中的数据写入磁盘
		pic.transferTo(newFile);
		return "/pic/app/" + originalFileName;
	}
	
	public static String imgStr(String imgStr) throws IOException{
        OutputStream out=null;
        
        Date date = new Date();
        String path = "C:\\upload\\";
        String filePath = DateUtil.formatTime(date, "yyyy-MM") +"/" +DateUtil.formatTime(date, "yyyy-MM-dd");
        File fileDirDay = new File((path.replace("\\","/") + filePath));
        if(!fileDirDay.exists()){
        	fileDirDay.mkdirs();
        }
        path += filePath.replace("/","\\") + "\\";
        String newFileName = UUIDUtils.getUUID()+".png";//新生成的图片  
        
        BASE64Decoder decoder = new BASE64Decoder();
        try {
        	byte[] bytes = decoder.decodeBuffer(imgStr);
            for(int i = 0; i < bytes.length; ++i){
    			if (bytes[i] < 0) {
    				bytes[i] += 256;
    			}
    		}
            out = new FileOutputStream(path + newFileName);
            out.write(bytes);  
            out.flush();
            out.close();
		} finally {
			if(out!=null)out.close();
		}
        return "/pic/" + filePath + "/" + newFileName;
	}
	
	public static String videoStr(String imgStr) throws IOException{
        OutputStream out=null;
        
        Date date = new Date();
        String path = "C:\\upload\\";
        String filePath = DateUtil.formatTime(date, "yyyy-MM") +"/" +DateUtil.formatTime(date, "yyyy-MM-dd");
        File fileDirDay = new File((path.replace("\\","/") + filePath));
        if(!fileDirDay.exists()){
        	fileDirDay.mkdirs();
        }
        path += filePath.replace("/","\\") + "\\";
        String newFileName = UUIDUtils.getUUID()+".avi";//新生成的视频
        
        BASE64Decoder decoder = new BASE64Decoder();
        try {
        	byte[] bytes = decoder.decodeBuffer(imgStr);
            for(int i = 0; i < bytes.length; ++i){
    			if (bytes[i] < 0) {
    				bytes[i] += 256;
    			}
    		}
            out = new FileOutputStream(path + newFileName);
            out.write(bytes);  
            out.flush();
            out.close();
		} finally {
			if(out!=null)out.close();
		}
        return "/pic/" + filePath + "/" + newFileName;
	}
	
	//客户端生成自己的唯一订单号
	public static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        String rdmStr="";
        for(int i=0;i<5;i++){
        	rdmStr=rdmStr+String.valueOf(r.nextInt(10));
        }
        key = key + rdmStr;
        return key;
    }
	
	public static void main(String[]s) {
		String num=CommonUtil.getOutTradeNo();
		System.out.println(num);
	}
	
	/**
     * 将分转换为元 如：1 分= 0.01元
     * @param price
     * @return
     */
    public static String fenToYuan(String price){
        BigDecimal sourcePrice = new BigDecimal(price);//原始价格 单位元
        BigDecimal b2 = new BigDecimal("100");//将元换算为分的单位 100
        String tfee=Double.toString(sourcePrice.divide(b2).doubleValue());
        // 订单金额
        return tfee;
    }
    
    //随机生成四位数字的提取码
    public static String randomCode(){
    	String str="0123456789";
    	StringBuilder sb=new StringBuilder(4);
    	for(int i=0;i<4;i++)
    	{
    	     char ch=str.charAt(new Random().nextInt(str.length()));
    	     sb.append(ch);
    	}
   
		return sb.toString();
    }
    
    public static String pathUrl(){
    	Date date = new Date();
		String path = "C:\\upload\\file\\";
		String filePath = DateUtil.formatTime(date, "yyyy-MM") +"/" +DateUtil.formatTime(date, "yyyy-MM-dd");
		File fileDirDay = new File((path.replace("\\","/") + filePath));
		if(!fileDirDay.exists()){
			fileDirDay.mkdirs();
		}
		return "/file/" + filePath + "/"+UUIDUtils.getUUID()+".jpg";
    }
    
 // base64字符串转化成图片
 	public static boolean GenerateImage(String imgStr, String savepath) { // 对字节数组字符串进行Base64解码并生成图片
 		if (imgStr == null) // 图像数据为空
 			return false;
 		BASE64Decoder decoder = new BASE64Decoder();
 		try {
 			// Base64解码
 			byte[] b = decoder.decodeBuffer(imgStr);
 			for (int i = 0; i < b.length; ++i) {
 				if (b[i] < 0) {// 调整异常数据
 					b[i] += 256;
 				}
 			}

 			// 生成jpeg图片
 		    //String imgFilePath = "D:\\tupian\\new.jpg";//新生成的图片
 			OutputStream out = new FileOutputStream(savepath);
 			out.write(b);
 			out.flush();
 			out.close();
 			compressPic(savepath);// 压缩图片
 			return true;
 		} catch (Exception e) {
 			return false;
 		}
 	}
 	
 	
 	
 	
 	public static void compressPic(String path) throws IOException {
		resize(new File(path), new File(path), 480, 0.7f);
	}

	/**
	 * 
	 * @param originalFile 原文件
	 * @param resizedFile  压缩目标文件
	 * @param newWidth     压缩后的图片宽度
	 * @param quality      压缩质量（0到1之间，越高质量越好）
	 * @throws IOException
	 */
	public static void resize(File originalFile, File resizedFile, int newWidth, float quality) throws IOException {

		if (quality > 1) {
			throw new IllegalArgumentException("Quality has to be between 0 and 1");
		}

		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;

		int iWidth = i.getWidth(null);
		//System.out.println("iWidth:" + iWidth);
		int iHeight = i.getHeight(null);
		//System.out.println("iHeight:" + iHeight);
		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight, newWidth, Image.SCALE_SMOOTH);
		}

		// 获取图片中的所有像素
		Image temp = new ImageIcon(resizedImage).getImage();

		// 创建缓冲
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

		// 复制图片到缓冲流中
		Graphics g = bufferedImage.createGraphics();

		// 清除背景并开始画图
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// 柔和图片.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);

		FileOutputStream out = new FileOutputStream(resizedFile);

		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);

		param.setQuality(quality, true);

		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);
		bufferedImage.flush();
		out.close();
	}
 	
	/****
	 * @param msg_uuid 验证码的uuid
	 * 验证手机验证码***/
	public static String verifyMobileCode(String mobile,String mobileCode){
		if(mobile==null||mobileCode==null){
			return "请输入手机号和手机验证码";
		}
		SMSBean smsBean = (SMSBean) MSG_MAP.get(mobile);
		if(smsBean==null){
			return "请获取验证码";
		}
		if(!smsBean.getValue().equals(mobileCode)){
			return "验证码错误";
		}
		if( new Date().getTime()-smsBean.getSendDate().getTime() > MOBILECODEEXPIRETIME){
			return "验证码过期,请重新获取";
		}
		MSG_MAP.remove(mobile);
		return null;
		
	}
}
