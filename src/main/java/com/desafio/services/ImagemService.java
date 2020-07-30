package com.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Imagem;
import com.desafio.repositories.ImagemRepository;
import com.desafio.services.exceptions.ObjectNotFoundException;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository repository;
	
	public Imagem find(Integer id) {
		Optional<Imagem> img = repository.findById(id);
		return img.orElseThrow(() -> new ObjectNotFoundException("Imagem não encontrada"));
	}
	
	private void adicionarAcesso(Imagem img) {
		img.setNumAcessos(img.getNumAcessos()+1);
	}
	
	public Imagem insert(Imagem img) {
		return repository.save(img);
	}
	
	public Imagem update (Imagem updatedImg) {
		find(updatedImg.getId());
		return repository.save(updatedImg);
	}
	
	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}
	
	/*private updateImage(Imagem oldImg, new Img) {
		
	}*/
	
}
