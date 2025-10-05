package sprintappweb;

import sprintappweb.controller.UsuarioController;
import sprintappweb.dao.UsuarioDAO;
import sprintappweb.service.UsuarioService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SprintAppWeb {

    public static void main(String[] args) {
        try {
            // Configura conexão com banco (SQLite)
           Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/sprintappwebdb?useSSL=false&serverTimezone=UTC",
        "root", 
        "joaquim"
);

            UsuarioDAO dao = new UsuarioDAO(conn);
            UsuarioService service = new UsuarioService(dao);
            UsuarioController controller = new UsuarioController(service);

            // Teste cadastro
            controller.cadastrarUsuario("Adrik", "adrik@email.com", "1234", "admin");

            // Teste login
            controller.loginUsuario("adrik@email.com", "1234");

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}
