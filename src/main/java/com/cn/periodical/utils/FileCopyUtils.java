package com.cn.periodical.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCopyUtils {

	public FileCopyUtils() {
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger = LoggerFactory.getLogger(FileCopyUtils.class);

	public static void main(String[] args){
		String oldPath="E:"+File.separator+"temp"+File.separator+"a412660db39145b1bb9af80fb83da998"+File.separator+"0c8290ecab4b4c029a330ecccf56185b"+File.separator;
		String newPath="F:"+File.separator+"sss"+File.separator;
		copyFile(oldPath,"1.bmp",newPath,"1.bmp");
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static void copyFile(String oldPath,String oldName, String newPath,String newName) {
		try {
			int bytesum = 0;
			int byteread = 0;
			StringBuffer oldFileAbslute=new StringBuffer();
			oldFileAbslute.append(oldPath);
			if(!"".equals(oldName)){
				oldFileAbslute.append(oldName);
			}
			File oldfile = new File(oldFileAbslute.toString());
			
			File newfile = new File(newPath);
			if(!newfile.exists()){
				newfile.mkdirs();
			}
			StringBuffer newFileAbslute=new StringBuffer();
			newFileAbslute.append(newPath);
			newFileAbslute.append(newName);
			
			logger.info("开始复制稿件信息:\n从["+oldFileAbslute.toString()+"]\n到["+newFileAbslute.toString()+"]");
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldFileAbslute.toString()); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newFileAbslute.toString());
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			logger.error("复制单个文件操作出错",e);
			e.printStackTrace();

		}

	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();

		}
	}
}
