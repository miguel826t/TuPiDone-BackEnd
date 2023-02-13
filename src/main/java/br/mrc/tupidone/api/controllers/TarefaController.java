package br.mrc.tupidone.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.mrc.tupidone.domain.entities.Tarefa;
import br.mrc.tupidone.infrastructure.services.TarefaService;

@RestController
@RequestMapping(value = {"/api/tarefas","/tarefas"})
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping
	@ResponseBody
	public List<Tarefa> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Tarefa> getTarefaById(@PathVariable Integer id){
		Optional<Tarefa> tarefa = service.findById(id);
		
		if(tarefa.isPresent()) {
			return ResponseEntity.ok(tarefa.get());
		}
		return ResponseEntity.notFound().build();
	}
	
}
