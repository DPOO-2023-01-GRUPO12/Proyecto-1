/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.PMS;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Juanca
 */
class PanelUsuario extends JPanel {

    public PanelUsuario(FrameLogIn ventanaLogin, PMS pms) {

        setOpaque(true);
        setBackground(new Color(0, 0, 0, 100));

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(layout);
        gbc.gridx = 2;
        gbc.gridy = 2;

        JPanel panelI = new PanelInput(ventanaLogin, this, pms);

        add(panelI, gbc);

        setVisible(true);

    }

}