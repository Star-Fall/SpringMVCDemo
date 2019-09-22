package com.starfall.springmvc.demo.controller;

import com.starfall.springmvc.response.ApiResult;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.controller
 * @className ControllerDemo5
 * @date 2019/9/8 18:22
 * @description 文件上传下载
 */
@Controller
@RequestMapping("/demo5")
public class ControllerDemo5 extends BaseController {

	private final static String DEFAULTPATH = "D:/temp/";

	/**
	 * form 表单上传单个文件
	 *
	 * @param fileName
	 *            上传后的文件名称
	 * @param filePath
	 *            上传后的文件路径
	 * @param file
	 *            上传的文件
	 * @return 返回视图
	 * @throws IOException
	 */
	@RequestMapping(value = "/testFileUpLoad", method = RequestMethod.POST)
	public String testFileUpLoad(@RequestParam(value = "fileName", required = false) String fileName,
			@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "file") MultipartFile file) throws IOException {
		if (file != null && !file.isEmpty()) {
			// 原文件名
			String originalFilename = file.getOriginalFilename();
			if (fileName == null) {
				fileName = originalFilename;
			}
			// 默认路径
			if (filePath == null) {
				filePath = DEFAULTPATH;
			}
			// 复制文件到指定路径
			File temp = new File(filePath, fileName);
			if (!temp.exists()) {
				temp.mkdirs();
			}
			file.transferTo(temp);
		}
		return "main5.html";
	}

	/**
	 * ajax上传单个文件
	 *
	 * @param fileName
	 *            上传后的文件名称
	 * @param filePath
	 *            上传后的文件路径
	 * @param file
	 *            上传的文件
	 * @return 上传结果
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/testFileUpLoad/ajax", method = RequestMethod.POST)
	public Map<String, Object> testFileUpLoadAjax(@RequestParam(value = "fileName", required = false) String fileName,
			@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

		if (file == null || file.isEmpty()) {
			return ApiResult.ERROR.getMap("文件不能为空！");
		}
		// 原文件名
		String originalFilename = file.getOriginalFilename();
		if (fileName == null) {
			fileName = originalFilename;
		}
		// 默认路径
		if (filePath == null) {
			filePath = DEFAULTPATH;
		}
		// 复制文件到指定路径
		File temp = new File(filePath, fileName);
		if (!temp.exists()) {
			temp.mkdirs();
		}
		file.transferTo(temp);
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * AJAX 上传多个文件
	 *
	 * @param filePath
	 *            文件路径
	 * @param files
	 *            多个文件
	 * @return 上传结果
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/testFileUpLoad/ajax/multi", method = RequestMethod.POST)
	public Map<String, Object> testFileUpLoadAjaxMulti(
			@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "files", required = false) MultipartFile[] files) throws IOException {

		if (files == null || files.length <= 0) {
			return ApiResult.ERROR.getMap("文件不能为空！");
		}
		// 循环获取file数组中得文件
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			// 原文件名
			String fileName = file.getOriginalFilename();
			// 默认路径
			if (filePath == null) {
				filePath = DEFAULTPATH;
			}
			File temp = new File(filePath, fileName);
			if (!temp.exists()) {
				temp.mkdirs();
			}
			file.transferTo(temp);
		}
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * 读取文件列表
	 *
	 * @param filePath
	 *            文件路径
	 * @return 文件列表
	 */
	@ResponseBody
	@RequestMapping(value = "/readFileList", method = RequestMethod.GET)
	public Map<String, Object> readFileList(@RequestParam(value = "filePath", required = false) String filePath) {
		if (filePath == null) {
			filePath = DEFAULTPATH;
		}
		List<String> fileList = new ArrayList<String>();
		File directory = new File(filePath);
		if (directory.exists() && directory.isDirectory()) {
			for (File file : directory.listFiles()) {
				if (file.isFile()) {
					fileList.add(file.getName());
				}
			}
		} else if (!directory.exists()) {
			return ApiResult.ERROR.getMap("文件路径不存在");
		} else if (!directory.isDirectory()) {
			return ApiResult.ERROR.getMap("文件路径不是文件夹");
		}
		return ApiResult.SUCCESS.getMap().add("data", fileList);
	}

	/**
	 * 检查文件是否存在
	 *
	 * @param filePath
	 *            路径
	 * @param files
	 *            文件
	 * @return 检查结果
	 */
	@ResponseBody
	@RequestMapping(value = "/downLoadFile/check")
	public Map<String, Object> downLoadFileCheck(@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "files[]", required = false) List<String> files) {
		if (files == null || files.size() == 0) {
			return ApiResult.ERROR.getMap("文件不能为空！");
		}
		if (filePath == null) {
			filePath = DEFAULTPATH;
		}
		// 单文件
		if (files.size() == 1) {
			String fileName = files.get(0);
			File file = new File(filePath + fileName);
			if (!file.exists()) {
				return ApiResult.ERROR.getMap("文件不存在，请重新读取文件列表！");
			}
		} else {
			File file = null;
			for (String fileName : files) {
				file = new File(filePath + fileName);
				if (!file.exists()) {
					return ApiResult.ERROR.getMap("文件不存在，请重新读取文件列表！");
				}
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("filePath", filePath);
		map.put("files", files);
		return ApiResult.SUCCESS.getMap().add("data", map);
	}

	/**
	 * 下载文件
	 *
	 * @param filePath
	 *            文件路径
	 * @param files
	 *            文件
	 * @return 下载结果
	 */
	@RequestMapping(value = "/downLoadFile", method = RequestMethod.POST)
	public ResponseEntity<byte[]> downLoadFile(@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "files", required = false) List<String> files) throws IOException {
		if (files == null || files.size() == 0) {
			return null;
			// TODO 抛出异常
		}
		if (filePath == null) {
			filePath = DEFAULTPATH;
		}
		File file = null;
		if (files.size() == 1) {
			// 单个文件，直接取list中第一个
			file = new File(filePath + files.get(0));
		} else {
			// 多个文件，需要将文件压缩，下载压缩包文件
			String zipFileName = "D:/temp/temp.zip";
			file = zipFiles(filePath, files, zipFileName);
		}
		// 设置响应头
		HttpHeaders httpHeaders = new HttpHeaders();
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 通知浏览器以attachment（下载方式）
		httpHeaders.setContentDispositionFormData("attachment",
				new String(file.getName().getBytes("UTF-8"), "iso-8859-1"));
		// FileUtils.readFileToByteArray(file):使用二进制流读取文件
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders,
				HttpStatus.CREATED);
		return responseEntity;
	}

	/**
	 * 压缩文件
	 *
	 * @param filePath
	 *            文件路径
	 * @param fileNames
	 *            文件名称列表
	 * @param zipFileName
	 *            压缩包名称
	 * @return 压缩包文件
	 * @throws IOException
	 */
	private File zipFiles(String filePath, List<String> fileNames, String zipFileName) throws IOException {
		File zipFile = new File(zipFileName);
		// 输出流读取zip文件
		FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
		// 创建压缩输出流
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		// 文件输入流，写入到压缩流中
		FileInputStream fileInputStream = null;
		// 压缩包文件列表中的列表项
		ZipEntry zipEntry = null;
		// 遍历的文件
		File file = null;
		for (String fileName : fileNames) {
			// 将文件添加到压缩包列表中
			file = new File(filePath + fileName);
			zipEntry = new ZipEntry(file.getName());
			zipOutputStream.putNextEntry(zipEntry);
			// 文件写入压缩包中
			fileInputStream = new FileInputStream(file);
			int len = 0;
			byte[] buffer = new byte[1024];
			while (-1 != (len = fileInputStream.read(buffer))) {
				zipOutputStream.write(buffer, 0, len);
			}
			// 关闭文件输入流
			fileInputStream.close();
		}
		// 关闭压缩输出流
		zipOutputStream.close();
		return zipFile;
	}

}
