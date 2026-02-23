import Class.*;
import Exceptions.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- PRUEBAS DE EXCEPCIONES ---\n");

        usuario estudiante = new usuario("Carlos");
        Entrada entradaGrada = new Entrada("Grada", 30.0);

        // 1. CeroEntradasException
        Concierto c1 = new Concierto("Concierto Vacio", true, 100);
        try {
            c1.calcularPrecioMedio();
        } catch (CeroEntradasException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // 2. ConciertoInactivoException
        Concierto c2 = new Concierto("Concierto Cancelado", false, 500);
        try {
            estudiante.comprarEntrada(c2, entradaGrada);
        } catch (Exception e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // 3. AforoCompletoException
        Concierto c3 = new Concierto("Concierto Lleno", true, 0);
        try {
            estudiante.comprarEntrada(c3, entradaGrada);
        } catch (Exception e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // 4. ConciertoYaAsistidoException
        Concierto c4 = new Concierto("Festival", true, 1000);
        try {
            estudiante.comprarEntrada(c4, entradaGrada);
            estudiante.comprarEntrada(c4, entradaGrada);
        } catch (Exception e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // 5. ConciertoNoAsistidoException
        Concierto c5 = new Concierto("Opera", true, 200);
        try {
            estudiante.valorar(c5, 8);
        } catch (Exception e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // 6. ValoracionIncorrecta
        try {
            estudiante.valorar(c4, 15);
        } catch (Exception e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        System.out.println("\n--- FIN DEL PROGRAMA ---");
    }
}