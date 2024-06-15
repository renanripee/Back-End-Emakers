package com.emakers.api_biblioteca.data.entity;

import java.util.ArrayList;
import java.util.List;

import com.emakers.api_biblioteca.data.dto.request.PessoaRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pessoa;

    @Column(name = "nome_pessoa", nullable = false, length = 80)
    private String nome_pessoa;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    @ManyToMany
    @JoinTable(
            name = "emprestimo",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_livro")
    ) 
    private List<Livro> livros;

    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO){
        this.nome_pessoa = pessoaRequestDTO.nome_pessoa();
        this.cep = pessoaRequestDTO.cep();
        this.livros = new ArrayList<>();
    }
}
