package com.emakers.api_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emakers.api_biblioteca.data.entity.Pessoa;

public interface PessoaRepositoy extends JpaRepository<Pessoa, Long>{
    
}
