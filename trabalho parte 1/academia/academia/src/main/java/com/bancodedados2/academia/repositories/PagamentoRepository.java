package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @Query("SELECT p FROM Pagamento p WHERE p.aluno.cpf = :cpf")
    List<Pagamento> findPagamentosPorAluno(@Param("cpf") String cpf);

}
