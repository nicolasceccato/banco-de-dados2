package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {

    //Relatório 1: Descreva os alunos matriculados em um determinado plano
    // No AlunoRepository
//    @Query("SELECT a FROM Aluno a WHERE a.plano.idPlano = :idPlano")
//    List<Aluno> findAlunosByPlanoId(@Param("idPlano") Long idPlano);

    //List<Aluno> findAlunoByPlano(Plano plano);

    @Query("SELECT a FROM Aluno a WHERE a.plano.idPlano = :idPlano")
    List<Aluno> findAlunosByPlanoId(@Param("idPlano") Long idPlano);


}
