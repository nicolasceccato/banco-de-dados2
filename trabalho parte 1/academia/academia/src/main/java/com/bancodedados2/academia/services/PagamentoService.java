package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Pagamento;
import com.bancodedados2.academia.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }


    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id).get();
        return pagamento;
    }

    public Optional<Pagamento> deleteById(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        pagamentoRepository.deleteById(id);
        return pagamento;
    }
}
