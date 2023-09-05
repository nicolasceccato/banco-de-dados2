package com.bancodedados2.academia.repositories;

import com.bancodedados2.academia.entities.Instrutor;
import com.bancodedados2.academia.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
}
