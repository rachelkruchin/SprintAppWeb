package sprintappweb.service;

import sprintappweb.dao.UsuarioDAO;
import sprintappweb.model.Usuario;

import java.sql.SQLException;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        if (usuario.getNome().isEmpty() || usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
        dao.salvar(usuario);
    }

    public Usuario login(String email, String senha) throws SQLException {
        if (email.isEmpty() || senha.isEmpty()) {
            throw new IllegalArgumentException("Email e senha devem ser preenchidos");
        }
        return dao.buscarPorEmailESenha(email, senha);
    }
}
