package com.igeek.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	/**
	 * 发送邮件
	 * @param email			收件人
	 * @param title			邮件的标题
	 * @param emailMsg		邮件的内容
	 * @throws AddressException
	 * @throws MessagingException
	 */
	
	public static final String SEND_MAIL =  "18912480392@163.com";
	
	public static void sendMail(String email, String title,String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", "smtp.163.com");				//=> 1. 修改为发邮件的服务器的地址
		props.setProperty("mail.smtp.auth", "true");

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// => 2. 邮箱账号  授权密码
				return new PasswordAuthentication(SEND_MAIL, "wangbo1010");
							
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(SEND_MAIL)); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		message.setSubject(title);					// 	=> 传入的标题

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);				// => 邮件的征文
	}
}
