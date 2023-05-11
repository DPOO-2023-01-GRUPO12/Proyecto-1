package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Campo extends JTextField {
    private Color background = Color.WHITE;
    private Color foreground = Color.BLACK;
    private Color placeholderForeground = Color.GRAY;
    private boolean placeholderVisible;


    private Shape shape;
    private String placeholderText;
    private String title;
    

    public Campo(int size, String text) {
        super(text, size);
        title = text;
        setOpaque(false);
        setPreferredSize(new Dimension(200, 30));
        
        
        getDocument().addDocumentListener(new DocumentListener()
	{
	    
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateText();
            }
	});

    }
    
    private void updateText() {
	    String text = getText();
	    if (text.isEmpty()) {
	        placeholderVisible = true;
	        setForeground(placeholderForeground);
	        setText(placeholderText);
	    } else {
	        placeholderVisible = false;
	        setForeground(foreground);
	    }
	}

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        g2.dispose();
    }

}
