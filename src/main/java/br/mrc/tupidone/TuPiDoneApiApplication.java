package br.mrc.tupidone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.mrc.tupidone.domain.entities.Tarefa;
import br.mrc.tupidone.domain.repositories.TarefaRepository;

@SpringBootApplication
public class TuPiDoneApiApplication {

	
	@Bean(name = "iniciarTeste")
	public CommandLineRunner init(@Autowired TarefaRepository tarefas) {
		
		return args -> {
			
			List<Tarefa> listaTarefa = tarefas.findAllByUsuarioId(1);
			listaTarefa.forEach( t -> System.out.println(t.getTitulo()));
			
		};
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TuPiDoneApiApplication.class, args);
	}

}
