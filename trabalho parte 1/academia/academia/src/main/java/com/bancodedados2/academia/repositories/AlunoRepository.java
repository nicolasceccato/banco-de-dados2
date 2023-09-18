package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

}
