package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import console.MenuAdministrador;
import model.Habitacion;
import model.PMS;
import model.TipoHabitacion;

public class SeleccionTipoHab extends JDialog {
    private PMS sistema;
    private MenuAdministrador menuAdmin;

    public SeleccionTipoHab(PMS pms, MenuAdministrador menu, Habitacion hab) {
        sistema = pms;
        menuAdmin = menu;
        setLayout(new BorderLayout());
        JLabel tituloTipoHab = new JLabel("Seleccione el tipo de habitacion", SwingConstants.CENTER);
        tituloTipoHab.setFont(new Font("macOS SF Pro", Font.BOLD, 15));
        tituloTipoHab.setBorder(null);
        tituloTipoHab.setForeground(Color.BLACK);
        tituloTipoHab.setOpaque(false);
        add(tituloTipoHab, BorderLayout.NORTH);

        // JPanel panelLista = new JPanel();
        DefaultListModel<String> lm = new DefaultListModel<>();
        JList<String> listaTipoHabs = new JList<>(lm);
        for (TipoHabitacion tipo : sistema.getTipoHabitaciones().values()) {
            lm.addElement(tipo.getNombreTipo());
        }

        JScrollPane scroll = new JScrollPane(listaTipoHabs);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        JButton botonOkTh = new JButton("OK");
        botonOkTh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                pack();
                String tipoSeleccionado = listaTipoHabs.getSelectedValue();
                menuAdmin.asignarHabitacionTipo(hab, sistema.getTipoHabitaciones().get(tipoSeleccionado));
                // TipoHabitacion tipoHabitacion =
                // sistema.getTipoHabitaciones().get(tipoSeleccionado);
            }
        });
        panelSouth.add(botonOkTh);

        JButton botonCancelarTh = new JButton("CANCELAR");
        botonCancelarTh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarTipoHabitacion.setVisible(false);
                seleccionarTipoHabitacion.dispose();
                seleccionarTipoHabitacion.pack();
            }
        });
        panelSouth.add(botonCancelarTh);

        seleccionarTipoHabitacion.add(panelSouth, BorderLayout.SOUTH);
        seleccionarTipoHabitacion.setSize(300, 400);
        seleccionarTipoHabitacion.setVisible(true);
    }

}
