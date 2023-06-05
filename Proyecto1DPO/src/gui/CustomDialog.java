package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    
    private JLabel messageLabel;

    public CustomDialog(JPanel parent, String message) {
        //super(parent, true);
        
        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(Color.WHITE);
        contentPane.setPreferredSize(new Dimension(300, 100));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setForeground(Color.BLACK);
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(messageLabel, c);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(parent);
    }
    

    public CustomDialog(VentanaHuesped ventanaHuesped, String message)
    {
	JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(Color.WHITE);
        contentPane.setPreferredSize(new Dimension(300, 100));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setForeground(Color.BLACK);
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(messageLabel, c);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(ventanaHuesped);
    }


    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
