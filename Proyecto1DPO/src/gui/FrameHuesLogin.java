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
        
        
        
        String[] names = { ".", "Icons", "close.png" };
        String path = String.join(File.separator, names);
        
        try {
            BufferedImage img = ImageIO.read(new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(220,220,220));
        titleBar.setPreferredSize(new Dimension(getWidth(), 33));
        
        JButton closeButton = new JButton("");
        try {
            BufferedImage img = ImageIO.read(new File(path));
            Image image = img.getScaledInstance(15, 15,Image.SCALE_SMOOTH);

            closeButton.setIcon(new ImageIcon(image));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        closeButton.setFont(new Font("Roboto", Font.BOLD,15));
        closeButton.setFocusPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setForeground(Color.BLACK);
       
        
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(path));
                    Image image = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                    
                    // Apply color filter to the image
                    ImageFilter filter = new RGBImageFilter() {
                        public int filterRGB(int x, int y, int rgb) {
                            // Change color to red
                            return (rgb & 0xFF00FFFF) | (0xFF << 16);
                        }
                    };
                    
                    ImageProducer producer = new FilteredImageSource(image.getSource(), filter);
                    Image redImage = Toolkit.getDefaultToolkit().createImage(producer);
                    
                    closeButton.setIcon(new ImageIcon(redImage));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    BufferedImage img = ImageIO.read(new File(path));
                    Image image = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                    closeButton.setIcon(new ImageIcon(image));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        titleBar.add(closeButton, BorderLayout.EAST);
        add(titleBar, BorderLayout.NORTH);
        
	
	
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
        setUndecorated(true);
        setShape(createRoundRectangle(getWidth(), getHeight()));
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

    public void iniciarSesion()
    {
	System.out.println("inicio de sesion");
	
    }

    public void crearUsuario(String login, String pass)
    {
	sistema.agregarUsuarioHuesped(login, pass);
	
    }
}
