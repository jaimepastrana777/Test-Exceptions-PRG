package Tests;

import Class.Concierto;
import Class.Entrada;
import Exceptions.CeroEntradasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConciertoTests {

    @Test
    public void testCalcularPrecioMedioConEntradas() throws CeroEntradasException {
        Concierto concierto = new Concierto("Rock Fest", true, 100);

        Entrada entrada1 = new Entrada("Grada", 30.0);  // precio = 30.0
        Entrada entrada2 = new Entrada("VIP", 30.0);    // precio = 80.0

        concierto.getEntradasVendidas().add(entrada1);
        concierto.getEntradasVendidas().add(entrada2);

        // Media esperada = (30 + 80) / 2 = 55.0
        assertEquals(55.0, concierto.calcularPrecioMedio(), 0.01);
    }

    @Test
    public void testCalcularPrecioMedioSinEntradasLanzaExcepcion() {
        Concierto concierto = new Concierto("Concierto Vacio", true, 100);

        assertThrows(CeroEntradasException.class, () -> {
            concierto.calcularPrecioMedio();
        });
    }
}