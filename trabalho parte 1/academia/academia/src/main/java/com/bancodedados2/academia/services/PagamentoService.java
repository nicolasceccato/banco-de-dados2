package com.bancodedados2.academia.services;

import com.bancodedados2.academia.entities.Pagamento;
import com.bancodedados2.academia.repositories.PagamentoRepository;
import com.bancodedados2.academia.services.exceptions.ResourceNotFoundException;
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
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Optional<Pagamento> deleteById(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        pagamentoRepository.deleteById(id);
        return pagamento;
    }

    public Pagamento update(Long id, Pagamento pagamento) {
        Pagamento entity = pagamentoRepository.getReferenceById(id);
        updateData(entity, pagamento);
        return pagamentoRepository.save(entity);
    }

    private void updateData(Pagamento entity, Pagamento pagamento) {
        entity.setDataDoPagamento(pagamento.getDataDoPagamento());
    }

}
