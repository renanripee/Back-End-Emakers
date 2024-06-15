package com.emakers.api_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emakers.api_biblioteca.data.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
