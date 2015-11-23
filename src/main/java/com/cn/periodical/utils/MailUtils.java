package com.cn.periodical.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public MailUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MailUtils.sendMail("jiangjj-0725@126.com","");
	}

	public static boolean sendMail(String toEmail,String content) {
		try {
			// 配置发送邮件的环境属性
			final Properties props = new Properties();
			PropertiesInitManager.dataInit();
			String auth=(String) PropertiesInitManager.PROPERTIES.get("mail.smtp.auth");
			String host= (String) PropertiesInitManager.PROPERTIES.get("mail.smtp.host");
			String userName=(String) PropertiesInitManager.PROPERTIES.get("mail.user");
			String passWord = (String) PropertiesInitManager.PROPERTIES.get("mail.password");
			/*
			 * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host
			 * / mail.user / mail.from
			 */

			// 表示SMTP发送邮件，需要进行身份验证
			props.put("mail.smtp.auth", auth);
			props.put("mail.smtp.host", host);
			// 发件人的账号
			props.put("mail.user", userName);
			// 访问SMTP服务时需要提供的密码
			props.put("mail.password", passWord);

			// 构建授权信息，用于进行SMTP进行身份验证
			Authenticator authenticator = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// 用户名、密码
					String userName = props.getProperty("mail.user");
					String password = props.getProperty("mail.password");
					return new PasswordAuthentication(userName, password);
				}
			};
			// 使用环境属性和授权信息，创建邮件会话
			Session mailSession = Session.getInstance(props, authenticator);
			// 创建邮件消息
			MimeMessage message = new MimeMessage(mailSession);
			// 设置发件人
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);

			// 设置收件人
			InternetAddress to = new InternetAddress(toEmail);
			message.setRecipient(RecipientType.TO, to);

			// 设置邮件标题
			message.setSubject(PropertiesInitManager.PROPERTIES.getProperty("mail.subject"));

			// 设置邮件的内容体
			message.setContent(content, "text/html;charset=UTF-8");

			// 发送邮件
			Transport.send(message);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
