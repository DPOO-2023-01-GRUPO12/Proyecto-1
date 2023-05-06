package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.filechooser.FileFilter;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import console.MenuAdministrador;
import model.PMS;
import persistencia.Cargador;

public class InterfazAdmin extends JFrame implements ActionListener {

    private JRadioButton radio1;
    private PMS pms;
    private Cargador cargador;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JButton botonOk;
    private JButton botonCancelar;
    private MenuAdministrador menuAdmin;

    public InterfazAdmin(PMS sistema) {
        pms = sistema;
        cargador = sistema.getCargador();
        menuAdmin = new MenuAdministrador(cargador, sistema);
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        layout.setVgap(10);

        // Norte
        JLabel titulo = new JLabel("¿Qué desea hacer?", SwingConstants.CENTER);

        Font f = titulo.getFont();
        titulo.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
        titulo.setBorder(null);
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(false);

        add(titulo, BorderLayout.NORTH);

        // Central
        JPanel panelCentral = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        panelCentral.setLayout(new GridLayout(4, 1));
        // gbc.fill = GridBagConstraints.HORIZONTAL;

        // Central - BOTONES opciones
        ButtonGroup bg = new ButtonGroup();
        radio1 = new JRadioButton("Cargar Archivos");
        radio2 = new JRadioButton("Crear Habitacion");
        radio3 = new JRadioButton("Crear Tipo Habitacion");
        radio4 = new JRadioButton("Configurar tarifa producto menu ");

        radio1.setBounds(radio1.getX(), radio1.getY(), 150, 70);
        radio2.setBounds(radio2.getX(), radio2.getY(), 150, 70);
        radio3.setBounds(radio3.getX(), radio3.getY(), 150, 70);
        radio4.setBounds(radio4.getX(), radio4.getY(), 150, 70);

        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);

        panelCentral.add(radio1);

        panelCentral.add(radio2);

        panelCentral.add(radio3);

        panelCentral.add(radio4);
        add(panelCentral, BorderLayout.CENTER);

        // Botones OK-Cancelar
        JPanel panelBotonesInferior = new JPanel();
        panelBotonesInferior.setLayout(new FlowLayout());

        botonOk = new JButton("OK");
        botonOk.setBorderPainted(true);
        botonOk.addActionListener(this);
        botonCancelar = new JButton("CANCELAR");
        botonCancelar.setBorderPainted(true);
        botonCancelar.addActionListener(this);

        panelBotonesInferior.add(botonOk);
        panelBotonesInferior.add(botonCancelar);

        add(panelBotonesInferior, BorderLayout.SOUTH);

        setSize(300, 300);
        // pack();
        setResizable(false);
        setVisible(true);

    }

    public void cargarArchivos() throws FileNotFoundException, IOException {
        JFileChooser fc = new JFileChooser();

        FileFilter filtroTXT = new FileFilter() {

            public boolean accept(File file) {

                if (file.getName().endsWith(".txt")) {
                    return true;
                }

                return false;
            }

            public String getDescription() {
                return "Archivos de texto TXT (*.txt)";
            }
        };

        fc.setFileFilter(filtroTXT);

        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Seleccione los archivos a cargar");
        fc.setApproveButtonText("Cargar");
        fc.setApproveButtonToolTipText("Cargar los archivos seleccionados");
        fc.setFileHidingEnabled(true);
        /// fc.setFileFilter(new FiltroArchivos());
        /// fc.setAcceptAllFileFilterUsed(false);
        /// fc.setAccessory(new PanelVistaPrevia(fc));
        int resultado = fc.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoHotel = fc.getSelectedFile();
            cargador.cargarInformacionHotel(archivoHotel);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonOk) {
            this.setVisible(false);
            this.dispose();
            this.pack();
            if (radio1.isSelected()) { // Cargar archivos
                try {
                    cargarArchivos();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (radio2.isSelected()) { // Crear Habitacion
                InputHabitacion inputHab = new InputHabitacion(menuAdmin);
                inputHab.setLocationRelativeTo(this);
            }
            if (radio3.isSelected()) { // Crear Tipo habitacion
                JDialog inputTipoHab = new JDialog(this);
                inputTipoHab.setLocationRelativeTo(this);
                inputTipoHab.setLayout(new BorderLayout());

                JPanel panelTipoH = new JPanel();
                panelTipoH.setLayout(new FlowLayout());

                JLabel tipoHLabel = new JLabel("Tipo de Habitacion", SwingConstants.LEFT);
                JTextField tipoH = new JTextField(10);
                panelTipoH.add(tipoHLabel);
                panelTipoH.add(tipoH);
                inputTipoHab.add(panelTipoH, BorderLayout.CENTER);

                // Botones

                JPanel panelSouth = new JPanel();
                panelSouth.setLayout(new FlowLayout());
                JButton botonOkTh = new JButton("OK");
                botonOkTh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuAdmin.crearTipoHabitacion(tipoH.getText());
                    }
                });
                panelSouth.add(botonOkTh);

                JButton botonCancelarTh = new JButton("CANCELAR");
                botonCancelarTh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inputTipoHab.setVisible(false);
                        inputTipoHab.dispose();
                        inputTipoHab.pack();
                    }
                });
                panelSouth.add(botonCancelarTh);

                inputTipoHab.add(panelSouth, BorderLayout.SOUTH);

                inputTipoHab.pack();
                inputTipoHab.setVisible(true);

            }
            if (radio4.isSelected()) { // configurar

                ConfigurarAdmin configurarAdmin = new ConfigurarAdmin();

                
            }
        } else if (e.getSource() == botonCancelar) {
            this.setVisible(false);
            this.dispose();
            this.pack();
        }

    }
}
