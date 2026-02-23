package Class;

public class Entrada {
    private String tipo;
    private double precioBase;

    public Entrada(String tipo, double precioBase) {
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public double getPrecioTotal() {
        if (tipo.equalsIgnoreCase("VIP")) {
            return precioBase + 50.0;
        }
        return precioBase;
    }
}