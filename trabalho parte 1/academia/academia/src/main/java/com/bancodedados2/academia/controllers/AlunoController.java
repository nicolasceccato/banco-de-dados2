package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping
    public Aluno editAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

//    @DeleteMapping("/{cpf}")
//    public Optional<Aluno> deleteAluno(@PathVariable String cpf) {
//        Optional<Aluno> aluno = alunoService.findById(cpf);
//        alunoService.deleteById(cpf);
//        return aluno;
//    }

}
