package datos;

public class VerificadorContraseñaJugador {
    public static void main(String[] args) {
        System.out.println(verificarContraseña(""));
    }

    public static boolean verificarContraseña(String contrasena){
        if(esAlfaNumerico(contrasena) && !esEspacioVacio(contrasena) && esLongitudCorrecta(contrasena)){
            return true;
        }else {
            return false;
        }
    }

    private static boolean esAlfaNumerico(String s) {
        return s != null && s.matches("^[a-zA-Z0-9-ñ]*$");
    }

    private static boolean esEspacioVacio(String contrasena){
        return contrasena.isEmpty();
    }

    private static boolean esLongitudCorrecta(String contrasena){
        if(contrasena.length() > 10 || contrasena.length() < 5){
            return false;
        }else {
            return true;
        }
    }
}