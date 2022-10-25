package modelo;

import datos.VerificadorRutJugador;
import java.util.ArrayList;
import java.util.List;

public class Jugadores {
    private static List<Jugador> jugadores;

    public Jugadores(){
        this.jugadores = new ArrayList<>();
    }

    public static boolean agregarJugador(Jugador jugador){
        String rut = jugador.getRut();

        if(!jugadorExiste(rut) && VerificadorRutJugador.validarRut(rut)){
            jugadores.add(jugador);
            return true;
        }

        return false;
    }

    public boolean jugadorExiste(String rut){
        for(Jugador j : this.jugadores){
            if(j.getRut().equals(rut)){
                return true;
            }
        }

        return false;
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }
}