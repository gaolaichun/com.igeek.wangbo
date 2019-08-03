package com.sm.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;

import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class ImageUtil {
	public static String saveFile(String path, MultipartFile pic) throws IllegalStateException, IOException {
		String originalFileName = pic.getOriginalFilename();
		// 新的图片名称
		String newFileName = UUIDUtils.getUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
		// 新的图片
		File newFile = new File(path + newFileName);
		// 文件夹路径不存在
		if (!newFile.exists() && !newFile.isDirectory()) {
			newFile.mkdirs();
		}
		// 将内存中的数据写入磁盘
		pic.transferTo(newFile);
		return newFileName;
	}

	public static String saveFile2(MultipartFile pic) throws IllegalStateException, IOException {
		String path = "C://upload//fault//";

		String originalFileName = pic.getOriginalFilename();
		// 新的图片名称
		String newFileName = UUIDUtils.getUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
		// 新的图片
		File newFile = new File(path + newFileName);
		// 文件夹路径不存在
		if (!newFile.exists() && !newFile.isDirectory()) {
			newFile.mkdirs();
		}
		// 将内存中的数据写入磁盘
		pic.transferTo(newFile);
		return newFileName;
	}

	public static void delPicture(String basepath, String pictures) {
		if (pictures == null || "".equals(pictures))
			return;
		String[] arr = pictures.split(",");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && !"".equals(arr[i])) {
				File file = new File(basepath + arr[i]);
				if (file.exists()) {
					file.delete();
				}
			}
		}
	}

	// 图片转化成base64字符串
	public static String GetImageStr() {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		String imgFile = "D:\\tupian\\a.jpg";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		//BASE64Encoder encoder = new BASE64Encoder();
		return "";// 返回Base64编码过的字节数组字符串
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
			// String imgFilePath = "D:\\tupian\\new.jpg";//新生成的图片
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
		System.out.println("iWidth:" + iWidth);
		int iHeight = i.getHeight(null);
		System.out.println("iHeight:" + iHeight);
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

}
