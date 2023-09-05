package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

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
        return ResponseEntity.status(201).body(alunoService.save(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> editAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(200).body(alunoService.save(aluno));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable String cpf) {
        alunoService.deleteById(cpf);
        return ResponseEntity.status(204).build();
    }

}
