package com.emakers.api_biblioteca.data.dto.response;

import java.time.LocalDate;

import com.emakers.api_biblioteca.data.entity.Livro;

public record LivroResponseDTO(

    Long id,

    String nome_livro,

    String autor,

    LocalDate data_lancamento
) {
    public LivroResponseDTO(Livro livro){
        this(livro.getId_livro(), livro.getNome_livro(), livro.getAutor(), livro.getData_lancamento());
    }
}
