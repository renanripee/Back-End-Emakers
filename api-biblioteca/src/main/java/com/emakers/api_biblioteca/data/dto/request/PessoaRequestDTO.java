package com.emakers.api_biblioteca.data.dto.request;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PessoaRequestDTO(

    @Length(min = 1, max = 80, message = "o nome da pessoa pode ter no maximo {max} caracteres")
    @NotBlank(message = "eh necessario informar um nome para a pessoa")
    String nome_pessoa,

    @Length(min = 1, max = 9, message = "o cep pode ter no maximo {max} caracteres")
    @NotBlank(message = "eh necessario informar um cep")
    @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "O CEP deve estar no formato ddddd-ddd")
    String cep
) {
    
}
