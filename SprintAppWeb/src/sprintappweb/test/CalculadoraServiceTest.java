package sprintappweb.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sprintappweb.service.CalculadoraService;

public class CalculadoraServiceTest {

    @Test
    public void testSoma() {
        CalculadoraService calc = new CalculadoraService();
        assertEquals(5, calc.somar(2, 3));
    }

    @Test
    public void testMultiplicacao() {
        CalculadoraService calc = new CalculadoraService();
        assertEquals(6, calc.multiplicar(2, 3));
    }
}

