package br.mrc.tupidone.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mrc.tupidone.domain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	

}
