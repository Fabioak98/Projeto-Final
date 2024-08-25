package com.example.Projetofinal.domain.user;

public record DadosDetalhamentoUsuario(
        String id,
        String login
) {
    public DadosDetalhamentoUsuario(Usuario u){
        this(u.getId(), u.getEmail());
    }
}
