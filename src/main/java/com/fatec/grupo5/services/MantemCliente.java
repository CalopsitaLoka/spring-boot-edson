package com.fatec.grupo5.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fatec.grupo5.model.Cliente;
public interface MantemCliente {
	List<Cliente> consultaTodos();

	Optional<Cliente> consultaPorCpf(String cpf);

	Optional<Cliente> consultaPorId(Long id);

	Optional<Cliente> save(@Valid Cliente cliente);

	void delete(Long id);

	Optional<Cliente> atualiza(Cliente cliente);
}
