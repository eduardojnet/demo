package com.eduardogoncalves.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardogoncalves.demo.domain.Categoria;
import com.eduardogoncalves.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
				
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
