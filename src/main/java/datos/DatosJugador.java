package datos;

import modelo.Jugador;
import modelo.Jugadores;

import java.io.*;

public class DatosJugador {
    public static void leerArchivoJugador(Jugadores jugadores, String direccionDeArchivo){
        String textoArchivo = "";
        try {
            File archivo = new File(direccionDeArchivo);
            FileReader fileR = new FileReader(archivo);
            BufferedReader bufferedR = new BufferedReader(fileR);

            while ((textoArchivo = bufferedR.readLine()) != null){
                String[] dato = textoArchivo.split(";");
                jugadores.getJugadores().add(new Jugador(dato[0], dato[1]));
            }
        }catch (Exception e){
            System.out.println("Archivo no disponible.");
        }
    }

    public static boolean registrarUsuario(Jugador jugador, String direccionDeArchivo){
        boolean lineaVacia = false;
        try{
            File archivo = new File(direccionDeArchivo);
            if(!archivo.exists()){
                archivo.createNewFile();
                lineaVacia = true;
            }
            FileWriter fileW = new FileWriter(archivo,true);
            BufferedWriter bufferedW = new BufferedWriter(fileW);

            if(!lineaVacia){
                bufferedW.newLine();
            }
            bufferedW.write(jugador.toString());
            bufferedW.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error, los datos no son válidos.");
            return false;
        }
    }
}