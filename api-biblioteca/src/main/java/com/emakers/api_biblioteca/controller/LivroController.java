package com.emakers.api_biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;

import com.emakers.api_biblioteca.data.dto.request.LivroRequestDTO;
import com.emakers.api_biblioteca.data.dto.response.LivroResponseDTO;
import com.emakers.api_biblioteca.service.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Livro", description = "Endpoints relacionados aos livros")
@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Operation(summary = "Lista todos os livros",
            description = "Lista todos os livros cadastrados no sistema",
            tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LivroResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<LivroResponseDTO>> getAllLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAllLivros());
    }

    @Operation(summary = "Retorna um livro",
            description = "Retorna um livro cadastrado no sistema a partir da busca pelo deu Id",
            tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LivroResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/{idLivro}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<LivroResponseDTO> getLivroById(@PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getLivroById(idLivro));
    }

    @Operation(summary = "Cadastra um livro",
            description = "Cadastra/cria um livro no sistema",
            tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LivroResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LivroResponseDTO> createLivro(@Valid @RequestBody LivroRequestDTO livroRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.createLivro(livroRequestDTO));
    }
    
    @Operation(summary = "Atualiza um livro",
            description = "Atualiza os dados de um livro no sistema, a partir de seu Id",
            tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LivroResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/update/{idLivro}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<LivroResponseDTO> updateLivro(@Valid @PathVariable Long idLivro, @RequestBody LivroRequestDTO livroRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.updateLivro(idLivro, livroRequestDTO));
    }

    @Operation(summary = "Deleta um livro",
            description = "Deleta um livro do sistema a partir do seu Id",
            tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LivroResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @DeleteMapping(value = "/delete/{idLivro}", consumes = "application/index")
    public ResponseEntity<String> deleteLivro(@PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteLivro(idLivro));
    }
}
