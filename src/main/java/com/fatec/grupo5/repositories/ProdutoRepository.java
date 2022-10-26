package com.fatec.grupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.grupo5.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Produto findByProdutoId(Long codigo);
}
