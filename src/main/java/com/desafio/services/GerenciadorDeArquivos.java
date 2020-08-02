package com.desafio.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GerenciadorDeArquivos {

	private String imagePath = new String("frontend\\src\\assets");

	FileUtils fileUtils = new FileUtils();
	
	public void uploadFile(MultipartFile file, String imageId) throws IOException{
		Path diretorio = Paths.get(imagePath).resolve(imageId+".png");
		file.transferTo(diretorio);
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
