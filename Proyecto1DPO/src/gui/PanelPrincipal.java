package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPrincipal extends JPanel implements ActionListener
{
    public PanelPrincipal() {
	setLayout(new GridLayout(5,1,0,15));
	setOpaque(false);
	JTextField textoBienvenida = new JTextField("Bienvenido al sistema del hotel");
	Font f = textoBienvenida.getFont();
	textoBienvenida.setBorder(null);
	textoBienvenida.setFont(f.deriveFont(f.getStyle(),20));
	textoBienvenida.setEditable(false);
	textoBienvenida.setOpaque(false);

	add(textoBienvenida);
	
	
	JButton iniciarSesion = new JButton("Iniciar Sesion");
	f = iniciarSesion.getFont();
	iniciarSesion.setFont(f.deriveFont(f.getStyle(),20));
	iniciarSesion.setBackground(Color.white);

	add(iniciarSesion);
	
	
	JButton salir = new JButton("Salir");
	salir.setBackground(Color.white);
	salir.setFont(f.deriveFont(f.getStyle(),20));
	add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	// TODO Auto-generated method stub
	
    }

}
