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
           
            String[] fechas = fecha.strip().split("/");
            columna = Integer.parseInt(fechas[0]);
            fila = Integer.parseInt(fechas[1]);
            Color color = getDarkeningGreen(pms.getFechas().get(fecha));
            posx = (columna * heightCas);
            posy = (fila * widthCas);
            System.out.println(pms.getFechas().get(fecha));
            
            
            
            g2d.setColor(color);
            g2d.fillRoundRect(posx, posy, widthCas, widthCas,10,10);
            g2d.setColor(Color.black);
            g2d.drawRoundRect(posx, posy, widthCas, widthCas,10,10);
            
        }

    }

    public Color getDarkeningGreen(int value) {
        float hue = 120f / 360f; // green hue
        float saturation = 1.0f;
        float brightness = (float) (1.0 - value / 200.0); // linear scaling
        if(value == 0){
            return Color.white;
        }
        return Color.getHSBColor(hue, saturation, brightness);
    }
    
    


   
}
