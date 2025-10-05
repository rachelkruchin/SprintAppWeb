package sprintappweb.service;

import sprintappweb.dao.UsuarioDAO;
import sprintappweb.model.Usuario;
import java.util.List;

public class UsuarioService {
    private UsuarioDAO dao = new UsuarioDAO();

    public void cadastrarUsuario(Usuario usuario) {
        // Aqui você pode adicionar validações
        dao.salvar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return dao.listar();
    }
}
