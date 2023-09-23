package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    //jpql
    @Query("SELECT COUNT(a) FROM Treino t JOIN t.alunos a WHERE t = :treino")
    Long countAlunosByTreino(@Param("treino") Treino treino);

    @Query("SELECT COUNT(i) FROM Treino t JOIN t.instrutores i WHERE t = :treino")
    Long countInstrutoresByTreino(@Param("treino") Treino treino);

}
