package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import console.MenuAdministrador;

public class DialogOpcHabitacion extends JDialog implements ActionListener{
	
	private ButtonGroup bgCocina;
	private JRadioButton tieneCocina;
	private JRadioButton notieneCocina;
	
	private ButtonGroup bgVista;
	private JRadioButton tieneVista;
	private JRadioButton notieneVista;
	
	private ButtonGroup bgBalcon;
	private JRadioButton tieneBalcon;
	private JRadioButton notieneBalcon;
	
	
	private ButtonGroup bgAire;
	private JRadioButton tieneAire;
	private JRadioButton notieneAire;
	
	
	private ButtonGroup bgCalefaccion;
	private JRadioButton tieneCalefaccion;
	private JRadioButton notieneCalefaccion;
	
	
	private ButtonGroup bgRopaDeCama;
	private JRadioButton tieneRopaDeCama;
	private JRadioButton notieneRopaDeCama;
	
	private ButtonGroup bgCafetera;
	private JRadioButton tieneCafetera;
	private JRadioButton notieneCafetera;
	
	private ButtonGroup bgSecadora;
	private JRadioButton tieneSecadora;
	private JRadioButton notieneSecadora;
	
	
	private ButtonGroup bgPlancha;
	private JRadioButton tienePlancha;
	private JRadioButton notienePlancha;
	
	private ButtonGroup bgUSBA;
	private JRadioButton tieneUSBA;
	private JRadioButton notieneUSBA;
	
	private ButtonGroup bgUSBC;
	private JRadioButton tieneUSBC;
	private JRadioButton notieneUSBC;
	
	private ButtonGroup bgDesayuno;
	private JRadioButton tieneDesayuno;
	private JRadioButton notieneDesayuno;
	
	
	private NormalButton btnEnviar;
	
	private MenuAdministrador admin;
	
