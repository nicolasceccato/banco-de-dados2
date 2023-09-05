package com.bancodedados2.academia.controllers;

import com.bancodedados2.academia.entities.Plano;
import com.bancodedados2.academia.services.PlanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<Plano>> listAllPlanos() {
        List<Plano> list = planoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> findByCpf(@PathVariable Long id) {
        Plano plano = planoService.findById(id);
        return ResponseEntity.ok().body(plano);
    }

    @PostMapping
    public ResponseEntity<Plano> createPlano(@Valid @RequestBody Plano plano) {
        return ResponseEntity.status(201).body(planoService.save(plano));
    }

    @PutMapping
    public ResponseEntity<Plano> editPlano(@RequestBody Plano plano) {
        return ResponseEntity.status(200).body(planoService.save(plano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plano> deletePlano(@PathVariable Long id) {
        planoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
