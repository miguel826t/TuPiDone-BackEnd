package br.mrc.tupidone.infrastructure.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrc.tupidone.domain.entities.ItensTarefa;
import br.mrc.tupidone.domain.entities.Tarefa;
import br.mrc.tupidone.domain.entities.Usuario;
import br.mrc.tupidone.domain.repositories.ItensTarefaRepository;
import br.mrc.tupidone.domain.repositories.TarefaRepository;
import br.mrc.tupidone.domain.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private TarefaRepository tarefas;
	@Autowired
	private ItensTarefaRepository itensTarefa;
	@Autowired
	private UsuarioRepository usuarios;
	
	public void instanciarDB() {
		Usuario user1 = new Usuario("MRC","mrc@gmail.com","123456");

		Tarefa t1 = new Tarefa(user1, "Compra no mercado", "Produtos que devo comprar ao ir no mercado");
		ItensTarefa i1 = new ItensTarefa("Pão",t1);
		ItensTarefa i2 = new ItensTarefa("Maça",t1);

		usuarios.saveAll(Arrays.asList(user1));
		tarefas.saveAll(Arrays.asList(t1));
		itensTarefa.saveAll(Arrays.asList(i1,i2));
	}

}
