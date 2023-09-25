package com.bancodedados2.academia.ui;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AlunoClient {

    private final String BASE_URL = "http://localhost:8080/alunos"; // Altere conforme a URL do seu serviço

    private RestTemplate restTemplate;

    public AlunoClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<Aluno> listarAlunos() {
        ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL, List.class);
        return response.getBody();
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        ResponseEntity<Aluno> response = restTemplate.getForEntity(BASE_URL + "/" + cpf, Aluno.class);
        return response.getBody();
    }
}
