package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
//   List<Aluno> findAllByIdPlano(Long idPlano);
}
