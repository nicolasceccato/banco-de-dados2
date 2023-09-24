package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Instrutor;
import com.bancodedados2.academia.services.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> listAllInstrutors() {
        List<Instrutor> list = instrutorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> findById(@PathVariable Long id) {
        Instrutor instrutor = instrutorService.findById(id);
        return ResponseEntity.ok().body(instrutor);
    }

    @PostMapping
    public ResponseEntity<Instrutor> createInstrutor(@Valid @RequestBody Instrutor instrutor) {
        instrutor = instrutorService.save(instrutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{matricula}").buildAndExpand(instrutor.getMatricula()).toUri();
        return ResponseEntity.created(uri).body(instrutor);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Instrutor> editInstrutor(@PathVariable Long matricula, @RequestBody Instrutor instrutor) {
        instrutor = instrutorService.update(matricula, instrutor);
        return ResponseEntity.ok().body(instrutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> deleteInstrutor(@PathVariable Long id) {
        instrutorService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/instrutores-alunos")
    public ResponseEntity<List<Object[]>> getInstrutoresAndNumAlunos() {
        List<Object[]> instrutores = instrutorService.getInstrutoresAndNumAlunos();
        return ResponseEntity.ok().body(instrutores);
    }


}
