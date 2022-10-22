package utils;
import java.util.Scanner;

public class PreguntasParaGanarVidas {
    public static void mostrarMenuDePreguntas(){
        System.out.println("""
                Para ganar vidas tendrás que responder una pregunta sobre algún animal a elección, si te equivocas no ganarás nada.
                A continuación selecciona el animal sobre el que responderás la pregunta:
                1. Alpaca.
                2. Vicuña.
                3. Guanaco.
                4. Llama.
                5. Zorro Culpeo.
                6. Puma.
                7. Águila Mora.
                8. Pingüino.
                9. Zorro de la Patagonia.
                10. Ñandú.""");
        int opcion = ingresar();
        menuPreguntasPorAnimalElegido(opcion);
    }

    private static void menuPreguntasPorAnimalElegido(int opcion){
        switch (opcion) {
            case 1 -> preguntaAlpaca();
            case 2 -> preguntaVicuña();
            case 3 -> preguntaGuanaco();
            case 4 -> preguntaLlama();
            case 5 -> preguntaZorroCulpeo();
            case 6 -> preguntaPuma();
            case 7 -> preguntaAguilaMora();
            case 8 -> preguntaPingüino();
            case 9 -> preguntaZorroDeLaPatagonia();
            case 10 -> preguntaÑandu();
            default -> {
                System.out.println("Error, por favor ingresa una opción válida:");
                menuPreguntasPorAnimalElegido(ingresar());
            }
        }
    }

    private static void preguntaAlpaca(){
        System.out.println("""
                ¿Cuál es la altura promedio de la Alpaca?
                1. 70-80cm
                2. 80-90cm""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 2){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }
    }

    private static void preguntaVicuña(){
        System.out.println("""
                ¿Qué tipo de animal es la Vicuña?
                1. Herbívoro
                2. Carnívoro
                3. Insectívioro""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 3){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }
    }

    private static void preguntaGuanaco(){
        System.out.println("""
                ¿En qué tipos de ambiente vive el Guanaco?
                1. Ambiente árido
                2. Ambiente semiárido
                3. Ambientes áridos y semiáridos""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 3){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }
    }

    private static void preguntaLlama(){
        System.out.println("""
                ¿Qué hace una llama para defenderse?
                1. Lanza un escupo
                2. Patea
                3. Gruñe""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 3){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }
    }

    private static void preguntaZorroCulpeo(){
        System.out.println("""
                El Zorro Culpeo es el más grande de Chile, alcanzando una longitud de 1,4 metros desde la cabeza hasta la cola.
                1. Verdadero
                2. Falso""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }
    }

    private static void preguntaPuma(){
        System.out.println("""
                El puma, dentro del mundo de los felinos, es considerado grande.
                1. Verdadero
                2. Falso""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 2){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }
    }

    private static void preguntaAguilaMora(){
        System.out.println("""
                El Águila Mora es un ave cuyas actividades como la caza las realiza en:
                1. El día
                2. La noche""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }
    }

    private static void preguntaPingüino(){
        System.out.println("""
                El Pingüino es un ave caliente.
                1. Verdadero
                2. Falso""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }
    }

    private static void preguntaZorroDeLaPatagonia(){
        System.out.println("""
                El Zorro de la Patagonia es muy distinto de los demás zorros.
                1. Verdadero
                2. Falso""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();

        }else if(respuesta == 2){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
        }
    }

    private static void preguntaÑandu(){
        System.out.println("""
                El Ñandú es un ave voladora y exclusivamente:
                1. Norteamericana
                2. Centroamericana
                3. Sudamericana""");
        int respuesta = ingresar();

        if(respuesta == 1){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 2){
            System.out.println("RESPUESTA INCORRECTA");
            FaunatiCH.iniciarJuego();
        }else if(respuesta == 3){
            System.out.println("RESPUESTA CORRECTA!!");
            System.out.println("¡¡Ganaste 3 vidas!!");
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
}