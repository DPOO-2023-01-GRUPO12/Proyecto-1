package gui;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import javax.swing.*;

public class NormalButton extends JButton implements MouseListener

{
    ;

    private Color unselected = new Color(200, 71, 0);
    private Color selected = new Color(75, 0, 130);


    public NormalButton(String name) {

        super(name);
        setBackground(unselected);
        setOpaque(true);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        addMouseListener(this);

        setPreferredSize(new Dimension(100, 100));

        setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());

        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(Color.white);
        FontMetrics fm = g2d.getFontMetrics();
        int stringWidth = fm.stringWidth(getText());
        int stringHeight = fm.getAscent() + fm.getDescent();
        int x = (getWidth() - stringWidth) / 2;
        int y = (getHeight() - stringHeight) / 2 + fm.getAscent();
        g2d.drawString(getText(), x, y);
        g2d.dispose();

    }

    

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isEnabled()) {
            setBackground(selected);
            repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isEnabled()) {
            setBackground(unselected);
            repaint();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
