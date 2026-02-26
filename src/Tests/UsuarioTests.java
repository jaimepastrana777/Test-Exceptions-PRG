package Tests;

import Class.Concierto;
import Class.Entrada;
import Class.usuario;
import Exceptions.ConciertoNoAsistidoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTests {

    @Test
    public void testValorarGuardaValoracionCorrectamente() throws Exception {
        Concierto concierto = new Concierto("Jazz Night", true, 100);
        usuario estudiante = new usuario("Carlos");
        Entrada entrada = new Entrada("Grada", 30.0);

        estudiante.comprarEntrada(concierto, entrada);

        estudiante.valorar(concierto, 8);

        assertTrue(estudiante.getValoraciones().contains(8));
    }

    @Test
    public void testValorarSinAsistirLanzaExcepcion() {
        Concierto concierto = new Concierto("Pop Fest", true, 100);
        usuario estudiante = new usuario("Ana");

        assertThrows(ConciertoNoAsistidoException.class, () -> {
            estudiante.valorar(concierto, 7);
        });
    }
}