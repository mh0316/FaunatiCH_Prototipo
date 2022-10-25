package modelo;

public class Jugador {
    private String rut;
    private String contresena;

    public Jugador(String rut, String contresena) {
        this.rut = rut;
        this.contresena = contresena;
    }

    public String getRut() {
        return rut;
    }

    public String getContresena() {
        return contresena;
    }

    public void setContresena(String contresena) {
        this.contresena = contresena;
    }

    @Override
    public String toString() {
        return "Jugador{" + "rut='" + rut + '\'' + ", contresena='" + contresena + '\'' + '}';
    }
}