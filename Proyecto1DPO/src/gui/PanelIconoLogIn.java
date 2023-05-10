/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Juanca
 */
class PanelIconoLogIn extends JPanel {

    private ImageIcon myPicture;

    public PanelIconoLogIn(FrameLogIn ventanaLogin) {

        setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        BufferedImage img;
        try {
            String[] pathNames = { ".", "Icons", "loginIcon.jpg" };
            String pathImg = String.join(File.separator, pathNames);
            img = ImageIO.read(new File(pathImg));

            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO Auto-generated method stub

    }

}