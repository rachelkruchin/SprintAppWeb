package sprintappweb.controller;

import sprintappweb.model.Usuario;
import sprintappweb.service.UsuarioService;

import java.sql.SQLException;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public void cadastrarUsuario(String nome, String email, String senha, String tipo) {
        try {
            Usuario u = new Usuario(nome, email, senha, tipo);
            service.cadastrarUsuario(u);
            System.out.println("Usuário cadastrado com sucesso: " + nome);
        } catch (IllegalArgumentException | SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void loginUsuario(String email, String senha) {
        try {
            Usuario u = service.login(email, senha);
            if (u != null) {
                System.out.println("Login realizado com sucesso: " + u.getNome());
            } else {
                System.out.println("Email ou senha inválidos");
            }
        } catch (IllegalArgumentException | SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
        }
    }
}
