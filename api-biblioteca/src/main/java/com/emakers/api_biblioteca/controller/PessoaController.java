package com.emakers.api_biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emakers.api_biblioteca.data.dto.request.PessoaRequestDTO;
import com.emakers.api_biblioteca.data.dto.response.PessoaResponseDTO;
import com.emakers.api_biblioteca.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PessoaResponseDTO>> getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAllPessoas());
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> getPessoaById(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoaById(idPessoa));
    }

    @PostMapping("/create")
    public ResponseEntity<PessoaResponseDTO> createPessoa(@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.createPessoa(pessoaRequestDTO));
    }
    
    @PutMapping("/update/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> updatePessoa(@Valid @PathVariable Long idPessoa, @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updatePessoa(idPessoa, pessoaRequestDTO));
    }

    @DeleteMapping(value = "/delete/{idPessoa}")
    public ResponseEntity<String> deletePessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletePessoa(idPessoa));

    }

    @PutMapping(value = "/updateAddLivro/{idPessoa}/{idLivro}")
    public ResponseEntity<PessoaResponseDTO> updateAddLivro(@PathVariable Long idPessoa, @PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updateAddLivro(idPessoa, idLivro));
    }

    @PutMapping(value = "/updateDelLivro/{idPessoa}/{idLivro}")
    public ResponseEntity<PessoaResponseDTO> updateDelLivro(@PathVariable Long idPessoa, @PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updateDelLivro(idPessoa, idLivro));
    }
}
