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

// Main GameWindow for game, implements JFrame, Takes Game as constructor
public class GameWindow extends JFrame{
    
    private static final double serialVersionID =  1.00;
    
    Game game;
    
    public GameWindow(int width, int height, String title, Game game){
        
        this.setPreferredSize(new Dimension(width,height));
        this.setMaximumSize(new Dimension(width,height));
        this.setMinimumSize(new Dimension(width,height));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.game = game;
        this.add(game);
        this.setVisible(true);
        
        StartMenu menu = new StartMenu();
        this.add(menu);
        menu.setVisible(true);
        
    }
    
    public void startGame(){
        game.start();
    }
}
