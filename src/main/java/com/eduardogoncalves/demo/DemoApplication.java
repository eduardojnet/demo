package com.eduardogoncalves.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardogoncalves.demo.domain.Categoria;
import com.eduardogoncalves.demo.domain.Cidade;
import com.eduardogoncalves.demo.domain.Cliente;
import com.eduardogoncalves.demo.domain.Endereco;
import com.eduardogoncalves.demo.domain.Estado;
import com.eduardogoncalves.demo.domain.Produto;
import com.eduardogoncalves.demo.domain.enums.TipoCliente;
import com.eduardogoncalves.demo.repositories.CategoriaRepository;
import com.eduardogoncalves.demo.repositories.CidadeRepository;
import com.eduardogoncalves.demo.repositories.ClienteRepository;
import com.eduardogoncalves.demo.repositories.EnderecoRepository;
import com.eduardogoncalves.demo.repositories.EstadoRepository;
import com.eduardogoncalves.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Operação de Intanciação, criando o objeto Categoria
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria( null, "Informatica");
		Categoria cat2 = new Categoria( null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Notebook", 2500.00);
		Produto p3 = new Produto(null, "Impressora", 750.00);
				
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
				
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Belo Horizonte", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "03450859650", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3436628687", "11999328687"));
		
		Endereco end1 = new Endereco(null, "Rua Uruguai", "46", "Fundos", "Vila Castelo Branco", "13338110", cli1, cid1);
		Endereco end2 = new Endereco(null, "Rua Mathos", "506", "Apto 01", "Granja Julieta", "05500010", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		
		
	}

}
