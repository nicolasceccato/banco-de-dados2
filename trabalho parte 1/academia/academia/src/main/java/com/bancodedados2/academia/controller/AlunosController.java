package com.bancodedados2.academia.controller;

import com.bancodedados2.academia.entities.Alunos;
import com.bancodedados2.academia.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    @GetMapping("/alunos")
    public List<Alunos> listAllAlunos() {
        return alunosRepository.findAll();
    }
}
