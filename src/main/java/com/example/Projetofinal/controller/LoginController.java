package com.example.Projetofinal.controller;

import com.example.Projetofinal.domain.user.DadosLogin;
import com.example.Projetofinal.domain.user.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosLogin dados){

        return ResponseEntity.ok().build();
    }
}
