package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Pagamento;
import com.bancodedados2.academia.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> listAllPagamentos() {
        List<Pagamento> list = pagamentoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.findById(id);
        return ResponseEntity.ok().body(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@Valid @RequestBody Pagamento pagamento) {
        pagamento = pagamentoService.save(pagamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPagamento}").buildAndExpand(pagamento.getIdPagamento()).toUri();
        return ResponseEntity.created(uri).body(pagamento);
    }

    @PutMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> editPagamento(@PathVariable Long idPagamento, @RequestBody Pagamento pagamento) {
        pagamento = pagamentoService.update(idPagamento, pagamento);
        return ResponseEntity.ok().body(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pagamento> deletePagamento(@PathVariable Long id) {
        pagamentoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/aluno/{cpf}")
    public ResponseEntity<List<Pagamento>> obterPagamentosPorAluno(@PathVariable String cpf) {
        List<Pagamento> pagamentos = pagamentoService.obterPagamentosPorAluno(cpf);
        return ResponseEntity.ok(pagamentos);
    }

}
