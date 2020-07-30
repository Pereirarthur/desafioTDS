package com.desafio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Imagem;

@RestController
@RequestMapping(value = "/imagens")
public class ImagemResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Imagem> Listar() {
		Imagem img = new Imagem(1, "www.imagem.com", "02", 0);
		
		List<Imagem> lista = new ArrayList<>();
		lista.add(img);
		
		return lista;
	}
	
}
