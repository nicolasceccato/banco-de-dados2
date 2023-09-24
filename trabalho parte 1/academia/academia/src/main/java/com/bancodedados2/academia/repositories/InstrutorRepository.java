package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

    //Relatório 2: Apresente os instrutores e seus respectivos alunos, ordenados por número de alunos.
//    @Query("SELECT i, COUNT(a) FROM Instrutor i JOIN i.treinos t JOIN t.alunos a GROUP BY i ORDER BY COUNT(a) DESC")
//    List<Object[]> findInstrutoresAndAlunosCount();
    @Query("SELECT i, COUNT(a) as numAlunos FROM Instrutor i " +
            "LEFT JOIN i.treinos t " +
            "LEFT JOIN t.alunos a " +
            "GROUP BY i " +
            "ORDER BY numAlunos DESC")
    List<Object[]> findInstrutoresAndNumAlunos();
}
