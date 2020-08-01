package com.desafio.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.domain.Imagem;
import com.desafio.services.GerenciadorDeArquivos;
import com.desafio.services.ImagemService;
import com.fasterxml.jackson.databind.node.TextNode;


@RestController
@RequestMapping(value = "/imagens")
public class ImagemResource {
	
	@Autowired
	private ImagemService service;
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Imagem> find(@PathVariable Integer id) {
		Imagem img = service.find(id);
		service.adicionarAcesso(img);
		return ResponseEntity.ok().body(img);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Imagem img) {
		img = service.insert(img);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(img.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@RequestBody Imagem updatedImg, @PathVariable Integer id){
		updatedImg.setId(id);
		updatedImg = service.update(updatedImg);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody TextNode chaveRemocao) {
		service.delete(id, chaveRemocao.asText());
		return ResponseEntity.noContent().build();
	}
}
