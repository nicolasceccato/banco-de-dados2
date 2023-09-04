package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
