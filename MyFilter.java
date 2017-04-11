package com.gmail.s12348.evgen;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {
	private String[] fileArray;

	public MyFilter(String... fileArray) {
		super();
		this.fileArray = fileArray;
	}

	private boolean check(String ext) {
		for (String stringExt : fileArray) {
			if (stringExt.equals(ext)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File pathname) {
		int pointerIndex = pathname.getName().lastIndexOf(".");
		if (pointerIndex == -1) {
			return false;
		}
		String ext = pathname.getName().substring(pointerIndex + 1);
		return check(ext);
	}

}
