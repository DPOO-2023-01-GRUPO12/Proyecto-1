package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;

import javax.swing.*;

import model.PMS;

public class Concurrencia extends JPanel {
    PMS sistema;
    public Concurrencia(PMS pms){
        sistema=pms;
        setVisible(true);


    }
        @Override
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Map<String,Integer> mapaFechas = sistema.getFechas();

        // Dibujar las casillas de la concurrencia 


        for (Map.Entry<String, Integer> entry : mapaFechas.entrySet()){

            if(entry.getValue() ==  0){
                g2d.setColor(Color.white);
            }
            else if(entry.getValue() >0){

                g2d.setColor(Color.green);

             }
        }
    
    


   
    
}
}
