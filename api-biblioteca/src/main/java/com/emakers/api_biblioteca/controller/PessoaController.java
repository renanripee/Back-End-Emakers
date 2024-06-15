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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "Lista todas as pessoas",
            description = "Lista todas as pessoas cadastradas no sistema",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<PessoaResponseDTO>> getAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAllPessoas());
    }

    @Operation(summary = "Retorna uma pessoa",
            description = "Retorna uma pessoa cadastrada no sistema a partir da busca pelo deu Id",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/{idPessoa}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> getPessoaById(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoaById(idPessoa));
    }

    @Operation(summary = "Cadastra uma pessoa",
            description = "Cadastra/cria uma pessoa no sistema",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> createPessoa(@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.createPessoa(pessoaRequestDTO));
    }
    
    @Operation(summary = "Atualiza uma pessoa",
            description = "Atualiza os dados de uma pessoa no sistema, a partir de seu Id",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/update/{idPessoa}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> updatePessoa(@Valid @PathVariable Long idPessoa, @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updatePessoa(idPessoa, pessoaRequestDTO));
    }

    @Operation(summary = "Deleta um livro",
            description = "Deleta uma pessoa do sistema a partir do seu Id",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @DeleteMapping(value = "/delete/{idPessoa}", consumes = "application/index")
    public ResponseEntity<String> deletePessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletePessoa(idPessoa));

    }

    @Operation(summary = "Efetua o emprestimo de um livro a uma pessoa",
            description = "Adiciona um livro à lista de livros de uma pessoa, a partir do Id de ambos",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/updateAddLivro/{idPessoa}/{idLivro}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> updateAddLivro(@PathVariable Long idPessoa, @PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updateAddLivro(idPessoa, idLivro));
    }

    @Operation(summary = "Efetua a devolucao de um livro por uma pessoa",
            description = "Remove o livro da lista de livros de uma pessoa, a partir do Id de ambos",
            tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PessoaResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/updateDelLivro/{idPessoa}/{idLivro}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> updateDelLivro(@PathVariable Long idPessoa, @PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updateDelLivro(idPessoa, idLivro));
    }
}
