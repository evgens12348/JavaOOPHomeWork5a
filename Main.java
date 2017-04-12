package com.gmail.s12348.evgen;

public class Main {

	public static void main(String[] args) {
		MyFilter ff = new MyFilter("doc");
		CopyFolder.copyFolder(ff);		
	}
}
