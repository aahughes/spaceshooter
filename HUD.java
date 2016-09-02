/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ralpoh
 */
public class HUD {
    
    public static int HEALTH = 100;
    
    public void tick(){
      //  HEALTH--;
      
        HEALTH = Game.clamp(HEALTH, 0, 100);
        
    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(7,540,200,20);
        
        g.setColor(Color.green);
        g.fillRect(7, 540, HEALTH * 2, 20);
        
        g.setColor(Color.white);
        g.drawRect(7, 540, 200, 20);
        
        
        
    }
    
}
