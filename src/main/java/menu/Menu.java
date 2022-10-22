package menu;

public class Menu {
    public static void mostrarTextoDeBienvenida() {
        System.out.println("BIENVENIDO/A A FAUNATICH!");
        System.out.println("Este juego te ayudará a aprender sobre la fauna Chilena de una manera muy entretenida.");
    }

    public static void mostrarMenu() {
        System.out.println("""
                Ingrese una opción:
                1. Empezar.
                2. Mostrar estadísticas.
                3. Ganar vidas.
                4. Salir del juego.""");
    }

    public static void mostrarMapaGeografico() {
        System.out.println("""
                A continuación elija la zona geográfica con la que desea empezar:
                1. Zona norte.
                2. Zona central.
                3. Zona sur.""");
    }

    public static void mostrarAnimalesZonaNorte() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Alpaca.
                2. Vicuña.
                3. Guanaco.
                4. Llama.""");
    }

    public static void mostrarAnimalesZonaCentral() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Zorro Culpeo.
                2. Puma.
                3. Águila Mora.""");
    }

    public static void mostrarAnimalesZonaSur() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Pingüino.
                2. Zorro de la Patagonia.
                3. Ñandú.""");
    }
}