	public DialogOpcHabitacion(MenuAdministrador menu ) {
		
		admin= menu;
		
		
		
		JPanel general = new JPanel(new GridLayout(13,1));
		setVisible(true);
		
		// COCINA
		JPanel cocina = new JPanel(new BorderLayout());
        cocina.setBackground(Color.white);
        JLabel tituloCocina = new JLabel("Tiene Cocina", SwingConstants.CENTER);
        tituloCocina.setFont(new Font("Roboto", Font.BOLD, 15));
        cocina.add(tituloCocina, BorderLayout.NORTH);

        JPanel radiobuttons = new JPanel(new FlowLayout());
        radiobuttons.setBackground(Color.white);
        bgCocina = new ButtonGroup();

        tieneCocina = new JRadioButton("Si");
        notieneCocina = new JRadioButton("No");
        tieneCocina.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneCocina.setBackground(Color.white);

        bgCocina.add(tieneCocina);
        bgCocina.add(notieneCocina);
        radiobuttons.add(tieneCocina);
        radiobuttons.add(notieneCocina);
        
        cocina.add(radiobuttons,BorderLayout.SOUTH);
        
        
        
        cocina.setVisible(true);
       
        
        general.add(cocina);
        
        
        //VISTA
        
        
        JPanel vista = new JPanel(new BorderLayout());
        vista.setBackground(Color.white);
        JLabel tituloVista = new JLabel("Tiene Vista", SwingConstants.CENTER);
        tituloVista.setFont(new Font("Roboto", Font.BOLD, 15));
        vista.add(tituloVista, BorderLayout.NORTH);

        JPanel radiobuttons2 = new JPanel(new FlowLayout());
        radiobuttons2.setBackground(Color.white);
        bgVista = new ButtonGroup();

        tieneVista = new JRadioButton("Si");
        notieneVista = new JRadioButton("No");
        tieneVista.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneVista.setBackground(Color.white);

        bgVista.add(tieneVista);
        bgVista.add(notieneVista);
        radiobuttons2.add(tieneVista);
        radiobuttons2.add(notieneVista);
        
        vista.add(radiobuttons2,BorderLayout.SOUTH);
        
        
        
        vista.setVisible(true);
       
        
        general.add(vista);
        
        
        //BALCON
        
        JPanel balcon = new JPanel(new BorderLayout());
        balcon.setBackground(Color.white);
        JLabel tituloBalcon = new JLabel("Tiene Balcon", SwingConstants.CENTER);
        tituloBalcon.setFont(new Font("Roboto", Font.BOLD, 15));
        balcon.add(tituloBalcon, BorderLayout.NORTH);

        JPanel radiobuttons3 = new JPanel(new FlowLayout());
        radiobuttons3.setBackground(Color.white);
        bgBalcon = new ButtonGroup();

        tieneBalcon = new JRadioButton("Si");
        notieneBalcon = new JRadioButton("No");
        tieneBalcon.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneBalcon.setBackground(Color.white);

        bgBalcon.add(tieneBalcon);
        bgBalcon.add(notieneBalcon);
        radiobuttons3.add(tieneBalcon);
        radiobuttons3.add(notieneBalcon);
        
        balcon.add(radiobuttons3,BorderLayout.SOUTH);
        
        
        
        balcon.setVisible(true);
       
        
        general.add(balcon);

        
        
        
        
        
        //AIRE
        
        
        JPanel aire = new JPanel(new BorderLayout());
        aire.setBackground(Color.white);
        JLabel tituloAire = new JLabel("Tiene Aire Acondicionado", SwingConstants.CENTER);
        tituloAire.setFont(new Font("Roboto", Font.BOLD, 15));
        aire.add(tituloAire, BorderLayout.NORTH);

        JPanel radiobuttons4 = new JPanel(new FlowLayout());
        radiobuttons4.setBackground(Color.white);
        bgAire= new ButtonGroup();

        tieneAire = new JRadioButton("Si");
        notieneAire = new JRadioButton("No");
        tieneAire.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneAire.setBackground(Color.white);

        bgAire.add(tieneAire);
        bgAire.add(notieneAire);
        radiobuttons4.add(tieneAire);
        radiobuttons4.add(notieneAire);
        
        aire.add(radiobuttons4,BorderLayout.SOUTH);
        
        aire.setVisible(true);
       
        
        general.add(aire);

        
        //CALEFACCION
        
        JPanel calefaccion = new JPanel(new BorderLayout());
        calefaccion.setBackground(Color.white);
        JLabel tituloCalefaccion = new JLabel("Tiene Calefaccion", SwingConstants.CENTER);
        tituloCalefaccion.setFont(new Font("Roboto", Font.BOLD, 15));
        calefaccion.add(tituloCalefaccion, BorderLayout.NORTH);

        JPanel radiobuttons5 = new JPanel(new FlowLayout());
        radiobuttons5.setBackground(Color.white);
        bgCalefaccion= new ButtonGroup();

        tieneCalefaccion = new JRadioButton("Si");
        notieneCalefaccion = new JRadioButton("No");
        tieneCalefaccion.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneCalefaccion.setBackground(Color.white);

        bgCalefaccion.add(tieneCalefaccion);
        bgCalefaccion.add(notieneCalefaccion);
        radiobuttons5.add(tieneCalefaccion);
        radiobuttons5.add(notieneCalefaccion);
        
        calefaccion.add(radiobuttons5,BorderLayout.SOUTH);
        
        calefaccion.setVisible(true);
       
        
        general.add(calefaccion);
        
        //ROPA DE CAMA
        
        
        JPanel ropadecama = new JPanel(new BorderLayout());
        ropadecama.setBackground(Color.white);
        JLabel tituloropadecama = new JLabel("Tiene RopaDecama", SwingConstants.CENTER);
        tituloropadecama.setFont(new Font("Roboto", Font.BOLD, 15));
        ropadecama.add(tituloropadecama, BorderLayout.NORTH);

        JPanel radiobuttons6 = new JPanel(new FlowLayout());
        radiobuttons6.setBackground(Color.white);
        bgRopaDeCama= new ButtonGroup();

        tieneRopaDeCama = new JRadioButton("Si");
        notieneRopaDeCama = new JRadioButton("No");
        tieneRopaDeCama.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneRopaDeCama.setBackground(Color.white);

        bgRopaDeCama.add(tieneRopaDeCama);
        bgRopaDeCama.add(notieneRopaDeCama);
        radiobuttons6.add(tieneRopaDeCama);
        radiobuttons6.add(notieneRopaDeCama);
        
        ropadecama.add(radiobuttons6,BorderLayout.SOUTH);
        
        ropadecama.setVisible(true);
       
        
        general.add(ropadecama);
        
        
        
        //CAFETERA
        
        
        JPanel cafetera = new JPanel(new BorderLayout());
        cafetera.setBackground(Color.white);
        JLabel titulocafetera = new JLabel("Tiene Cafetera", SwingConstants.CENTER);
        titulocafetera.setFont(new Font("Roboto", Font.BOLD, 15));
        cafetera.add(titulocafetera, BorderLayout.NORTH);

        JPanel radiobuttons7 = new JPanel(new FlowLayout());
        radiobuttons7.setBackground(Color.white);
        bgCafetera= new ButtonGroup();

        tieneCafetera = new JRadioButton("Si");
        notieneCafetera = new JRadioButton("No");
        tieneCafetera.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneCafetera.setBackground(Color.white);

        bgCafetera.add(tieneCafetera);
        bgCafetera.add(notieneCafetera);
        radiobuttons7.add(tieneCafetera);
        radiobuttons7.add(notieneCafetera);
        
        cafetera.add(radiobuttons7,BorderLayout.SOUTH);
        cafetera.setVisible(true);
       
        
        general.add(cafetera);
        //PLANCHA
        
        JPanel plancha = new JPanel(new BorderLayout());
        plancha.setBackground(Color.white);
        JLabel tituloplancha = new JLabel("Tiene Plancha", SwingConstants.CENTER);
        tituloplancha.setFont(new Font("Roboto", Font.BOLD, 15));
        plancha.add(tituloplancha, BorderLayout.NORTH);

        JPanel radiobuttons8 = new JPanel(new FlowLayout());
        radiobuttons8.setBackground(Color.white);
        bgPlancha= new ButtonGroup();

        tienePlancha = new JRadioButton("Si");
        notienePlancha = new JRadioButton("No");
        tienePlancha.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notienePlancha.setBackground(Color.white);

        bgPlancha.add(tienePlancha);
        bgPlancha.add(notienePlancha);
        radiobuttons8.add(tienePlancha);
        radiobuttons8.add(notienePlancha);
        
        plancha.add(radiobuttons8,BorderLayout.SOUTH);
        plancha.setVisible(true);
       
        
        general.add(plancha);
        //SECADOR
        
        
        JPanel secador = new JPanel(new BorderLayout());
        secador.setBackground(Color.white);
        JLabel titulosecador = new JLabel("Tiene Secador", SwingConstants.CENTER);
        titulosecador.setFont(new Font("Roboto", Font.BOLD, 15));
        secador.add(titulosecador, BorderLayout.NORTH);

        JPanel radiobuttons9 = new JPanel(new FlowLayout());
        radiobuttons9.setBackground(Color.white);
        bgSecadora= new ButtonGroup();

        tieneSecadora = new JRadioButton("Si");
        notieneSecadora = new JRadioButton("No");
        tieneSecadora.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneSecadora.setBackground(Color.white);

        bgSecadora.add(tieneSecadora);
        bgSecadora.add(notieneSecadora);
        radiobuttons9.add(tieneSecadora);
        radiobuttons9.add(notieneSecadora);
        
        secador.add(radiobuttons9,BorderLayout.SOUTH);
        secador.setVisible(true);
       
        
        general.add(secador);
        
        //usb-a
        
        JPanel usba = new JPanel(new BorderLayout());
        usba.setBackground(Color.white);
        JLabel titulousba = new JLabel("Tiene USB-A", SwingConstants.CENTER);
        titulousba.setFont(new Font("Roboto", Font.BOLD, 15));
        usba.add(titulousba, BorderLayout.NORTH);

        JPanel radiobuttons10 = new JPanel(new FlowLayout());
        radiobuttons10.setBackground(Color.white);
        bgUSBA= new ButtonGroup();

        tieneUSBA = new JRadioButton("Si");
        notieneUSBA = new JRadioButton("No");
        tieneUSBA.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneUSBA.setBackground(Color.white);

        bgUSBA.add(tieneUSBA);
        bgUSBA.add(notieneUSBA);
        radiobuttons10.add(tieneUSBA);
        radiobuttons10.add(notieneUSBA);
        
        usba.add(radiobuttons10,BorderLayout.SOUTH);
        usba.setVisible(true);
       
        
        general.add(usba);
        
        
        //USB-C
        
        JPanel usbc = new JPanel(new BorderLayout());
        usbc.setBackground(Color.white);
        JLabel titulousbc = new JLabel("Tiene USB-C", SwingConstants.CENTER);
        titulousbc.setFont(new Font("Roboto", Font.BOLD, 15));
        usbc.add(titulousbc, BorderLayout.NORTH);

        JPanel radiobuttons11 = new JPanel(new FlowLayout());
        radiobuttons11.setBackground(Color.white);
        bgUSBC= new ButtonGroup();

        tieneUSBC = new JRadioButton("Si");
        notieneUSBC = new JRadioButton("No");
        tieneUSBC.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneUSBC.setBackground(Color.white);

        bgUSBC.add(tieneUSBC);
        bgUSBC.add(notieneUSBC);
        radiobuttons11.add(tieneUSBC);
        radiobuttons11.add(notieneUSBC);
        
        usbc.add(radiobuttons11,BorderLayout.SOUTH);
        usbc.setVisible(true);
       
        
        general.add(usbc);
        
        //DESAYUNO
        
        JPanel desayuno = new JPanel(new BorderLayout());
        desayuno.setBackground(Color.white);
        JLabel titulodesayuno = new JLabel("Tiene Desayuno", SwingConstants.CENTER);
        titulodesayuno.setFont(new Font("Roboto", Font.BOLD, 15));
        desayuno.add(titulodesayuno, BorderLayout.NORTH);

        JPanel radiobuttons12 = new JPanel(new FlowLayout());
        radiobuttons12.setBackground(Color.white);
        bgDesayuno= new ButtonGroup();

        tieneDesayuno = new JRadioButton("Si");
        notieneDesayuno = new JRadioButton("No");
        tieneDesayuno.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        notieneDesayuno.setBackground(Color.white);

        bgDesayuno.add(tieneDesayuno);
        bgDesayuno.add(notieneDesayuno);
        radiobuttons12.add(tieneDesayuno);
        radiobuttons12.add(notieneDesayuno);
        
        desayuno.add(radiobuttons12,BorderLayout.SOUTH);
        desayuno.setVisible(true);
       
        
        general.add(desayuno);
        
		
        btnEnviar = new NormalButton("ENVIAR");
        
        btnEnviar.addActionListener(this);
        
        general.add(btnEnviar);
        
        add(general);
        setSize(600,800);
        
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean tieneCocinas = false;
        boolean tieneBalcons = false;
        boolean tieneVistas = false;
        boolean tieneAires = false;
        boolean tieneCalefaccions = false;
        boolean tieneRopadecamas = false;
        boolean tieneSecador = false;
        boolean tienePlanchas = false;
        boolean tieneUSBAs = false;
        boolean tieneUSBCs = false;
        boolean tieneDesayunos = false;
        
        
        

        if (tieneCocina.isSelected()) {
            tieneCocinas = true;
        }

        if (tieneBalcon.isSelected()) {
            tieneBalcons = true;
        }

        if (tieneAire.isSelected()) {
            tieneAires = true;
        }
        if (tieneCalefaccion.isSelected()) {
            tieneCalefaccions = true;
        }
        if (tieneRopaDeCama.isSelected()) {
            tieneRopadecamas = true;
        }
        if (tieneSecadora.isSelected()) {
            tieneSecador = true;
        }
        if (tienePlancha.isSelected()) {
            tienePlanchas = true;
        }
        if (tieneUSBA.isSelected()) {
            tieneUSBAs = true;
        }
        if (tieneUSBC.isSelected()) {
            tieneUSBCs = true;
        }
        if (tieneDesayuno.isSelected()) {
            tieneDesayunos = true;
        }
        
        
        admin.crearHabitacion(getTitle(), getWarningString(), getName());
        
        
        
		
	}
	
	
	





}
