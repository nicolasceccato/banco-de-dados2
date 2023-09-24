package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listAllAlunos() {
        List<Aluno> list = alunoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Aluno> findByCpf(@PathVariable String cpf) {
        Aluno aluno = alunoService.findById(cpf);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@Valid @RequestBody Aluno aluno) {
        aluno = alunoService.save(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(aluno.getCpf()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Aluno> editAluno(@PathVariable String cpf, @RequestBody Aluno aluno) {
        aluno = alunoService.update(cpf, aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable String cpf) {
        alunoService.deleteById(cpf);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/plano/{idPlano}")
    public ResponseEntity<List<Aluno>> findAlunosByPlano(@PathVariable Long idPlano) {
        List<Aluno> alunos = alunoService.findAlunosByPlanoId(idPlano);
        return ResponseEntity.ok().body(alunos);
    }

}
