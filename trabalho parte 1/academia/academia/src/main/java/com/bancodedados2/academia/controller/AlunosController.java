package com.bancodedados2.academia.controller;

import com.bancodedados2.academia.entities.Alunos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunosController {

    @GetMapping("/alunos")
    public String listAllAlunos() {
        return ("alunos");
    }
}
