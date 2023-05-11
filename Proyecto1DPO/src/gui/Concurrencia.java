package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import model.PMS;

public class Concurrencia extends JPanel {
    private PMS pms;
    public Concurrencia(PMS sistema){
        pms=sistema;
        setVisible(true);


    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int widthCas = 25;
        int heightCas = 25;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int columna;
        int fila;
        int posx = 30;
        int posy = 30;
        for (String fecha : pms.getFechas().keySet()) {
            posx = 30;
            posy = 30;
            String[] fechas = fecha.strip().split("/");
            columna = Integer.parseInt(fechas[0]);
            fila = Integer.parseInt(fechas[1]);
            Color color = getDarkeningGreen(pms.getFechas().get(fecha));
            posx = (columna * widthCas);
            posy = (fila * heightCas);

            g2d.setColor(Color.black);
            g2d.drawRect(posx, posy, widthCas, widthCas);
            g2d.setColor(color);
            g2d.fillRect(posx, posy, widthCas, widthCas);
            g2d.setColor(Color.LIGHT_GRAY);
        }

    }

    public Color getDarkeningGreen(int value) {
        float hue = 120f / 360f; // green hue
        float saturation = 1.0f;
        float brightness = (float) (1.0 - value / 200.0); // linear scaling
        return Color.getHSBColor(hue, saturation, brightness);
    }
    
    


   
}
