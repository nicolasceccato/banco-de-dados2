package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Instrutor;
import com.bancodedados2.academia.repositories.InstrutorRepository;
import com.bancodedados2.academia.services.exceptions.DatabaseException;
import com.bancodedados2.academia.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> findAll() {
        return instrutorRepository.findAll();
    }


    public Instrutor save(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public Instrutor findById(Long id) {
        Optional<Instrutor> instrutor = instrutorRepository.findById(id);
        return instrutor.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) {
        try {
            if (instrutorRepository.existsById(id)) {
                instrutorRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Instrutor update(Long id, Instrutor instrutor) {
        try {
            Instrutor entity = instrutorRepository.getReferenceById(id);
            updateData(entity, instrutor);
            return instrutorRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Instrutor entity, Instrutor instrutor) {
        entity.setNome(instrutor.getNome());
        entity.setEmail(instrutor.getEmail());
        entity.setBairro(instrutor.getBairro());
        entity.setCep(instrutor.getCep());
        entity.setNumeroDaCasa(instrutor.getNumeroDaCasa());
        entity.setRua(instrutor.getRua());
        entity.setTelefone(instrutor.getTelefone());
        entity.setCargo(instrutor.getCargo());
    }

}
