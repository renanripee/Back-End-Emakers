package com.emakers.api_biblioteca.data.entity;

import java.time.LocalDate;

import com.emakers.api_biblioteca.data.dto.request.LivroRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "livro")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livro;

    @Column(name = "nome_livro", nullable = false, length = 45)
    private String nome_livro;

    @Column(name = "autor", nullable = false, length = 45)
    private String autor;

    @Column(name = "data_lancamento", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate data_lancamento;

    @ManyToMany(mappedBy = "livros")
    private List<Pessoa> pessoas;

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO){
        this.nome_livro = livroRequestDTO.nome_livro();
        this.autor = livroRequestDTO.autor();
        this.data_lancamento = livroRequestDTO.data_lancamento();
        this.pessoas = new ArrayList<>();
    }
}
