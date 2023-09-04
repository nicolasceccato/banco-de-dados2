package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }


    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno findById(String cpf) {
        Aluno aluno = alunoRepository.findById(cpf).get();
        return aluno;
    }

    public Optional<Aluno> deleteById(String cpf) {
        Optional<Aluno> aluno = alunoRepository.findById(cpf);
        alunoRepository.deleteById(cpf);
        return aluno;
    }
}
