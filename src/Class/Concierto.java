package Class;

import Exceptions.CeroEntradasException;
import java.util.ArrayList;

public class Concierto {
    private String nombre;
    private boolean activo;
    private int aforoMaximo;
    private ArrayList<Entrada> entradasVendidas;

    public Concierto(String nombre, boolean activo, int aforoMaximo) {
        this.nombre = nombre;
        this.activo = activo;
        this.aforoMaximo = aforoMaximo;
        this.entradasVendidas = new ArrayList<>();
    }

    public double calcularPrecioMedio() throws CeroEntradasException {
        if (entradasVendidas.isEmpty()) {
            throw new CeroEntradasException("Error: No hay entradas vendidas para " + nombre);
        }

        double suma = 0;
        for (Entrada e : entradasVendidas) {
            suma = suma + e.getPrecioTotal();
        }

        return suma / entradasVendidas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }
}