package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Autenticador;
import model.AutenticadorHuesped;
import model.PMS;

public class PanelLogin extends JPanel implements ActionListener
{
    private JPanel contentPanel;
    private CampoHues user;
    private CampoHues password;
    private RoundedButtonHues signin;
    private FrameHuesLogin frameHues;
    private AutenticadorHuesped authenticator;
    
    public PanelLogin(FrameHuesLogin frameHuesped, PMS pms)
    {
	authenticator = new AutenticadorHuesped(pms);
	
	
        setOpaque(false);
        setLayout(new GridLayout(3,1));
        
        frameHues = frameHuesped;
        //Panel titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false);
        panelTitulo.setLayout(new GridLayout(3,1));
        
        	
        	JPanel iconoPanel = new JPanel(new GridLayout(1,3));
        	iconoPanel.setOpaque(false);
        	JPanel temp1 = new JPanel();
        	temp1.setOpaque(false);
       
        	
        	panelTitulo.add(temp1);
 
        
        	
        	
        	
        	//message
        	JPanel temp2 = new JPanel();
        	temp2.setOpaque(false);
        	panelTitulo.add(temp2);
        	
        	//Title
        	JLabel titulo = new JLabel("Sign in", SwingConstants.CENTER);
        	titulo.setForeground(Color.white);
        	titulo.setFont(new Font("Courier Bold", Font.BOLD, 33));
        	panelTitulo.add(titulo);
        
        //Panel Inputs
        JPanel inputs = new JPanel();
        inputs.setOpaque(false);
        
        inputs.setLayout(new GridLayout(3,1));
        
        	//Login
        	JPanel campoUser = new JPanel();
        	campoUser.setOpaque(false);
        	GridBagLayout layout = new GridBagLayout();
        	campoUser.setLayout(layout);
        	GridBagConstraints gbc = new GridBagConstraints();
        	
        	gbc.fill = GridBagConstraints.VERTICAL;
        	gbc.gridx = 1;
        	gbc.gridy = 1;
        	
        	///////////////CAMPO USER
        	user = new CampoHues(20,"   User"); 
        	campoUser.add(user,gbc);
        	inputs.add(campoUser);
        	///////////////
        	
        	
        	//Password
        	JPanel campoPass = new JPanel(); 
        	campoPass.setOpaque(false);
        	campoPass.setLayout(layout);
        	
        	//////////////CAMPO PASS
        	password = new CampoHues(20,"   Password"); //tiene listener
        	campoPass.add(password,gbc);
        	inputs.add(campoPass);
        	//////////////
        	
        	//Sign in
        	JPanel panelBotonIn = new JPanel();
        	
        	panelBotonIn.setOpaque(false);
        	panelBotonIn.setLayout(layout);
        	
        	//////////////BOTON LOGIN
        	signin = new RoundedButtonHues("LOG IN"); //tiene listener
        	signin.setFont(new Font("Roboto",getFont().BOLD,14));
        	signin.setBackground(new Color(255,255,255));
        	signin.setFocusPainted(false);
        	signin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        	signin.addActionListener(this);
        	//////////////
        	
        	JPanel signinWrapper = new JPanel(new BorderLayout());
        	signinWrapper.setOpaque(false);
                signinWrapper.add(signin,BorderLayout.CENTER);
                signinWrapper.setPreferredSize(new Dimension(130, 38)); // Set the preferred size of the wrapper panel

                panelBotonIn.add(signinWrapper);

        	inputs.add(panelBotonIn);
        	
        	
        	
        
        
        //Panel extra
        JPanel extra = new JPanel();
        extra.setOpaque(false);
        extra.setLayout(new GridLayout(3,1));
        		//Panel mensaje
        		JPanel panelUp = new JPanel();
        		panelUp.setOpaque(false);
        		
        		//Paneles de mensaje y link
        		JPanel textos = new JPanel(new FlowLayout());
        		textos.setOpaque(false);
        		JLabel messageUp = new JLabel("Not a member?");
        		messageUp.setForeground(Color.white);
        		textos.add(messageUp);
        		
        		JLabel signUpLink = new JLabel("Sign Up");
        		signUpLink.setForeground(Color.CYAN.darker());
        		signUpLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        		signUpLink.addMouseListener(new MouseAdapter() {
        		    
        		    @Override
        		    public void mouseClicked(MouseEvent e) {
        		        frameHuesped.mostrarSignUp();
        		    }
        		 
        		    @Override
        		    public void mouseEntered(MouseEvent e) {
        		        // the mouse has entered the label
        		    }
        		 
        		    @Override
        		    public void mouseExited(MouseEvent e) {
        		        // the mouse has exited the label
        		    }
        		});
        		textos.add(signUpLink);
        		
        		panelUp.add(textos);
        		
        		extra.add(panelUp);
        		
        		
        		JPanel va1 = new JPanel();
        		va1.setOpaque(false);
        		extra.add(va1);
        		
        		JPanel va2 = new JPanel();
        		va2.setOpaque(false);
        		
        		extra.add(va2);
        		
        
        
        
        
        //
        add(panelTitulo);
        add(inputs);
        add(extra);
        
   
        //PanelCamposIn panelIn = new PanelCamposIn();
        //add(panelIn, Border);

	setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource()==signin) {
	    boolean existenciaUsuario = authenticator.revisarExistencia(user.getText().strip());
	    if (existenciaUsuario) {
		
		boolean contrasenaCorrecta = authenticator.revisarPassword(user.getText().strip(), password.getText().strip());
		if (contrasenaCorrecta) {
		    frameHues.iniciarSesion();
		} else {
		    setEnabled(false);
		    setFocusable(false);
		    signin.setEnabled(false);
		    signin.setFocusable(false);
		   
		    CustomDialog dialog = new CustomDialog(this, "Contrasena incorrecta");
		    dialog.addWindowListener(new WindowAdapter() {
                	    @Override
                	    public void windowClosing(WindowEvent e) {
                		setEnabled(true);
                		setFocusable(true);
                		signin.setEnabled(true);
            		    	signin.setFocusable(true);
                	    }
		    });
		    dialog.setVisible(true);
		}
	    } else {
		setEnabled(false);
		setFocusable(false);
		signin.setEnabled(false);
		signin.setFocusable(false);
		CustomDialog dialog = new CustomDialog(this, "No existe el usuario");
        	dialog.addWindowListener(new WindowAdapter() {
        	    @Override
        	    public void windowClosing(WindowEvent e) {
        		setEnabled(true);
        		setFocusable(true);
        		signin.setEnabled(true);
    		    	signin.setFocusable(true);
        	    }
        	});
        	dialog.setVisible(true);
	    }
	    
	}
	
    }


}
