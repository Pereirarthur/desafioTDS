package com.desafio.services;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.desafio.domain.Imagem;
import com.desafio.repositories.ImagemRepository;
import com.desafio.services.exceptions.ChaveErradaException;
import com.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository repository;
	
	@Autowired
	private GerenciadorDeArquivos gerenciador;
	
	private Random rand = new Random();
	
	public Imagem find(Integer id) {
		Optional<Imagem> img = repository.findById(id);
		return img.orElseThrow(() -> new ObjectNotFoundException("Imagem não encontrada"));
	}
	
	public void adicionarAcesso(Imagem img) {
		img.setNumAcessos(img.getNumAcessos()+1);
		update(img);
	}
	
	public Imagem insert(MultipartFile file) throws IOException{
		Imagem img = new Imagem(null, null, 0);
		img.setChaveRemocao(generate_chaveRemocao());
		Imagem savedImg = repository.save(img);
		copyImage(file, img);
		return savedImg;
	}
	
	private void copyImage(MultipartFile file, Imagem img) throws IOException{
		gerenciador.uploadFile(file, img.getId().toString());
	}
	
	private String generate_chaveRemocao() {
		String chaveGerada = "";
		for(int i=0;i<2;i++) {
			int randomNumber = rand.nextInt(10);
			chaveGerada += String.valueOf(randomNumber);
		}
		return chaveGerada;
	}
	
	public Imagem update (Imagem updatedImg) {
		find(updatedImg.getId());
		return repository.save(updatedImg);
	}
	
	public void delete(Integer id, String chaveRemocao) {
		if (!chaveRemocao.equals(find(id).getChaveRemocao())) {
			throw new ChaveErradaException("Chave de Remoção Incorreta!");
		}else {
			deleteImage(id.toString());
			repository.deleteById(id);			
		}
	}
	
	private void deleteImage(String imgId){
		gerenciador.deleteFile(imgId);
	}
	
}
