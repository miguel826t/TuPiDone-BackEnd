package br.mrc.tupidone.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItensTarefa {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataCriacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataFinalizacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tarefa_id")
	private Tarefa tarefa;
	
	/* ======* Construtor *====== */
	public ItensTarefa() {}
	
	public ItensTarefa(String titulo,Tarefa tarefa) {
		this.titulo = titulo;
		this.tarefa = tarefa;
		this.dataCriacao = LocalDateTime.now();
	}
	
	/* ======* Metodos publicos *====== */
	public boolean isConcluido() {
		return this.dataFinalizacao != null;
	}

	public void finalizar() {
		this.dataFinalizacao = LocalDate.now();
	}
	
	
	
}
