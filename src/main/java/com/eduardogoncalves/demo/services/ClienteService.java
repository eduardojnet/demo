package com.eduardogoncalves.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardogoncalves.demo.domain.Categoria;
import com.eduardogoncalves.demo.domain.Cliente;
import com.eduardogoncalves.demo.repositories.CategoriaRepository;
import com.eduardogoncalves.demo.repositories.ClienteRepository;
import com.eduardogoncalves.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
				
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	}
}

