package com.emakers.api_biblioteca.data.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.emakers.api_biblioteca.data.entity.Pessoa;

public record PessoaResponseDTO(

    Long id,

    String nome_pessoa,

    String cep,

    List<LivroResponseDTO> livros
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getId_pessoa(), pessoa.getNome_pessoa(), pessoa.getCep(), pessoa.getLivros().stream().map(LivroResponseDTO::new).collect(Collectors.toList()));
    }
}
