package com.emakers.api_biblioteca.exceptions.general;

public class EntityNotFoundException extends RuntimeException{
    
    public EntityNotFoundException(Long id){
        super("Entidade com o id " + id + " nao encontrada!");
    }
}
