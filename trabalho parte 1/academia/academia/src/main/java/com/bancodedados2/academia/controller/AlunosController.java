package com.bancodedados2.academia.controller;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    @GetMapping
    public List<Aluno> listAllAlunos() {
        return alunosRepository.findAll();
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunosRepository.save(aluno);
    }

    @PutMapping
    public Aluno editAluno(@RequestBody Aluno aluno) {
        return alunosRepository.save(aluno);
    }

    @DeleteMapping("/{cpf}")
    public Optional<Aluno> deleteAluno(@PathVariable String cpf) {
        Optional<Aluno> aluno = alunosRepository.findById(cpf);
        alunosRepository.deleteById(cpf);
        return aluno;
    }

}
