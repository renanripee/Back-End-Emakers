package com.emakers.api_biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emakers.api_biblioteca.data.dto.request.LivroRequestDTO;
import com.emakers.api_biblioteca.data.dto.response.LivroResponseDTO;
import com.emakers.api_biblioteca.data.entity.Livro;
import com.emakers.api_biblioteca.exceptions.general.EntityNotFoundException;
import com.emakers.api_biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroResponseDTO> getAllLivros(){
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    public LivroResponseDTO getLivroById(Long idLivro){
        Livro livro = getLivroEntityById(idLivro);
        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO createLivro(LivroRequestDTO livroRequestDTO){
        Livro livro = new Livro(livroRequestDTO);
        livroRepository.save(livro);
        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO updateLivro(Long idLivro, LivroRequestDTO livroRequestDTO){
        Livro livro = getLivroEntityById(idLivro);
        livro.setNome_livro(livroRequestDTO.nome_livro());
        livro.setAutor(livroRequestDTO.autor());
        livro.setData_lancamento(livroRequestDTO.data_lancamento());
        livroRepository.save(livro);
        return new LivroResponseDTO(livro);
    }

    public String deleteLivro(Long idLivro){
        Livro livro = getLivroEntityById(idLivro);
        livroRepository.delete(livro);
        return "Livro " + idLivro + "deletado com sucesso!";
    }

    private Livro getLivroEntityById(Long idLivro){
        return livroRepository.findById(idLivro).orElseThrow(()-> new EntityNotFoundException(idLivro));
    }
}
