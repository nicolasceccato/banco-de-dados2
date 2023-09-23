package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
