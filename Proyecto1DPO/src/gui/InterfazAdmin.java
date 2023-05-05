package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import model.PMS;

public class InterfazAdmin extends JFrame {

    JRadioButton boton1;
    JRadioButton boton2;
    JRadioButton boton3;
    JRadioButton boton4;
    JRadioButton boton5;

    public InterfazAdmin(PMS pms) {
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Norte
        add(new JLabel("¿Qué desea hacer?"),BorderLayout.NORTH);
        







        // BOTONES 
        ButtonGroup bg = new ButtonGroup();
        
        radio1 = new JRadioButton("")
    }
}
