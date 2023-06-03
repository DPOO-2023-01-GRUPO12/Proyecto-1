package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;



public class FrameHuesped extends JFrame
{
    private PanelLogin panelLogin;
    private PanelSignUp panelSignup;
    private CardLayout cardlayout;
    private JPanel ambos;
    
    public FrameHuesped() {
   	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	int newWidth = (int) (1500 * 0.7);
        int newHeight = (int) (900 * 0.7);
        
        setSize(newWidth, newHeight);
        JLayeredPane pane = new JLayeredPane();
        pane.setOpaque(false);
        
        
        //Background

        
        
        
        BackgroundHues background = new BackgroundHues(this);
        background.setVisible(true);
        background.setBounds(0, 0, getWidth(), getHeight());
        background.setBounds(0, 0, getWidth(), getHeight());
        add(background);
        
        background.setLayout(new GridLayout(1,3));
 
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        
        
        background.add(p1);
        ///CAMPOS LOGIN
        cardlayout = new CardLayout();
        ambos = new JPanel();
        ambos.setOpaque(false);
        ambos.setLayout(cardlayout);
        
        
        panelLogin = new PanelLogin(this);
        ambos.add(panelLogin, "login");
        
        panelSignup = new PanelSignUp(this);
        ambos.add(panelSignup,"signup");
        
        cardlayout.show(ambos, "login");
        
        background.add(ambos);
        ///
        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        
        background.add(p2);
        setLocationRelativeTo(null);

        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FrameHuesped();
        

    }

    public void mostrarSignUp()
    {
	cardlayout.show(ambos, "signup");
	
    }

    
    public void mostrarSignIn()
    {
	cardlayout.show(ambos, "login");
	
    }

    public boolean revisarExistencia(String strip)
    {
	// TODO Auto-generated method stub
	return false;
    }

    public boolean revisarPassword(String text, String text2)
    {
	// TODO Auto-generated method stub
	return false;
    }

    public void iniciarSesion()
    {
	// TODO Auto-generated method stub
	
    }
}
