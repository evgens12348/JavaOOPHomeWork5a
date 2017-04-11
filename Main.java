package com.gmail.s12348.evgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		MyFilter ff = new MyFilter("doc");
		File folderOne = new File("FolderOne");
		File[] fileList = folderOne.listFiles(ff);
		File folderTwo = new File("FolderTwo");
		File[] fileListOne = folderTwo.listFiles();
		if (folderTwo.exists() == false) {
			folderTwo.mkdirs();
		}
		for (File fileOne : fileList) {
			File fileTwo = new File(folderTwo, fileOne.getName());
			try (FileInputStream fis = new FileInputStream(fileOne);
					FileOutputStream fos = new FileOutputStream(fileTwo)) {
				byte[] buffer = new byte[1024];
				int byteread = 0;
				for (; (byteread = fis.read(buffer)) > 0;) {
					fos.write(buffer, 0, byteread);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		for (File file : fileListOne) {
			System.out.println(file);
		}

	}

}
