package Class;

import Exceptions.*;
import java.util.ArrayList;

public class usuario {
    private String nombre;
    private ArrayList<Concierto> conciertosAsistidos;
    private ArrayList<Integer> valoraciones;

    public usuario(String nombre) {
        this.nombre = nombre;
        this.conciertosAsistidos = new ArrayList<>();
        this.valoraciones = new ArrayList<>();
    }

    public void comprarEntrada(Concierto c, Entrada e) throws ConciertoInactivoException, ConciertoYaAsistidoException, AforoCompletoException {
        if (!c.isActivo()) {
            throw new ConciertoInactivoException("El concierto " + c.getNombre() + " no está activo.");
        }
        if (conciertosAsistidos.contains(c)) {
            throw new ConciertoYaAsistidoException("Ya has comprado entrada para " + c.getNombre());
        }
        if (c.getEntradasVendidas().size() >= c.getAforoMaximo()) {
            throw new AforoCompletoException("El aforo está completo para " + c.getNombre());
        }

        c.getEntradasVendidas().add(e);
        conciertosAsistidos.add(c);
    }

    public void valorar(Concierto c, int nota) throws ConciertoNoAsistidoException, ValoracionIncorrecta {
        if (!conciertosAsistidos.contains(c)) {
            throw new ConciertoNoAsistidoException("No puedes valorar un concierto al que no has ido.");
        }
        if (nota < 0 || nota > 10) {
            throw new ValoracionIncorrecta("La nota debe estar entre 0 y 10. Has puesto: " + nota);
        }

        valoraciones.add(nota);
    }

    public ArrayList<Integer> getValoraciones() {
        return valoraciones;
    }
}