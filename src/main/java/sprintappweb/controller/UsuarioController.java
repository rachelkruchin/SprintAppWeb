package sprintappweb.controller;

import sprintappweb.model.Usuario;
import sprintappweb.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario"})
public class UsuarioController extends HttpServlet {

    private final UsuarioService service = new UsuarioService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (nome != null && email != null && senha != null && !nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()) {
            Usuario usuario = new Usuario(nome, email, senha);
            service.cadastrarUsuario(usuario);
            response.sendRedirect("sucesso.html");
        } else {
            response.sendRedirect("cadastro.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = service.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
