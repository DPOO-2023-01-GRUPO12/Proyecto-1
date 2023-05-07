package gui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CustomButton extends JRadioButton implements MouseListener

{
    ;

    private Color unselected = new Color(23, 35, 31);
    private Color selected = new Color(75, 0, 130);
    private BufferedImage img;
    private boolean pressed;
    private JLabel title;
    private String path;
    private GrupoBotones group;

    public CustomButton(String path, GrupoBotones group) {

        this.path = path;
        this.group = group;
        pressed = false;
        setBackground(unselected);
        setOpaque(true);
        addMouseListener(this);

        setPreferredSize(getSize());

        try {
            img = ImageIO.read(new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isSelected()) {
            g2d.setColor(selected);
        } else {
            g2d.setColor(getBackground());
        }
        g2d.fillRect(0, 0, getWidth(), getHeight());

        double scale = Math.min(1.0 * getWidth() / (2.0 * img.getWidth()), 1.0 * getHeight() / (2.0 * img.getHeight()));

        Image scaledImage = img.getScaledInstance((int) (img.getWidth() * scale), (int) (img.getHeight() * scale),
                Image.SCALE_SMOOTH);
        int x = (getWidth() - scaledImage.getWidth(null)) / 2;
        int y = (getHeight() - scaledImage.getHeight(null)) / 2;
        g2d.drawImage(scaledImage, x, y, null);

        g2d.dispose();

    }

    public boolean isSelected() {
        return getModel().isSelected();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!getModel().isSelected()) {
            group.setSelectedButton(this);
            getModel().setSelected(true);
            setBackground(selected);
            repaint();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void setSelected(boolean s) {
        getModel().setSelected(s);
        if (s) {
            setBackground(selected);
        } else {
            setBackground(unselected);
        }
        repaint();
    }

}
