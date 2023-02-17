package br.mrc.tupidone.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.mrc.tupidone.domain.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

	
	@Query(value = " select t from Tarefa t where t.usuario.id = :id ")
	List<Tarefa> findAllByUsuarioId(@Param("id") Integer id);
}
