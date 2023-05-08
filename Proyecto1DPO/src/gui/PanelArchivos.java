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
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.PMS;

public class PanelArchivos extends JPanel implements ActionListener {
    private FrameAdmin frameAdmin;
    private PMS sistema;
    private JFileChooser fc;

    public PanelArchivos(FrameAdmin frameAdmin, PMS pms) {
        this.sistema = pms;
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
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Seleccione los archivos a cargar");
        fc.setApproveButtonText("Cargar");
        fc.setApproveButtonToolTipText("Cargar los archivos seleccionados");
        fc.setFileHidingEnabled(true);

        fc.addActionListener(this);
        add(fc, BorderLayout.CENTER);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if ((fc.showOpenDialog(this)) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            try {
                sistema.getCargador().cargarInformacionHotel(selectedFile);
            } catch (FileNotFoundException e1) {

                e1.printStackTrace();
            } catch (IOException e1) {

                e1.printStackTrace();
            }

        } else if ((fc.showOpenDialog(this)) == JFileChooser.CANCEL_OPTION) {

        }

    }

}
