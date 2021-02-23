package com.gustavo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.bookstore.domain.Categoria;
import com.gustavo.bookstore.domain.Livro;
import com.gustavo.bookstore.repositories.CategoriaRepository;
import com.gustavo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	public void instaciaBaseDeDados () {
		
		Categoria cat1 = new Categoria(null,"informática","Livro de Informática");
		Categoria cat2 = new Categoria(null,"Filosofia","Humanismo");
		Categoria cat3 = new Categoria(null,"Literatura","Romance");
		
		Livro l1 = new Livro(null,"Clean Code","Robert Martin","Lorem ipsum",cat1);
		Livro l2 = new Livro(null,"O Homem Revoltado","Albert Camus","Lorem ipsum",cat2);
		Livro l3 = new Livro(null,"Mito de sisífo","Albert Camus","Lorem ipsum",cat2);
		Livro l4 = new Livro(null,"Metamorfose","Kafka","Lorem ipsum",cat3);
		Livro l5 = new Livro(null,"O estrangeiro","Albert Camus","Lorem ipsum",cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2,l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
