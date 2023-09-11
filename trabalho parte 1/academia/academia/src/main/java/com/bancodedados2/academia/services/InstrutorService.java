package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Instrutor;
import com.bancodedados2.academia.entities.Instrutor;
import com.bancodedados2.academia.repositories.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Instrutor instrutor = instrutorRepository.findById(id).get();
        return instrutor;
    }

    public Optional<Instrutor> deleteById(Long id) {
        Optional<Instrutor> instrutor = instrutorRepository.findById(id);
        instrutorRepository.deleteById(id);
        return instrutor;
    }

    public Instrutor update(Long id, Instrutor instrutor) {
        Instrutor entity = instrutorRepository.getReferenceById(id);
        updateData(entity, instrutor);
        return instrutorRepository.save(entity);
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
