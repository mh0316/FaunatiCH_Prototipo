package utils;

import menu.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FaunatiCH {
    public static void iniciarJuego() {
        ArrayList<String[][]> coleccionAnimales = new ArrayList<>();

        Menu.mostrarTextoDeBienvenida();
        int opcion;

        do {
            Menu.mostrarMenu();
            opcion = opcionesMenu(ingresar(), coleccionAnimales);
        } while (opcion != 3);
    }

    private static int opcionesMenu(int opcionIngresada, ArrayList<String[][]> coleccionAnimales) {
        switch (opcionIngresada) {
            case 1 -> comenzarJuego(coleccionAnimales);
            case 2 -> mostrarEstadisticas(coleccionAnimales);
            case 3 -> PreguntasParaGanarVidas.mostrarMenuDePreguntas();
            case 4 -> salirDelJuego();
            default -> {
                System.out.println("Por favor ingrese un número válido:");
                opcionesMenu(ingresar(), coleccionAnimales);
            }
        }
        return opcionIngresada;
    }

    private static void comenzarJuego(ArrayList<String[][]> coleccionAnimales) {
        Menu.mostrarMapaGeografico();
        int zona = elegirZona(ingresar());
        mostrarAnimalesZonaElegida(zona);

        String[][] animalEnemigo = elegirAnimalPorZona(zona);
        String[][] animalJugador = generarAnimalUsuario();

        agregarAnimalAColeccion(coleccionAnimales,animalJugador);

        mostrarCombate(animalEnemigo, animalJugador);
        int ptsDeVidaJugador = combatir(animalEnemigo, animalJugador);

        mostrarResultadoCombate(animalEnemigo, ptsDeVidaJugador);

        if (esGanador(ptsDeVidaJugador)) {
            agregarAnimalAColeccion(coleccionAnimales, animalEnemigo);
        }
    }

    private static void agregarAnimalAColeccion(ArrayList<String[][]> coleccionAnimales, String[][] animal) {
        if (!animalEstaEnColeccion(animal, coleccionAnimales)) {
            coleccionAnimales.add(animal);
        }
    }

    private static boolean animalEstaEnColeccion(String[][] animal, ArrayList<String[][]> coleccion) {
        for (String[][] animales : coleccion) {
            if (Arrays.equals(animales[0], animal[0])) {
                return true;
            }
        }
        return false;
    }

    private static boolean esGanador(int puntosDeVidaJugador) {
        return puntosDeVidaJugador > 0;
    }

    public static int combatir(String[][] animalEnemigo, String[][] animalJugador) {
        int vidaAnimalEnemigo = Integer.parseInt(animalEnemigo[1][0]);
        int vidaAnimalJugador = Integer.parseInt(animalJugador[1][0]);

        while (true) {
            mostrarNivelDeVidaAnimales(animalEnemigo, animalJugador, vidaAnimalJugador, vidaAnimalEnemigo);

            int ataqueJugador = jugadaDeUsuario(animalJugador);
            vidaAnimalEnemigo -= ataqueJugador;

            if (vidaAnimalEnemigo <= 0) {
                return vidaAnimalJugador;
            }

            int ataqueAnimalEnemigo = jugadaDeCPU(animalEnemigo);
            vidaAnimalJugador -= ataqueAnimalEnemigo;

            if (vidaAnimalJugador <= 0) {
                return vidaAnimalJugador;
            }

        }
    }

    public static int jugadaDeCPU(String[][] animalEnemigo) {
        int ataqueAleatorio = (int) ((Math.random() * animalEnemigo[2].length));
        mostrarAtaque(animalEnemigo, ataqueAleatorio);
        return Integer.parseInt(animalEnemigo[3][ataqueAleatorio]);
    }

    public static int jugadaDeUsuario(String[][] animalJugador) {
        mostrarOpcionesDeAtaque(animalJugador);
        int opcionDeAtaque = pedirOpcionDeAtaque(ingresar(), animalJugador);
        mostrarAtaque(animalJugador, opcionDeAtaque - 1);
        return Integer.parseInt(animalJugador[3][opcionDeAtaque - 1]);
    }

    private static int pedirOpcionDeAtaque(int opcionIngresada, String[][] animalJugador) {
        if (opcionIngresada < 1 || opcionIngresada > animalJugador[2].length) {
            System.out.println("Por favor ingrese un número válido:");
            return pedirOpcionDeAtaque(ingresar(), animalJugador);
        }
        return opcionIngresada;
    }

    private static String[][] generarAnimalUsuario() {
        return new String[][]{{"Cóndor"}, {"50"}, {"Picotón", "Intimidación", "Mordida"}, {"5", "3", "4"}};
    }

    private static String[][] elegirAnimalPorZona(int zona) {
        switch (zona) {
            case 1:
                return elegirAnimalZonaNorte(ingresar());
            case 2:
                return elegirAnimalZonaCentral(ingresar());
            case 3:
                return elegirAnimalZonaSur(ingresar());
            default:
                System.out.println("Elija una opción válida:");
                return elegirAnimalPorZona(ingresar());
        }
    }

    private static int elegirZona(int opcionIngresada) {
        if (opcionIngresada < 1 || opcionIngresada > 3) {
            System.out.println("Por favor ingrese una opción válida:");
            return elegirZona(ingresar());
        }
        return opcionIngresada;
    }

    private static String[][] elegirAnimalZonaNorte(int opcionIngresada) {
        String[][] caracteristicasAlpaca = {{"Alpaca"}, {"30"}, {"Escupitajo", "Patada", "Mordida"}, {"5", "3", "4"}};
        String[][] caracteristicasVicuña = {{"Vicuña"}, {"30"}, {"Mordizco", "Patada", "Embestida"}, {"5", "3", "4"}};
        String[][] caracteristicasGuanaco = {{"Guanaco"}, {"30"}, {"Escupo", "Patada", "Embestida"}, {"5", "3", "4"}};
        String[][] caracteristicasLlama = {{"Llama"}, {"30"}, {"Escupo", "Silbar", "Embestida"}, {"5", "3", "4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasAlpaca;
            case 2:
                return caracteristicasVicuña;
            case 3:
                return caracteristicasGuanaco;
            case 4:
                return caracteristicasLlama;
            default:
                System.out.println("Por favor ingrese un número válido:");
                return elegirAnimalZonaNorte(ingresar());
        }
    }

    private static String[][] elegirAnimalZonaCentral(int opcionIngresada) {
        String[][] caracteristicasZorroCulpeo = {{"Zorro Culpeo"}, {"30"}, {"Mordedura", "Patada", "Ataque random"}, {"5", "3", "4"}};
        String[][] caracteristicasPuma = {{"Puma"}, {"30"}, {"Mordizco", "Embestida", "Arañazo"}, {"5", "3", "4"}};
        String[][] caracteristicasAguilaMora = {{"Águila Mora"}, {"30"}, {"Garras", "En Picada", "Picotazo"}, {"5", "3", "4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasZorroCulpeo;
            case 2:
                return caracteristicasPuma;
            case 3:
                return caracteristicasAguilaMora;
            default:
                System.out.println("Por favor ingrese un número válido:");
                return elegirAnimalZonaCentral(ingresar());
        }
    }

    private static String[][] elegirAnimalZonaSur(int opcionIngresada) {
        String[][] caracteristicasPinguino = {{"Pinguino"}, {"30"}, {"Picar", "Aletazo", "Ataque random"}, {"4", "5", "3"}};
        String[][] caracteristicasZorroPatagonico = {{"Zorro Patagonico"}, {"30"}, {"Mordizco", "Garras", "Ataque random 2"}, {"3", "5", "6"}};
        String[][] caracteristicasÑandu = {{"Ñandu"}, {"31"}, {"Aleteo", "Patada", "ataque random"}, {"7", "4", "4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasPinguino;
            case 2:
                return caracteristicasZorroPatagonico;
            case 3:
                return caracteristicasÑandu;
            default:
                System.out.println("Por favor ingrese un número válido:");
                return elegirAnimalZonaSur(ingresar());
        }
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

    private static void mostrarResultadoCombate(String[][] animalEnemigo, int ptsDeVidaJugador) {
        System.out.println("---------------------------------------------------------------------------------------------");
        if (esGanador(ptsDeVidaJugador)) {
            System.out.println("Felicidades! Has vencido a tu rival: " + animalEnemigo[0][0] +
                    ", ahora son amigos y será añadido a tu colección.");
        } else {
            System.out.println("Lo sentimos, has perdido este duelo pero puedes volver a intentarlo." +
                    " Suerte para la proxima!");
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void mostrarAtaque(String[][] animal, int opcionDeAtaque) {
        String nombreAnimal = animal[0][0];
        String ataque = animal[2][opcionDeAtaque];
        String puntosDeVida = animal[3][opcionDeAtaque];

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(nombreAnimal + " ha usado " + ataque + ", y ha quitado " + puntosDeVida + " puntos de vida!");
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void mostrarAnimalesZonaElegida(int zona) {
        switch (zona) {
            case 1 -> Menu.mostrarAnimalesZonaNorte();
            case 2 -> Menu.mostrarAnimalesZonaCentral();
            case 3 -> Menu.mostrarAnimalesZonaSur();
        }
    }

    private static void mostrarOpcionesDeAtaque(String[][] animalJugador) {
        System.out.println("¿Qué ataque debería hacer " + animalJugador[0][0] + "?:");

        for (int i = 0; i < animalJugador[2].length; i++) {
            System.out.println((i + 1) + ". " + animalJugador[2][i]);
        }
    }


    private static void mostrarNivelDeVidaAnimales(String[][] animalEnemigo, String[][] animalJugador, int vidaAnimalJugador, int vidaAnimalEnemigo) {
        System.out.println("Vidas de " + animalEnemigo[0][0] + ": " + vidaAnimalEnemigo);
        System.out.println("Vidas de " + animalJugador[0][0] + ": " + vidaAnimalJugador);
        System.out.println();
    }

    private static void mostrarCombate(String[][] animalDelUsuario, String[][] animalElegidoEnZona) {
        System.out.println("El combate es " + animalDelUsuario[0][0] + " vs " + animalElegidoEnZona[0][0]);
    }

    private static void salirDelJuego() {
        System.out.println("Juego terminado.");
    }

    private static void mostrarEstadisticas(ArrayList<String[][]> coleccionAnimales) {
        if (coleccionAnimales.size() == 0) {
            System.out.println("Colección vacía");
            return;
        }

        System.out.println("Colección de Animales Amigos:");
        for (String[][] animal : coleccionAnimales) {
            System.out.println(Arrays.toString(animal[0]));
        }
    }
}