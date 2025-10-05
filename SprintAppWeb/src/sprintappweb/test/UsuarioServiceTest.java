package sprintappweb.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sprintappweb.model.Usuario;
import sprintappweb.service.UsuarioService;

public class UsuarioServiceTest {

    @Test
    public void testCadastroComNomeVazio() {
        UsuarioService service = new UsuarioService(null); // null porque não acessa DB
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarUsuario(new Usuario("", "email@test.com", "1234", "admin"));
        });
        assertTrue(exception.getMessage().contains("Todos os campos devem ser preenchidos"));
    }

    @Test
    public void testCadastroValido() throws Exception {
        UsuarioService service = new UsuarioService(null);
        Usuario u = new Usuario("Adrik", "adrik@email.com", "1234", "admin");
        // aqui não usamos DAO, só testamos se não lança erro
        assertDoesNotThrow(() -> service.cadastrarUsuario(u));
    }
}

