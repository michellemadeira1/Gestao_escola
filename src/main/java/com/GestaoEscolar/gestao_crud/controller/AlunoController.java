package com.GestaoEscolar.gestao_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestaoEscolar.gestao_crud.model.Aluno;
import com.GestaoEscolar.gestao_crud.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
public class AlunoController {

	 @Autowired
	    private AlunoService alunoService;

	   
	    @GetMapping("/todos")
	    public ResponseEntity<List<Aluno>> listarTodos() {
	        return alunoService.listarTodos();
	    }

	    @PostMapping("/cadastrar")
	    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
	        return alunoService.salvar(aluno);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
	        return alunoService.buscarPorId(id);
	    }
	    
	    @GetMapping("/buscarPorNome/{nome}")
	    public ResponseEntity<List<Aluno>> buscarPorNome(@PathVariable String nome) {
	        return alunoService.buscarPorNome(nome);
	    }

	    @PutMapping("/atualizar/{id}")
	    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
	        return alunoService.atualizar(id, alunoAtualizado);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        return alunoService.deletar(id);
	    }
}