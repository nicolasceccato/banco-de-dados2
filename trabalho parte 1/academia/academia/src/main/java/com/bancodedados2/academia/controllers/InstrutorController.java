package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Instrutor;
import com.bancodedados2.academia.services.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(201).body(instrutorService.save(instrutor));
    }

    @PutMapping
    public ResponseEntity<Instrutor> editInstrutor(@RequestBody Instrutor instrutor) {
        return ResponseEntity.status(200).body(instrutorService.save(instrutor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> deleteInstrutor(@PathVariable Long id) {
        instrutorService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
