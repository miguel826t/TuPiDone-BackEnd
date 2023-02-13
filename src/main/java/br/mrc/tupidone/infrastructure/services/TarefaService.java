package br.mrc.tupidone.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrc.tupidone.domain.entities.Tarefa;
import br.mrc.tupidone.domain.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	public List<Tarefa> findAll(){
		return repository.findAll();
	}

	public Optional<Tarefa> findById(Integer id) {
		return repository.findById(id);
	}
	
	
}
