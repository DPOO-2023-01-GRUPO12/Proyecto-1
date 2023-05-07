package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.Border;

import console.MenuAdministrador;

public class PanelTipoHabitacion extends JPanel implements ActionListener {
    private NormalButton botonCrear;
    private Campo campo;
    private MenuAdministrador menuAdmin;

    public PanelTipoHabitacion(MenuAdministrador menuAdministrador) {
        menuAdmin = menuAdministrador;
        setLayout(new BorderLayout());
        setForeground(Color.WHITE);

        ///////////////////////////////////// Titulo frame
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Crear Tipo de Habitacion", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);
        //////////////////////////////////////////
        JPanel panelCentral = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panelCentral.setLayout(layout);
        gbc.gridx = 2;
        gbc.gridy = 2;

        JPanel back = new JPanel(new BorderLayout());

        JPanel inputTipo = new JPanel();

        GroupLayout l = new GroupLayout(inputTipo);
        l.setAutoCreateGaps(true);
        l.setAutoCreateContainerGaps(true);
        inputTipo.setLayout(layout);

        inputTipo.setBackground(new Color(6, 57, 112));
        inputTipo.setPreferredSize(new Dimension(500, 600));
        inputTipo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputTipo.setBackground(new Color(6, 57, 112));

        JLabel tituloTipo = new JLabel("Ingrese el tipo de habitacion");
        tituloTipo.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 3;
        tituloTipo.setFont(new Font("Roboto", Font.BOLD, 15));
        inputTipo.add(tituloTipo);

        campo = new Campo(15, "Tipo de habitacion");
        campo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campo.getText().equals("Tipo de habitacion")) {
                    campo.setText("");
                }
            };
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputTipo.add(campo);

        GroupLayout.SequentialGroup h = l.createSequentialGroup();

        h.addGroup(l.createParallelGroup().addComponent(tituloTipo).addComponent(campo));
        l.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = l.createSequentialGroup();

        v.addGroup(l.createParallelGroup(Alignment.BASELINE).addComponent(tituloTipo));
        v.addGroup(l.createParallelGroup(Alignment.BASELINE).addComponent(campo));
        l.setVerticalGroup(v);

        back.add(inputTipo, BorderLayout.CENTER);

        panelCentral.add(back, gbc);

        add(panelCentral, BorderLayout.CENTER);

        botonCrear = new NormalButton("CREAR");
        botonCrear.setEnabled(true);
        botonCrear.addActionListener(this);
        add(botonCrear, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCrear) {
            menuAdmin.crearTipoHabitacion(campo.getText());
        }

    }

}
