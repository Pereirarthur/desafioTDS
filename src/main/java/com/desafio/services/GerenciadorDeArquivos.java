package com.desafio.services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GerenciadorDeArquivos {

	private String imagePath = new String("frontend\\src\\assets");
	
	FileUtils fileUtils = new FileUtils();
	
	public void uploadFile(String filePath, String imageId) {
		System.out.println("ChegouAqui01");
		File originalFile = new File(filePath);
		System.out.println("ChegouAqui02");
		File copiedFile = new File(imagePath+"\\"+imageId+".png");
		System.out.println("ChegouAqui03");
		try {
			fileUtils.copyFile(originalFile, copiedFile);
			System.out.println("ChegouAqui04");
		}catch(IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void deleteFile(String imgId){
		File file = new File(imagePath+"\\"+imgId+".png");
		try {
			fileUtils.forceDelete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
