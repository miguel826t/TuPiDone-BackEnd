package br.mrc.tupidone.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mrc.tupidone.domain.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
