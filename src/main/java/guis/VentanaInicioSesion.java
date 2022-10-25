package guis;

import javax.swing.*;

public class VentanaInicioSesion extends JFrame {
    FondoVentanaInicioSesion fondo = new FondoVentanaInicioSesion();
    ComponentesInicioSesion componentes = new ComponentesInicioSesion();
    private JPanel panel;

    public VentanaInicioSesion(){
        setSize(700,500);
        setLocationRelativeTo(null);
        fondo.setLayout(null);
        this.getContentPane().add(fondo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        agregarPartes();
    }

    private void agregarPartes(){
        componentes.agregarBotones(fondo);
        agregarPanel();
    }

    private void agregarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
    }
}