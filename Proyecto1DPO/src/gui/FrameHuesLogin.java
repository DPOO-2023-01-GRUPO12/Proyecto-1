package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import model.PMS;
import persistencia.Cargador;



public class FrameHuesLogin extends JFrame
{
    private PanelLogin panelLogin;
    private PanelSignUp panelSignup;
    private CardLayout cardlayout;
    private JPanel ambos;
    private PMS sistema;
    private VentanaHuesped ventanaHues;
    
    
    public FrameHuesLogin() {
	sistema = new PMS();
	Cargador cargador = sistema.getCargador();
	
	String[] pathNames = {".", "data", "usuariosHues.txt" };
        String pathUsers = String.join(File.separator, pathNames);
       
        File f = new File(pathUsers);
        
        try {
            File fileUsers = f.getCanonicalFile();
            cargador.cargarUsuariosHuespedes(fileUsers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        ///Cargar datos
        
        String[] paths = {".", "data", "nombresarchivos.txt" };
        String realpath = String.join(File.separator, paths);
        
        File archivoHotel = new File(realpath);
	    try
	    {
		sistema.getCargador().cargarInformacionHotel(archivoHotel);
	    } catch (IOException e1)
	    {
		System.out.println("No se cargó el archivo");
	    }
        ////
	
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
        
        
        panelLogin = new PanelLogin(this,sistema);
        ambos.add(panelLogin, "login");
        
        panelSignup = new PanelSignUp(this,sistema);
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
    
    private Shape createRoundRectangle(int width, int height) {
        return new RoundRectangle2D.Double(0, 0, width, height, 25, 25);
    }
    
    public static void main(String[] args) {
        new FrameHuesLogin();
        

    }

    public void mostrarSignUp()
    {
	cardlayout.show(ambos, "signup");
	
    }

    
    public void mostrarSignIn()
    {
	cardlayout.show(ambos, "login");
	
    }

    public void iniciarSesion(String username)
    {
	setVisible(false);
	ventanaHues = new VentanaHuesped(this, username,sistema);
    }

    public void crearUsuario(String login, String pass)
    {
	sistema.agregarUsuarioHuesped(login, pass);
	
    }
}
