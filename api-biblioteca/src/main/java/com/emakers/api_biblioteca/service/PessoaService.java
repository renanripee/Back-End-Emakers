package com.emakers.api_biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emakers.api_biblioteca.data.dto.request.PessoaRequestDTO;
import com.emakers.api_biblioteca.data.dto.response.PessoaResponseDTO;
import com.emakers.api_biblioteca.data.entity.Livro;
import com.emakers.api_biblioteca.data.entity.Pessoa;
import com.emakers.api_biblioteca.exceptions.general.EntityNotFoundException;
import com.emakers.api_biblioteca.repository.LivroRepository;
import com.emakers.api_biblioteca.repository.PessoaRepositoy;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepositoy pessoaRepositoy;

     @Autowired
    private LivroRepository livroRepository;

    public List<PessoaResponseDTO> getAllPessoas(){
        List<Pessoa> Pessoas = pessoaRepositoy.findAll();
        return Pessoas.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public PessoaResponseDTO getPessoaById(Long idPessoa){
        Pessoa Pessoa = getPessoaEntityById(idPessoa);
        return new PessoaResponseDTO(Pessoa);
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO PessoaRequestDTO){
        Pessoa Pessoa = new Pessoa(PessoaRequestDTO);
        pessoaRepositoy.save(Pessoa);
        return new PessoaResponseDTO(Pessoa);
    }

    public PessoaResponseDTO updatePessoa(Long idPessoa, PessoaRequestDTO PessoaRequestDTO){
        Pessoa Pessoa = getPessoaEntityById(idPessoa);
        Pessoa.setNome_pessoa(PessoaRequestDTO.nome_pessoa());
        Pessoa.setCep(PessoaRequestDTO.cep());
        pessoaRepositoy.save(Pessoa);
        return new PessoaResponseDTO(Pessoa);
    }

    public String deletePessoa(Long idPessoa){
        Pessoa Pessoa = getPessoaEntityById(idPessoa);
        pessoaRepositoy.delete(Pessoa);
        return "Pessoa " + idPessoa + "deletada com sucesso!";
    }

    public PessoaResponseDTO updateAddLivro(Long idPessoa, Long idLivro){
        Pessoa pessoa = getPessoaEntityById(idPessoa);
        Livro livro = livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Erro ao achar livro por ID"));

        pessoa.getLivros().add(livro);
        pessoaRepositoy.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO updateDelLivro(Long idPessoa, Long idLivro){
        Pessoa pessoa = getPessoaEntityById(idPessoa);

        for (Livro i : pessoa.getLivros()) {
            if (i.getId_livro() == idLivro) {
                pessoa.getLivros().remove(i);
            }
        }
        pessoaRepositoy.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    private Pessoa getPessoaEntityById(Long idPessoa){
        Pessoa pessoa = pessoaRepositoy.findById(idPessoa).orElseThrow(()-> new EntityNotFoundException(idPessoa));
        return pessoa;
    }

}
