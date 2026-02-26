package Tests;

import Class.Entrada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaTests {

    @Test
    public void testGetPrecioTotalGrada() {
        Entrada entradaGrada = new Entrada("Grada", 30.0);
assertEquals(30.0, entradaGrada.getPrecioTotal(), 0.01);
    }

    @Test
    public void testGetPrecioTotalVIP() {
        Entrada entradaVIP = new Entrada("VIP", 30.0);
        assertEquals(80.0, entradaVIP.getPrecioTotal(), 0.01);
    }
}
