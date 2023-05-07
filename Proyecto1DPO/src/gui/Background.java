package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Juanca
 */
class Background extends JPanel {

    private ImageIcon myPicture;
    private BufferedImage image;
    private BufferedImage imgOut;

    public Background(FrameLogIn frameLogIn) {

        // Imagen de fondo

        setSize(frameLogIn.getWidth(), frameLogIn.getHeight());
        String[] pathNames = { "Proyecto1DPO", "Icons", "fondo.jpg" };
        String pathUsers = String.join(File.separator, pathNames);

        myPicture = new ImageIcon(pathUsers);
        add(new JLabel(myPicture));
        setVisible(true);
    }

}