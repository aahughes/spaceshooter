/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class test {
boolean action = false;
JFrame parent;
JButton button;
    public test(){
        
        
        button = new JButton();
        parent = new JFrame();
        button.setText("Go to the next Level!");
        parent.add(button);
        parent.pack();
        parent.setSize(new Dimension(200,200));

        
    }
    public boolean run(){
        parent.setVisible(true);
        parent.setLocationRelativeTo(null);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action = true;
                parent.setVisible(false);
            }
            
        });
       return action;
    }
}
