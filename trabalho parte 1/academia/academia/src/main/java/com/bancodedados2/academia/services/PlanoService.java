package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Plano;
import com.bancodedados2.academia.repositories.PlanoRepository;
import com.bancodedados2.academia.services.exceptions.ResourceNotFoundException;
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
        Optional<Plano> plano = planoRepository.findById(id);
        return plano.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) {
        planoRepository.deleteById(id);
    }

    public Plano update(Long id, Plano plano) {
        Plano entity = planoRepository.getReferenceById(id);
        updateData(entity, plano);
        return planoRepository.save(entity);
    }

    private void updateData(Plano entity, Plano plano) {
        entity.setNomeDoPlano(plano.getNomeDoPlano());
        entity.setDescricao(plano.getDescricao());
    }
}
