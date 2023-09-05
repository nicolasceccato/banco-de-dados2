package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.entities.Plano;
import com.bancodedados2.academia.repositories.AlunoRepository;
import com.bancodedados2.academia.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<Plano> findAll() {
        return planoRepository.findAll();
    }


    public Plano save(Plano plano) {
        return planoRepository.save(plano);
    }

    public Plano findById(Long id) {
        Plano plano = planoRepository.findById(id).get();
        return plano;
    }

    public Optional<Plano> deleteById(Long id) {
        Optional<Plano> plano = planoRepository.findById(id);
        planoRepository.deleteById(id);
        return plano;
    }
}
