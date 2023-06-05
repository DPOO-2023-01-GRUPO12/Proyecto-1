package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import console.MenuRecepcionista;
import model.Habitacion;
import model.Huesped;
import model.PMS;
import model.Reserva;

//import model.PMS;

public class VentanaHuesped extends JFrame implements ActionListener
{
    private JMenu menu;  
    private JMenuItem salir, dispo;
    private FrameHuesLogin frame;
    private CardLayout cl;
    private PMS sistema;
    private JPanel todos;
    private MenuRecepcionista menuRecep;
    
    public VentanaHuesped(FrameHuesLogin frame, String username,PMS pms)
    {
	sistema = pms;
	menuRecep = new MenuRecepcionista(pms.getCargador(), pms);
	this.frame= frame;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	int newWidth = (int) (1500 * 0.7);
        int newHeight = (int) (900 * 0.7);
	setSize(newWidth, newHeight);
	
	
        
	// Customize the menu bar appearance
        UIManager.put("MenuBar.background", new Color(40, 40, 43));
        UIManager.put("MenuBar.border", BorderFactory.createEmptyBorder());
        UIManager.put("Menu.foreground", Color.WHITE);
        UIManager.put("Menu.font", new Font("Roboto", Font.BOLD, 14));
        UIManager.put("MenuItem.background", new Color(40, 40, 43));
        UIManager.put("MenuItem.foreground", Color.WHITE);
        UIManager.put("MenuItem.font", new Font("Roboto", Font.PLAIN, 14));
        UIManager.put("MenuItem.border", BorderFactory.createEmptyBorder());
        
        //Menu bar
        JMenuBar mb=new JMenuBar();
	menu=new JMenu(username);  
	dispo = new JMenuItem("Disponibilidad");
	dispo.addActionListener(this);
	menu.add(dispo);
	salir = new JMenuItem("Salir");	
	salir.addActionListener(this);
	menu.add(salir);
	
	mb.add(menu);
	setJMenuBar(mb);
	
	todos = new JPanel();
	cl = new CardLayout();
	todos.setLayout(cl);
	todos.setOpaque(false);
	
	//Disponibilidad
          
        PanelDisponibilidad panelDisponibilidad = new PanelDisponibilidad(this,pms);
        
        todos.add(panelDisponibilidad,"dispo");
        cl.show(todos, "dispo");
        
        
        //Reservas
        
        add(todos);
	
	
	setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource()==salir) {
	    setVisible(false);
	    frame.setVisible(true);
	} else if(e.getSource()==dispo) {
	    cl.show(todos, "dispo");
	}
	
    }

    public void mostrarPanelReserva(Habitacion habitacion, String rango)
    {
	PanelReservaHuesped panelReserva = new PanelReservaHuesped(this,sistema,habitacion,rango);
	todos.add(panelReserva,"res");
	cl.show(todos,"res");
	
    }

    public void realizarReserva(String nombre, String cantidadPersonas, String fechain, String fechaout)
    {
	int cantidad = Integer.parseInt(cantidadPersonas);

	Huesped huesped = sistema.getHuespedes().get(nombre);
        Reserva reserva = new Reserva(huesped, cantidad, fechain, fechaout);
        double montoHabitaciones =0;
        try
	{
	    montoHabitaciones = menuRecep.configurarTarifaTotal(fechain, fechaout, cantidad, reserva);
	} catch (ParseException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        sistema.agregarReserva(reserva);
        sistema.agregarFechas(reserva);
        int a = JOptionPane.showConfirmDialog(this,"¿Desea pagar de inmediato?");
        if(a==JOptionPane.YES_OPTION){  
            PanelPago panelPagoReserva = new PanelPago(this,sistema,huesped,montoHabitaciones,0.9,reserva);
            todos.add(panelPagoReserva,"pago");
            cl.show(todos,"pago");
        }else {
            setVisible(false);
            frame.setVisible(true);
        }
        
        
       
	
    }

    public void registroHuespedReserva(String nombre, String documento, String celular, String Correo, String edad)
    {
        Integer edadint = Integer.parseInt(edad);
        Huesped huesped = new Huesped(nombre, documento, celular, Correo, edadint);
        sistema.agregarHuesped(huesped);
	
    }

}
