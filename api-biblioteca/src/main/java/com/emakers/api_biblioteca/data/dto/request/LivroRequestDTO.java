package com.emakers.api_biblioteca.data.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;

public record LivroRequestDTO(

    @Length(min = 1, max = 45, message = "o nome do livro pode ter no maximo {max} caracteres")
    @NotBlank(message = "eh necessario informar um nome para o livro")
    String nome_livro,

    @Length(min = 1, max = 45, message = "o nome do autor pode ter no maximo {max} caracteres")
    @NotBlank(message = "eh necessario informar um autor")
    String autor,

    //@NotBlank(message = "eh necessario informar uma data")
    //@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "A data de lancamento deve estar no formato yyyy-mm-dd")
    LocalDate data_lancamento
) {
    
}
