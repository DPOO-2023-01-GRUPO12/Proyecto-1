package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.Habitacion;
import model.PMS;

public class PanelConsulta extends JPanel implements ActionListener {
    private NormalButton botonConsultar;
    private JList<String> listaHabs;
    private DefaultListModel<String> lm;

    public PanelConsulta(PMS pms) {

        setLayout(new BorderLayout());
        setForeground(Color.WHITE);

        ///////////////////////////////////// Titulo frame
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Consultar Inventario", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);
        //////////////////////////////////////////
        JPanel panelCentral = new JPanel();
        //panelCentral.setPreferredSize(new Dimension(500, 500));
        lm = new DefaultListModel<>();
        listaHabs = new JList<>(lm);
        listaHabs.setVisible(false);
        for (Habitacion hab : pms.getInventarioHabitaciones().values()) {
            lm.addElement(hab.toString());
        }

        JScrollPane scroll = new JScrollPane(listaHabs);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelCentral.add(scroll, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        //////////////////////////////////////////
        botonConsultar = new NormalButton("CONSULTAR");
        botonConsultar.addActionListener(this);
        add(botonConsultar, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonConsultar) {
            listaHabs.setVisible(true);
        }
    }

}
