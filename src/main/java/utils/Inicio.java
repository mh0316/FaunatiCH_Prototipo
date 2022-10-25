package utils;

import datos.DatosJugador;
import datos.VerificadorRutJugador;
import datos.VerificadorContraseñaJugador;
import modelo.Jugador;
import modelo.Jugadores;

import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        crearCuenta();
    }

    public static void mostrarOpcionesDeInicio(){
        System.out.println("""
                BIENVENIDO/A A FAUNATICH!
                Elija una opción:
                1. Iniciar sesión.
                2. Crear cuenta.""");
        seleccionarOpcionMenu(ingresar());
    }

    private static void seleccionarOpcionMenu(int opcion){
        switch (opcion) {
            //case 1 -> iniciarSesion();
            case 2 -> crearCuenta();
            case 3 -> salirDelJuego();
            default -> {
                System.out.println("Por favor ingrese una opción válida:");
                mostrarOpcionesDeInicio();
            }
        }
    }

    private static String ingresarDatos(){
        Scanner teclado = new Scanner(System.in);
        String ingreso = teclado.nextLine();
        return ingreso;
    }

    public static void crearCuenta(){
        String rut = pedirRut();
        String contrasena = pedirContraseña();
        Jugador jugador = new Jugador(rut, contrasena);
        Jugadores.agregarJugador(jugador);
    }

    private static String pedirRut(){
        System.out.println("A continuación deberá ingresar su rut, sin puntos ni guión y con dígito verificador.");
        System.out.print("Ingrese su rut: ");
        String rut = ingresarDatos();
        if(VerificadorRutJugador.validarRut(rut) == true){
            return rut;
        }else{
            System.out.print("Error, el rut no es válido, ingréselo nuavamente. \n");
            pedirRut();
        }

        return rut;
    }

    private static String pedirContraseña(){
        System.out.println("A continuación deberá ingresar una contraseña, la cual deberá tener letras y números y debe tener por lo menos 5 caracteres y máximo 10.");
        System.out.print("Ingrese una contraseña: ");
        String contrasena = ingresarDatos();
        VerificadorContraseñaJugador.verificarContraseña(contrasena);
        if(VerificadorContraseñaJugador.verificarContraseña(contrasena) == true){
            return contrasena;
        }else{
            System.out.print("Error, la contraseña no es válida, inténtelo nuevamente. \n");
            pedirContraseña();
        }

        return contrasena;
    }

    /*public static void iniciarSesion(){
        System.out.print("Ingrese su rut: ");
        String rut = String.valueOf(VerificadorRutJugador.validarRut(rut));
        System.out.print("Ingrese su contraseña: ");
        //contrasena =
    }*/

    public static void salirDelJuego() {
        System.out.println("Juego terminado.");
    }

    private static int ingresar() {
        Scanner teclado = new Scanner(System.in);
        int entrada;
        do {
            try {
                entrada = teclado.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Por favor ingrese una opción válida:");
                teclado.nextLine();
            }
        } while (true);
        return entrada;
    }
}