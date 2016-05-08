package com.zjy.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author JH  2015
 */
public class FileUtils {
	public static void createFile(String path, String fileName, boolean createDir, byte[] content) {
		File dir = new File(path);
		if (!dir.exists() && createDir) {
			dir.mkdirs();
		}

		try {
			FileOutputStream fos = new FileOutputStream(path + fileName);
			fos.write(content);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void deleteFile(String dir, String fileName) {
		String dirLink = "/";
		String os = PropertyGetter.getString("common", "os.type", "windows");
		if (os.equalsIgnoreCase("windows"))
			dirLink = "\\";
		try {
			String filePath = dir + dirLink + fileName;
			filePath = filePath.toString();
			File file = new File(filePath);
			if (file.exists()) {
				if (file.isDirectory()) {
					delAllFile(filePath);
				} else {
					file.delete();
				}
			}
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	public static void deleteFile(String realPath) {
		try {
			String filePath = realPath;
			filePath = filePath.toString();
			File file = new File(filePath);
			if (file.exists()) {
				if (file.isDirectory()) {
					delAllFile(filePath);
				} else {
					file.delete();
				}
			}
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	static public boolean isImage(String type) {
		if (type == null)
			return false;
		if (type.equals("image/pjpeg"))
			return true;
		if (type.equals("image/bmp"))
			return true;
		if (type.equals("image/gif"))
			return true;
		if (type.equals("image/png"))
			return true;
		return false;
	}

	/**
	 * 删除指定文件夹
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); //删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); //删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定目录下所有文件（含文件夹）
	 * @param path
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);//再删除空文件夹
			}
		}
	}
	
	/**
	 * 获取文件或文件集合
	 * @param path 文件或文件夹路径
	 */
	public static File[] getAllFile(String path){
		File file = new File(path);
		if(file.isFile()){
			return new File[]{file};
		} else if(file.isDirectory()){
			return file.listFiles();
		}
		return null;
	}

	public static void main(String[] args) {
		//FileUtils.createFile("D:\\bap\\file\\", "1.txt", true);
		
	}

}
