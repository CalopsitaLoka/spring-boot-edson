package com.fatec.grupo5.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fatec.grupo5.model.Vaga;

public interface MantemVaga {
	List<Vaga> consultaTodos();

	Optional<Vaga> consultaPorId(Long id);

	Optional<Vaga> save(@Valid Vaga vaga);

	void delete(Long id);

	Optional<Vaga> atualiza(Vaga vaga);
}
