package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Treino;
import com.bancodedados2.academia.repositories.TreinoRepository;
import com.bancodedados2.academia.services.exceptions.DatabaseException;
import com.bancodedados2.academia.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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

    public void deleteById(Long id) {
        try {
            if (treinoRepository.existsById(id)) {
                treinoRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Treino update(Long id, Treino treino) {
        try {
            Treino entity = treinoRepository.getReferenceById(id);
            updateData(entity, treino);
            return treinoRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Treino entity, Treino treino) {
        entity.setNomeDoTreino(treino.getNomeDoTreino());
        entity.setDescricao(treino.getDescricao());
    }

    public Long contagemDeAlunosPorTreino(Long idTreino) {
        Treino treino = treinoRepository.findById(idTreino)
                .orElseThrow(() -> new EntityNotFoundException("Treino não encontrado para o ID: " + idTreino));

        return treinoRepository.countAlunosByTreino(treino);
    }
    public Long contagemDeInstrutoresPorTreino(Long idTreino) {
        Treino treino = treinoRepository.findById(idTreino)
                .orElseThrow(() -> new EntityNotFoundException("Treino não encontrado para o ID: " + idTreino));

        return treinoRepository.countInstrutoresByTreino(treino);
    }

}
