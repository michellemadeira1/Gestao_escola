package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import model.Aluno;
import repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos); // Retorna 200 OK com a lista de alunos
    }

    public ResponseEntity<Aluno> salvar(Aluno aluno) {
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo); // Retorna 201 Created com o aluno salvo
    }

    public ResponseEntity<Aluno> buscarPorId(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            return ResponseEntity.ok(alunoOptional.get()); // Retorna 200 OK com o aluno encontrado
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found
        }
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
            return ResponseEntity.ok(alunoAtualizadoSalvo); // Retorna 200 OK com o aluno atualizado
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found
        }
    }

    public ResponseEntity<Void> deletar(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id); // Exclui o aluno do banco de dados
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found
        }
    }
}