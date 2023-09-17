package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AlunoRepository extends JpaRepository<Aluno, String> {


    //jpql
//    @Query("SELECT COUNT(a) FROM Aluno a JOIN a.treinos t WHERE t.idTreino = :treinoId AND t.dataDoTreino = :dataTreino")
//    Long countAlunosByTreinosAndData(@Param("treinoId") Long treinoId, @Param("dataTreino") Date dataTreino);

//    Long countAlunosByTreinos(Long idTreino);

}
