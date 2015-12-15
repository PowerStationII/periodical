package com.cn.periodical.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 上传下载导入导出等公用操作类
 * 
 * @author seven-song
 * 
 */
public class UtilLoad {

	/**
	 * 文件下载
	 * 
	 * @param fileName
	 *            要下载的文件名称
	 * @param filePath
	 *            要下载文件所在的路径 只需要传项目根目录后的路径
	 * @return
	 */
	public static Boolean fileDownload(HttpServletRequest request,
			HttpServletResponse response, String fileName, String filePath) {

		/*filePath = request.getSession().getServletContext().getRealPath("/")
				+ filePath;*/
		System.out.println("文件的下载路径为：" + filePath);
		response.reset();// 先清空之前的缓存信息
		response.setContentType("application/x-download");// 确保文件是下载的方式而不是浏览器中直接打开

		try {
			// 弹出下载对话框
			// 为了解决浏览器弹出下载框时框中的中文名称显示问题需要转换编码。
			// 为了解决火狐浏览器中文空格问题需加上\"\"来解决
			response.addHeader("Content-Disposition", "attachment;filename=\""
					+ new String(fileName.getBytes("gbk"), "ISO-8859-1") + "\"");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("文件下载方法中：文件名称编码异常！");
		}

		Boolean isReady = false;
		OutputStream os = null;
		FileInputStream fis = null;

		try {
			os = response.getOutputStream();
			// 文件名称需要正确的编码，否则涉及到中文时会乱码，导致无法下载
			// 项目中路径基本不用中文，所以不需要转码。
			fis = new FileInputStream(filePath
					+ new String(fileName.getBytes("utf-8"), "utf-8"));
			byte[] buffer = new byte[1024 * 10];
			for (int read; (read = fis.read(buffer)) != -1;) {
				os.write(buffer, 0, read);
			}
			os.close();
			fis.close();
			isReady = true;
		} catch (FileNotFoundException e) {
			System.out.println("文件下载方法中：文件【" + fileName + "】不存在！");
		} catch (Exception e) {
			// 如遇到ClientAbortException这种客户端异常，一般是因为IE浏览器下载过程中点了取消
			// 或者是连续点击下载导致的。该异常并不影响下载功能，所以捕获之后暂不做处理。
			System.out.println("文件下载方法中：捕获到ClientAbortException异常！");
			isReady = true;
		}

		return isReady;

	}

	/**
	 * 文件上传
	 * 
	 * @param filePath
	 *            要文件要上传到的路径 只需要传项目根目录后的路径
	 * @param tempPath
	 *            磁盘缓存路径 只需要传项目根目录后的路径
	 * @param fileSize
	 *            文件大小限制(字节） 
	 *            对于form提交方式，所有文件大小之和不能超过fileSize
	 *            对于uploadify提交方式：单个文件大小不能超过fileSize
	 * @return
	 */
	public synchronized static Boolean fileUpload(HttpServletRequest request,
			String filePath, String tempPath, int fileSize) {

		filePath = request.getSession().getServletContext().getRealPath("/")
				+ filePath;
		tempPath = request.getSession().getServletContext().getRealPath("/")
				+ tempPath;
		System.out.println("文件的上传路径为：" + filePath);
		System.out.println("文件的磁盘缓存路径为：" + tempPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置上传文件时的最大内存缓存上限，-1表示无上限
		// 如果文件大小超过了内存缓存，则超出部分会以.temp文件的形式保存到磁盘缓存目录下等待程序处理
		factory.setSizeThreshold(5 * 1024);
		// 设置文件的缓存路径 设置存放临时文件的目录
		factory.setRepository(new File(tempPath));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");// 设置编码格式，避免中文出现乱码问题
		// 设置文件最大上限
		// 对于form提交方式，所有文件大小之和不能超过上限
		// 对于uploadify提交方式：单个文件大小不能超过上限
		upload.setSizeMax(fileSize);

		Boolean isReady = false;

		// 上传文件 获取所有文件列表
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					// 文件名
					String fileName = item.getName();
					// 保存文件，其实就是把缓存里的数据写到目标路径下
					File uploadFile = new File(filePath + fileName);
					item.write(uploadFile);
				}
			}
			isReady = true;

		} catch (Exception e) {
			System.out.println("文件上传方法中：文件上传异常！");
			e.printStackTrace();
		}
		return isReady;
	}
}
