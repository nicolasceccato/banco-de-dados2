package com.bancodedados2.academia.repository;

import com.bancodedados2.academia.entities.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, String> {
}
