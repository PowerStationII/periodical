package com.cn.periodical.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesInitManager {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesInitManager.class);
	
	public static final Properties PROPERTIES = new Properties();
	public static void dataInit(){
		String app = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"app.properties";
//		信息: validateJarFile(E:\jiangjj\periodical_space\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\periodical\WEB-INF\lib\servlet-api-2.4.jar) - jar not loaded. See Servlet Spec 3.0, section 10.7.2. Offending class: javax/servlet/Servlet.class

		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(app));
			PROPERTIES.load(in);
		} catch (Exception e) {
			logger.error("读取app配置文件失败!", e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				logger.error("读取app配置文件,关闭流失败!", e);
			}finally{
				in = null;
			}
		}
	}
}
