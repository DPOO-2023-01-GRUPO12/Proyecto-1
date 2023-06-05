package gui;

import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PanelPago extends JPanel
{
    private CampoNuevo campoNombre;
    private CampoNuevo campoId;
    private CampoNuevo campoCard;
    private CampoNuevo campoCVV;
    private CampoNuevo campoMonth;
    private CampoNuevo campoYear;
    private CampoNuevo campoCuenta;
    private RoundedButton btnPagar;
    
    public PanelPago()
    {
	setBackground(Color.white);
	setLayout(new BorderLayout());
	
	////PANEL DATOS
	JPanel panelDatos = new JPanel(new BorderLayout(0,15));
	panelDatos.setOpaque(false);
	int gap = 50; // Adjust the gap size as desired
        panelDatos.setBorder(new EmptyBorder(gap, gap, gap, gap));
	
	//titulo
	JPanel panelTitulo = new JPanel(new BorderLayout());
	//JPanel temp = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	//temp.setOpaque(false);
	panelTitulo.setOpaque(false);
	
	
	String[] paths = {".", "Icons", "paylogo.png" };
	
        String path = String.join(File.separator, paths);
        
	ImageIcon imageIcon = new ImageIcon(path);
	Image originalImage = imageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	JLabel logoGeneral = new JLabel(resizedIcon);
	panelTitulo.add(logoGeneral, BorderLayout.LINE_START);
	
	JLabel titulo = new JLabel("Payment",SwingConstants.LEFT);
	titulo.setFont(new Font("Roboto", Font.BOLD, 25));
	//titulo.setBorder(new EmptyBorder(0, 20, 0, 0));
	panelTitulo.add(titulo, BorderLayout.CENTER);
	//temp.add(logoGeneral);
	//temp.add(titulo);
	
	//panelTitulo.add(panelTitulo);
	JPanel otro = new JPanel();
	otro.setOpaque(false);
	//panelTitulo.add(otro);
	
	JPanel otro2 = new JPanel();
	otro2.setOpaque(false);
	//panelTitulo.add(otro2);
	
	JPanel otro3 = new JPanel();
	otro3.setOpaque(false);
	//panelTitulo.add(otro3);
	

	panelDatos.add(panelTitulo,BorderLayout.NORTH);
	
	add(panelDatos,BorderLayout.CENTER);
	
	
	
	
	// Fields
	
	JPanel panelCampos = new JPanel(new GridLayout(8,1,0,15));
	panelCampos.setOpaque(false);
	
	//nombre
	JPanel nombre = new JPanel(new GridLayout(1,2));
	nombre.setOpaque(false);
	//mensaje nombre
	JPanel textosNombre = new JPanel(new GridLayout(2,1));
	textosNombre.setOpaque(false);
	JLabel nombreLabel = new JLabel("Name");
	nombreLabel.setFont(new Font("Courier", Font.BOLD, 17));
	textosNombre.add(nombreLabel);
	JLabel nombremsg = new JLabel("Enter your name");
	nombremsg.setForeground(Color.LIGHT_GRAY);
	nombremsg.setFont(new Font("Courier", Font.PLAIN, 14));
	textosNombre.add(nombremsg);
	nombre.add(textosNombre);
	
	//box nombre
	campoNombre = new CampoNuevo(10,"");
	nombre.add(campoNombre);
	
	panelCampos.add(nombre);
	
	//identificacion
		JPanel identificacion = new JPanel(new GridLayout(1,2));
		identificacion.setOpaque(false);
		//mensaje id
		JPanel textosId = new JPanel(new GridLayout(2,1));
		textosId.setOpaque(false);
		JLabel idLabel = new JLabel("Identification");
		idLabel.setFont(new Font("Courier", Font.BOLD, 17));
		textosId.add(idLabel);
		JLabel idmsg = new JLabel("Enter your identification");
		idmsg.setForeground(Color.LIGHT_GRAY);
		idmsg.setFont(new Font("Courier", Font.PLAIN, 14));
		textosId.add(idmsg);
		identificacion.add(textosId);
		
		//box id
		campoId = new CampoNuevo(10,"");
		identificacion.add(campoId);
		
		panelCampos.add(identificacion);
	
	//card name
		JPanel textosCard = new JPanel(new GridLayout(2,1));
		textosCard.setOpaque(false);
		JLabel cardLabel = new JLabel("Card Number");
		cardLabel.setFont(new Font("Courier", Font.BOLD, 17));
		textosCard.add(cardLabel);
		JLabel cardmsg = new JLabel("Enter the 16-digit card number on the card");
		cardmsg.setForeground(Color.LIGHT_GRAY);
		cardmsg.setFont(new Font("Courier", Font.PLAIN, 14));
		textosCard.add(cardmsg);
		
		panelCampos.add(textosCard);
		
	//card campo
		
		campoCard = new CampoNuevo(10,"");
		panelCampos.add(campoCard);
		
	//CVV
		JPanel cvv = new JPanel(new GridLayout(1,2));
		cvv.setOpaque(false);
		//mensaje cvv
		JPanel textosCVV = new JPanel(new GridLayout(2,1));
		textosCVV.setOpaque(false);
		JLabel cvvLabel = new JLabel("CVV Number");
		cvvLabel.setFont(new Font("Courier", Font.BOLD, 17));
		textosCVV.add(cvvLabel);
		JLabel cvvmsg = new JLabel("Enter the 3 or 4 digit number on the card");
		cvvmsg.setForeground(Color.LIGHT_GRAY);
		cvvmsg.setFont(new Font("Courier", Font.PLAIN, 14));
		textosCVV.add(cvvmsg);
		cvv.add(textosCVV);
		
		//box nombre
		campoCVV = new CampoNuevo(10,"");
		cvv.add(campoCVV);
		
		panelCampos.add(cvv);
		
	//exp date
		JPanel date = new JPanel(new GridLayout(1,2));
		date.setOpaque(false);
		//mensaje date
		JPanel textosDate = new JPanel(new GridLayout(2,1));
		textosDate.setOpaque(false);
		JLabel dateLabel = new JLabel("Expiry Date");
		dateLabel.setFont(new Font("Courier", Font.BOLD, 17));
		textosDate.add(dateLabel);
		JLabel datemsg = new JLabel("Enter the expiration date of the card");
		datemsg.setForeground(Color.LIGHT_GRAY);
		datemsg.setFont(new Font("Courier", Font.PLAIN, 14));
		textosDate.add(datemsg);
		date.add(textosDate);
		
		//campos dates
		JPanel camposDate = new JPanel(new GridLayout(1,3));
		camposDate.setOpaque(false);
		campoMonth = new CampoNuevo(10, "");
		camposDate.add(campoMonth);
		JLabel sep = new JLabel("/",SwingConstants.CENTER);
		sep.setFont(new Font("Roboto", Font.BOLD, 17));
		camposDate.add(sep);
		campoYear = new CampoNuevo(10,"");
		camposDate.add(campoYear);
		
		date.add(camposDate);
		
		panelCampos.add(date);
		
	//card name
		JPanel textosCuenta = new JPanel(new GridLayout(2,1));
		textosCuenta.setOpaque(false);
		JLabel cuentaLabel = new JLabel("Account Number");
		cuentaLabel.setFont(new Font("Courier", Font.BOLD, 17));
		textosCuenta.add(cuentaLabel);
		JLabel cuentamsg = new JLabel("Enter the account number");
		cuentamsg.setForeground(Color.LIGHT_GRAY);
		cuentamsg.setFont(new Font("Courier", Font.PLAIN, 14));
		textosCuenta.add(cuentamsg);
				
		panelCampos.add(textosCuenta);
				
		//card campo
				
		campoCuenta= new CampoNuevo(10,"");
		panelCampos.add(campoCuenta);	
	
	panelDatos.add(panelCampos);
	//Boton
	
	btnPagar = new RoundedButton("Pay Now");
	btnPagar.setForeground(Color.white);
	btnPagar.setFont(new Font("Roboto",getFont().BOLD,14));
	btnPagar.setBackground(new Color(2,94,254));
	btnPagar.setFocusPainted(false);
	btnPagar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	panelDatos.add(btnPagar,BorderLayout.SOUTH);
	
	
	
	
	
	
	
	
	
	///////PANEL VISUAL
	JPanel panelVisual = new JPanel();
	panelVisual.setBackground(Color.red);
	
	
	
	
	add(panelVisual,BorderLayout.EAST);
	
	
	setVisible(true);
    }
    
    public static void main(String[] args)
    {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);

	int newWidth = (int) (1500 * 0.7);
        int newHeight = (int) (900 * 0.7);
        
        frame.setSize(newWidth, newHeight);
        
        frame.add(new PanelPago());
        
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
