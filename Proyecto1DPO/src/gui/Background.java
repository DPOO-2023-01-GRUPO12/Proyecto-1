package gui;

import javax.swing.*;
import java.io.File;
class Background extends JPanel {

    private ImageIcon myPicture;
    public Background(FrameLogIn frameLogIn) {

        // Imagen de fondo

        setSize(frameLogIn.getWidth(), frameLogIn.getHeight());
        String[] pathNames = {".","Icons", "fondo.jpg" };
        String pathUsers = String.join(File.separator, pathNames);
        
        System.out.println(pathUsers);
        File f = new File(pathUsers);
        System.out.println(f.getAbsolutePath());
        myPicture = new ImageIcon(pathUsers);
        add(new JLabel(myPicture));
        setVisible(true);
    }

}