package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Treino;
import com.bancodedados2.academia.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }


    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino findById(Long id) {
        Treino treino = treinoRepository.findById(id).get();
        return treino;
    }

    public Optional<Treino> deleteById(Long id) {
        Optional<Treino> treino = treinoRepository.findById(id);
        treinoRepository.deleteById(id);
        return treino;
    }
}
