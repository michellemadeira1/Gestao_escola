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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
@Tag(name = "Alunos", description = "Endpoints para gerenciar alunos")
public class AlunoController {

	 @Autowired
	    private AlunoService alunoService;

	 
	 
	
	    @Operation(description = "Obtém a lista de todos os alunos cadastrados.")
	    @GetMapping("/todos")
	    public ResponseEntity<List<Aluno>> listarTodos() {
	        return alunoService.listarTodos();
	    }
	    
	        
	    
	    @Operation(description = "Cria e cadastra um novo aluno no sistema.")
	    @PostMapping("/cadastrar")
	    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
	        return alunoService.salvar(aluno);
	    }

	    
	    
	    @Operation(description = "Obtém os detalhes de um aluno específico pelo seu ID.")
	    @GetMapping("/{id}")
	    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
	        return alunoService.buscarPorId(id);
	    }
	    
	    
	    
	    @Operation(description = "Busca e retorna alunos com base em um nome fornecido.")
	    @GetMapping("/buscarPorNome/{nome}")
	    public ResponseEntity<List<Aluno>> buscarPorNome(@PathVariable String nome) {
	        return alunoService.buscarPorNome(nome);
	    }

	 
	    
	    @Operation(description = "Atualiza os detalhes de um aluno específico com base em seu ID.")
	    @PutMapping("/atualizar/{id}")
	    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
	        return alunoService.atualizar(id, alunoAtualizado);
	    }

	    
	    
	    @Operation(description = "Deleta um aluno específico com base em seu ID.")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        return alunoService.deletar(id);
	    }
}