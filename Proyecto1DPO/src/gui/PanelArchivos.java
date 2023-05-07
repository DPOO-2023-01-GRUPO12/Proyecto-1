package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelArchivos extends JPanel implements ActionListener {
    private FrameAdmin frameAdmin;
    private JFileChooser fc;

    public PanelArchivos(FrameAdmin frameAdmin) {
        this.frameAdmin = frameAdmin;

        setLayout(new BorderLayout());
        setForeground(Color.WHITE);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Cargar Archivos", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);

        String[] pathNames = { "Proyecto1DPO", "data" };
        String path = String.join(File.separator, pathNames);
        fc = new JFileChooser(path);
        fc.addActionListener(this);
        add(fc, BorderLayout.CENTER);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fc) {
            // TODO MANDAR FILE A frame Admin
            // frameAdmin.cargarArchivos();
        }

    }

}
