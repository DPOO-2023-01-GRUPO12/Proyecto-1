package gui;

import javax.swing.*;
import java.io.File;
class Background extends JPanel {

    private ImageIcon myPicture;
    public Background(FrameLogIn frameLogIn) {

        // Imagen de fondo

        setSize(frameLogIn.getWidth(), frameLogIn.getHeight());
        String[] pathNames = {"Proyecto1DPO","Icons", "fondo.jpg" };
        String pathUsers = String.join(File.separator, pathNames);
        myPicture = new ImageIcon(pathUsers);
        add(new JLabel(myPicture));
        setVisible(true);
    }

}