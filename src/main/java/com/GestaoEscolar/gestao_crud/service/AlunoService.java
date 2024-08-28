package com.GestaoEscolar.gestao_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.GestaoEscolar.gestao_crud.model.Aluno;
import com.GestaoEscolar.gestao_crud.repository.AlunoRepository;



@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos); 
    }
    

  

    public ResponseEntity<Aluno> salvar(Aluno aluno) {
        if (aluno.getId() != null && alunoRepository.findById(aluno.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Aluno novoAluno = alunoRepository.save(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    
    
    
    public ResponseEntity<Aluno> buscarPorId(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            return ResponseEntity.ok(alunoOptional.get()); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    
    
    
    public ResponseEntity<List<Aluno>> buscarPorNome(String nome) {
        List<Aluno> alunos = alunoRepository.findAllByNomeContainingIgnoreCase(nome);
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alunos);
    }


    public ResponseEntity<Aluno> atualizar(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setNotaPrimeiroSemestre(alunoAtualizado.getNotaPrimeiroSemestre());
            aluno.setNotaSegundoSemestre(alunoAtualizado.getNotaSegundoSemestre());
            aluno.setNomeProfessor(alunoAtualizado.getNomeProfessor());
            aluno.setNumeroSala(alunoAtualizado.getNumeroSala());
            Aluno alunoAtualizadoSalvo = alunoRepository.save(aluno);
            return ResponseEntity.ok(alunoAtualizadoSalvo); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }

    public ResponseEntity<Void> deletar(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id); 
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }
}