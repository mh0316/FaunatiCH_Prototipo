package guis;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FondoVentanaInicioSesion extends JPanel {
    @Override
    public void paint (Graphics g){
        File archivo = new File("C:\\Users\\Chevy\\Desktop\\Marcelo 2022\\UFRO\\Ingeniería civil informática\\Segundo Semestre 2022\\Asignaturas\\Programación\\Imágenes proyecto grupal\\Fondo Inicio Sesion.jpeg");
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read((archivo));
        }catch (IOException e){
            e.printStackTrace();
        }

        assert bufferedImage != null;
        ImageIcon imagen = new ImageIcon(bufferedImage);
        g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}