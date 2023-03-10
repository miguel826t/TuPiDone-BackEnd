package br.mrc.tupidone.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Tarefa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "titulo", length = 100)
	private String  titulo;
	@Column(name = "descricao", length = 100)
	private String  descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataCriacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataFinalizacao;
	
	@OneToMany(mappedBy = "tarefa")
	private List<ItensTarefa> itens = new ArrayList<ItensTarefa>();
	
	/* ======* Construtores *====== */
	public Tarefa() {
		
	}
	
	public Tarefa(
			Usuario usuario, 
			String titulo,
			String descricao
			){
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = LocalDateTime.now();
	}
	
	public Tarefa(
			Usuario usuario, 
			String titulo
			){
		this.usuario = usuario;
		this.titulo = titulo;
		this.dataCriacao = LocalDateTime.now();
	}
	
	
	/* ======* Metodos publicos *====== */
	public Integer itensConcluidos() {
		return itens.stream()
				.filter(i -> i.isConcluido())
				.collect(Collectors.toList()).size();
	}

	public boolean isConcluida() {
		return dataFinalizacao != null;
	}

	public void finalizar() {
		this.dataFinalizacao = LocalDate.now();
	}
	
	
}
