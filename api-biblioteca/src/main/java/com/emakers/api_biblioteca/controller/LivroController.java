package com.emakers.api_biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;

import com.emakers.api_biblioteca.data.dto.request.LivroRequestDTO;
import com.emakers.api_biblioteca.data.dto.response.LivroResponseDTO;
import com.emakers.api_biblioteca.service.LivroService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LivroResponseDTO>> getAllLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAllLivros());
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroResponseDTO> getLivroById(@PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getLivroById(idLivro));
    }

    @PostMapping("/create")
    public ResponseEntity<LivroResponseDTO> createLivro(@Valid @RequestBody LivroRequestDTO livroRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.createLivro(livroRequestDTO));
    }
    
    @PutMapping("/update/{idLivro}")
    public ResponseEntity<LivroResponseDTO> updateLivro(@Valid @PathVariable Long idLivro, @RequestBody LivroRequestDTO livroRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.updateLivro(idLivro, livroRequestDTO));
    }

    @DeleteMapping(value = "/delete/{idLivro}")
    public ResponseEntity<String> deleteLivro(@PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteLivro(idLivro));

    }
}
