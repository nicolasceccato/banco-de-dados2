package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.repositories.AlunoRepository;
import com.bancodedados2.academia.services.exceptions.DatabaseException;
import com.bancodedados2.academia.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }


    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno findById(String cpf) {
        Optional<Aluno> aluno = alunoRepository.findById(cpf);
        return aluno.orElseThrow(() -> new ResourceNotFoundException(cpf));
    }

    public void deleteById(String cpf) {
        try {
            if (alunoRepository.existsById(cpf)) {
                alunoRepository.deleteById(cpf);
            } else {
                throw new ResourceNotFoundException(cpf);
            }

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    public Aluno update(String cpf, Aluno aluno) {
        Aluno entity = alunoRepository.getReferenceById(cpf);
        updateData(entity, aluno);
        return alunoRepository.save(entity);
    }

    private void updateData(Aluno entity, Aluno aluno) {
        entity.setNome(aluno.getNome());
        entity.setEmail(aluno.getEmail());
        entity.setBairro(aluno.getBairro());
        entity.setPlano(aluno.getPlano());
        entity.setCep(aluno.getCep());
        entity.setNumeroDaCasa(aluno.getNumeroDaCasa());
        entity.setRua(aluno.getRua());
        entity.setTelefone(aluno.getTelefone());
    }
}
