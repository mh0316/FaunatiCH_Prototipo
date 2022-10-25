package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentesInicioSesion extends JFrame  implements ActionListener {
    VentanaInicioSesion ventana;
    private JButton botonAceptar;
    private JButton botonSalir;
    private JTextField cajaDeTextoRut;
    private JPasswordField cajaDeTextoContraseña;

    public void agregarBotones(FondoVentanaInicioSesion fondo){
        botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        botonAceptar.setBounds(400,350,80,30);
        botonAceptar.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonAceptar);
        botonAceptar.setOpaque(true);
        botonAceptar.setBackground(Color.white);
        botonAceptar.setForeground(Color.black);

        botonSalir = new JButton();
        botonSalir.setText("Salir");
        botonSalir.setBounds(510,350,80,30);
        botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonSalir);
        botonSalir.setOpaque(true);
        botonSalir.setBackground(Color.white);
        botonSalir.setForeground(Color.black);

        agregarCajasDeTexto(fondo);
    }

    private void agregarCajasDeTexto(FondoVentanaInicioSesion fondo){
        cajaDeTextoRut = new JTextField();
        cajaDeTextoRut.setBounds(430,210,130,30);
        fondo.add(cajaDeTextoRut);

        cajaDeTextoContraseña = new JPasswordField();
        cajaDeTextoContraseña.setBounds(430,280,130,30);
        fondo.add(cajaDeTextoContraseña);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonSalir){
            new VentanaInicioSesion(this.ventana);
            this.dispose();
        }else if(e.getSource() == botonAceptar){

        }
    }
}