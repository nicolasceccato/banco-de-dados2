package com.bancodedados2.academia.services;

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
}
