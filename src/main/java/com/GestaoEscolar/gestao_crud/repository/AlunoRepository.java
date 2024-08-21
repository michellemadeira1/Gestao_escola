package com.GestaoEscolar.gestao_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestaoEscolar.gestao_crud.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	List<Aluno> findAllByNomeContainingIgnoreCase(String nome);
}
