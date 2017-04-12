package com.gmail.s12348.evgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFolder {

	public CopyFolder() {
	}

	public static void copyFolder(MyFilter ff) {
		File folderOne = new File("FolderOne");
		File[] fileList = folderOne.listFiles(ff);
		File folderTwo = new File("FolderTwo");
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
		File[] fileListOne = folderTwo.listFiles();
		for (File file : fileListOne) {
			System.out.println(file);
		}
	}

}
