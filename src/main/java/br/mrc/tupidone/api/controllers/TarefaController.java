package br.mrc.tupidone.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
