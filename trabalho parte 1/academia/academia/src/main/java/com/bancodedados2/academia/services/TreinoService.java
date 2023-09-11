package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Treino;
import com.bancodedados2.academia.repositories.TreinoRepository;
import com.bancodedados2.academia.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    private TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }


    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino findById(Long id) {
        Optional<Treino> treino = treinoRepository.findById(id);
        return treino.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Optional<Treino> deleteById(Long id) {
        Optional<Treino> treino = treinoRepository.findById(id);
        treinoRepository.deleteById(id);
        return treino;
    }

    public Treino update(Long id, Treino treino) {
        Treino entity = treinoRepository.getReferenceById(id);
        updateData(entity, treino);
        return treinoRepository.save(entity);
    }

    private void updateData(Treino entity, Treino treino) {
        entity.setNomeDoTreino(treino.getNomeDoTreino());
        entity.setDescricao(treino.getDescricao());
    }
}
