/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author asksoft
 */
	
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
 
public class TestTextField {
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JLabel label = new JLabel("Email:");
 
                CustomTextField customTextField = new CustomTextField(20);
                customTextField.setPlaceholder("example@address.com");
                customTextField.setFont(new Font("Arial", Font.PLAIN, 24));
                customTextField.setForeground(Color.RED);
                customTextField.setPlaceholderForeground(Color.RED);
 
                JButton button = new JButton("Test focus");
 
                JPanel panel = new JPanel();
                panel.add(label);
                panel.add(customTextField);
                panel.add(button);
 
                JFrame frame = new JFrame("CustomTextField test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
 
    }
}