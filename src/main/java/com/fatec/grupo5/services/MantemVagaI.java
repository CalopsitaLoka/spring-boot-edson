package com.fatec.grupo5.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.grupo5.model.Vaga;
import com.fatec.grupo5.model.VagaRepository;

@Service
public class MantemVagaI implements MantemVaga {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	VagaRepository repository;

	public List<Vaga> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<Vaga> consultaPorId(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<Vaga> save(Vaga vaga) {
		logger.info(">>>>>> servico save chamado ");
		Optional<Vaga> umaVaga = consultaPorId(vaga.getId());

		if (umaVaga.isEmpty()) {
			logger.info(">>>>>> servico save - dados validos");
			return Optional.ofNullable(repository.save(vaga));
		} else {
			return Optional.empty();
		}

	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Vaga> atualiza(Vaga vaga) {
		logger.info(">>>>>> 1.servico altera vaga chamado");
		Optional<Vaga> umVaga = consultaPorId(vaga.getId());
		if (umVaga.isPresent()) {
			Vaga vagaModificado = new Vaga(vaga.getNome(), vaga.getStatus(), vaga.getResumo(), vaga.getSalario(),
					vaga.getCurso(), vaga.getHabilidades());
			vagaModificado.setId(vaga.getId());
			logger.info(">>>>>> 2. servico altera vaga cep valido para o id => " + vagaModificado.getId());
			return Optional.ofNullable(repository.save(vagaModificado));
		} else {
			return Optional.empty();
		}
	}

	
}
