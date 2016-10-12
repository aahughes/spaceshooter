/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.PopupMenu;
import javax.swing.JFrame;

/**
 *
 * @author ralph
 */

// Main Window for game, implements JFrame, Takes Game as constructor
public class Window extends Canvas{
    
    private static final double serialVersionID =  1.00;
    
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
