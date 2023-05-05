package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.foreign.GroupLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputHabitacion extends JDialog {
    private JTextField inputIdentificador;
    private JTextField inputUbicacion;
    private JTextField inputDescripcion;

    private JRadioButton radioCocina1;
    private JRadioButton radioCocina2;
    private JRadioButton radioBalcon1;
    private JRadioButton radioBalcon2;
    private JRadioButton radioVista1;
    private JRadioButton radioVista1;

    public InputHabitacion() {
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        layout.setVgap(10);

        JPanel panelCentral = new JPanel();
        GroupLayout gl = new GroupLayout(inputUsuario);
        panelCentral.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel usuario = new JLabel("Usuario: ");
        inputUsuario = new JTextField();
        JLabel ubicacion = new JLabel("Ubicacion: ");
        inputUbicacion = new JTextField();
        JLabel descripcion = new JLabel("Descripcion: ");
        inputDescripcion = new JTextField();


        JLabel cocina = new JLabel
        JButtonGroup bgCocina = new JButtonGroup();
        radioCocina1 = new JRadioButton("Si");
        radioCocina2 = new JRadioButton("No");
        bgCocina.add(radioCocina1);
        bgCocina.add(radioCocina2);

        JButtonGroup bgBalcon = new JButtonGroup();
        radioBalcon1 = new JRadioButton("Si");
        radioBalcon2 = new JRadioButton("No");
        bgBalcon.add(radioBalcon1);
        bgBalcon.add(radioBalcon2);
        JButtonGroup bgVista = new JButtonGroup();
        radioVista1 = new JRadioButton("Si");
        radioVista2 = new JRadioButton("No");
        bgVista.add(radioVista1)
        bgVista.add(radioVista2);

        // agregar componente
        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        h.addGroup(layout.createParallelGroup().addComponent(usuario).addComponent(inputUsuario));
        h.addGroup(layout.createParallelGroup().addComponent(ubicacion).addComponent(inputUbicacion));
        h.addGroup(layout.createParallelGroup().addComponent(descripcion).addComponent(inputDescripcion));
        h.addGroup(layout.createParallelGroup().addComponent(descripcion).addComponent(inputDescripcion));
        h.addGroup(layout.createParallelGroup().addComponent(descripcion).addComponent(inputDescripcion));
        h.addGroup(layout.createParallelGroup().addComponent(descripcion).addComponent(inputDescripcion));


    }

}
