package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel implements ActionListener {
	private JButton iniciarSesion;
	private JButton salir;
	private VentanaInicio ventanaInicio;

	public PanelPrincipal(VentanaInicio inicio) {
		ventanaInicio = inicio;
		setLayout(new GridLayout(5, 1, 0, 15));
		setOpaque(false);
		JTextField textoBienvenida = new JTextField("Bienvenido al sistema del hotel");
		Font f = textoBienvenida.getFont();
		textoBienvenida.setFont(new Font("macOS SF Pro", Font.BOLD, 20));
		textoBienvenida.setBorder(null);
		textoBienvenida.setEditable(false);
		textoBienvenida.setOpaque(false);

		add(textoBienvenida);

		iniciarSesion = new JButton("Iniciar Sesion");
		f = iniciarSesion.getFont();
		iniciarSesion.setBounds(iniciarSesion.getX(), iniciarSesion.getY(), iniciarSesion.getWidth() / 2,
				iniciarSesion.getHeight());
		iniciarSesion.setFont(f.deriveFont(f.getStyle(), 20));
		iniciarSesion.setBackground(new Color(245, 245, 245));
		iniciarSesion.addActionListener(this);

		add(iniciarSesion);

		salir = new JButton("Salir");
		salir.setBackground(new Color(245, 245, 245));
		salir.setBounds(salir.getX(), salir.getY(), salir.getWidth() / 2, salir.getHeight());
		salir.setFont(f.deriveFont(f.getStyle(), 20));
		salir.addActionListener(this);
		add(salir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == iniciarSesion) {
			ventanaInicio.iniciarSesion();
		} else if (e.getSource() == salir) {
			ventanaInicio.salir();

		}

	}

}
