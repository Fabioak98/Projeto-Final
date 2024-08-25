package com.example.Projetofinal.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    @Query("{ 'email': ?0 }")
    Usuario findByEmail(String email);

}
