package com.sm.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class Common {
	
    public static double divide(double v1, double v2,int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale).doubleValue(); 
    }
	// 生成15位订单号
	public static String getOrderNumber() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		Date date = new Date();
		String str = sdf.format(date).substring(2, 17);
		return str;
	}

	public static String getRandomString() {
		String str = "";
		for (int i = 0; i < 4; i++) {
			str += (int) (Math.random() * 10);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		Date date = new Date();
		str = "ZMR" + sdf.format(date) + str;

		return str;
	}

	// 四位数验证码
	public static String getRandomCode() {
		String str = "";
		for (int i = 0; i < 4; i++) {
			int a = (int) (Math.random() * 10);
			str = str + a;
		}
		return str;
	}

	private static double EARTH_RADIUS = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 通过经纬度获取距离(单位：米)
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static int getDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000d) / 10000d;
		s = s * 1000;
		return (int) s;
	}

	public static String[] getArea(String lon, String lat) {
		// lat 31.2990170 纬度
		// log 121.3466440 经度
		String add = getAdd(lon, lat);
		JSONObject jsonObject = JSONObject.fromObject(add);
		JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("addrList"));
		JSONObject j_2 = JSONObject.fromObject(jsonArray.get(0));
		String allAdd = j_2.getString("admName");
		String arr[] = allAdd.split(",");
		System.out.println("省:" + arr[0] + "\n市:" + arr[1] + "\n区:" + arr[2]);
		return arr;
	}

	public static String getAdd(String log, String lat) {
		// lat 小 log 大
		// 参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
		String urlString = "http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + log + "&type=010";
		String res = "";
		try {
			URL url = new URL(urlString);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				res += line + "\n";
			}
			in.close();
		} catch (Exception e) {
			System.out.println("error in wapaction,and e is " + e.getMessage());
		}
		System.out.println(res);
		return res;
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	public static Map<String, Integer> calcRoughly(Date startDate, Date endDate) {
		// 以分钟为单位进行统计
		long dayTime = 0;
		long nightTime = 0;
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long startCurMinutes = calcCurMinutes("20:00:00");
		long endCurMinutes = calcCurMinutes("08:00:00");
		while (startTime <= endTime) {
			long modTime = ((startTime + 8 * 60 * 60 * 1000) / (1000 * 60)) % (24 * 60);
			if (modTime >= endCurMinutes && modTime < startCurMinutes) {
				dayTime += 1;
			} else {
				nightTime += 1;
			}
			startTime += (1000 * 60);
		}
		int r1 = (int) Math.ceil((double) dayTime / 60);
		int r2 = (int) Math.ceil((double) nightTime / 60);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("t1", r1);// 白天
		map.put("t2", r2);
		return map;
	}

	public static long calcCurMinutes(String time) {
		String pattern = "\\d{2}:\\d{2}:\\d{2}";
		if (Pattern.matches(pattern, time)) {
			int hour = Integer.valueOf(time.substring(0, 2));
			int minutes = Integer.valueOf(time.substring(3, 5));
			return hour * 60 + minutes;
		}
		return 0;
	}

	public static JSONArray setObjectToJson(Object object) {
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
		JSONArray jsonArray = JSONArray.fromObject(object, cfg);
		return jsonArray;
	}

	/*
	 * public static boolean Qrcode(String qrData, String url) throws IOException {
	 * Qrcode qrcode = new Qrcode(); qrcode.setQrcodeErrorCorrect('M');//
	 * 纠错等级（分为L、M、H三个等级） qrcode.setQrcodeEncodeMode('B');// N代表数字，A代表a-Z，B代表其它字符
	 * qrcode.setQrcodeVersion(7);// 版本 // 生成二维码中要存储的信息 // 设置一下二维码的像素 int width = 67
	 * + 12 * (7 - 1); int height = 67 + 12 * (7 - 1); BufferedImage bufferedImage =
	 * new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 绘图
	 * Graphics2D gs = bufferedImage.createGraphics();
	 * gs.setBackground(Color.WHITE); gs.setColor(Color.BLACK); gs.clearRect(0, 0,
	 * width, height);// 清除下画板内容
	 * 
	 * // 设置下偏移量,如果不加偏移量，有时会导致出错。 int pixoff = 2;
	 * 
	 * byte[] d = qrData.getBytes("gb2312"); if (d.length > 0 && d.length < 120) {
	 * boolean[][] s = qrcode.calQrcode(d); for (int i = 0; i < s.length; i++) { for
	 * (int j = 0; j < s.length; j++) { if (s[j][i]) { gs.fillRect(j * 3 + pixoff, i
	 * * 3 + pixoff, 3, 3); } } } } gs.dispose(); bufferedImage.flush();
	 * ImageIO.write(bufferedImage, "png", new File(url)); return true; }
	 */

	/**
	 * 
	 * 
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url     发送请求的 URL
	 * 
	 * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param isproxy 是否使用代理模式
	 * @return 所代表远程资源的响应结果
	 */

	static boolean proxySet = false;
	static String proxyHost = "127.0.0.1";
	static int proxyPort = 0;

	public static String sendPost(String url, String param, boolean isproxy) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = null;
			if (isproxy) {// 使用代理模式
				@SuppressWarnings("static-access")
				Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
				conn = (HttpURLConnection) realUrl.openConnection(proxy);
			} else {
				conn = (HttpURLConnection) realUrl.openConnection();
			}
			// 打开和URL之间的连接

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST"); // POST方法

			// 设置通用的请求属性

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			conn.connect();

			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	// 链接url下载图片
	public static boolean downloadPicture(String urlList, String path) {
		URL url = null;
		try {
			url = new URL(urlList);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());

			FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String replaceEmoji(String str) {
		if (!hasEmoji(str)) {
			return str;
		} else {
			str = str.replaceAll("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", " ");
			return str;
		}

	}

	public static boolean hasEmoji(String content) {
		Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]");
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
		int n = gbkStr.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = gbkStr.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			return tmp;
		}
		return utfBytes;
	}

	public static String gbEncoding(String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int i = 0; i < utfBytes.length; i++) {
			String hexB = Integer.toHexString(utfBytes[i]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}

	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
						}

					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

	public static int getReward(int i, int type, List<String> list) {
		if (type == 1) {
			switch (i) {
			case 11:
				return Integer.valueOf(list.get(1));
			case 12:
				return Integer.valueOf(list.get(2));
			case 13:
				return Integer.valueOf(list.get(3));
			case 21:
				return Integer.valueOf(list.get(7));
			case 22:
				return Integer.valueOf(list.get(8));
			case 23:
				return Integer.valueOf(list.get(9));
			case 31:
				return Integer.valueOf(list.get(13));
			case 32:
				return Integer.valueOf(list.get(14));
			case 33:
				return Integer.valueOf(list.get(15));
			}
		} else {
			switch (i) {
			case 11:
				return Integer.valueOf(list.get(4));
			case 12:
				return Integer.valueOf(list.get(5));
			case 13:
				return Integer.valueOf(list.get(6));
			case 21:
				return Integer.valueOf(list.get(10));
			case 22:
				return Integer.valueOf(list.get(11));
			case 23:
				return Integer.valueOf(list.get(12));
			case 31:
				return Integer.valueOf(list.get(16));
			case 32:
				return Integer.valueOf(list.get(17));
			case 33:
				return Integer.valueOf(list.get(18));
			}
		}
		return 0;
	}
}
