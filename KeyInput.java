/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ralpoh
 */
public class KeyInput extends KeyAdapter{
    // the handler being used
    private Handler handler;
    private float release;
    private boolean keyDown [] = new boolean[5];
    private int weaponTime;
    private Clock c; 
    
    
    // constructor
    public KeyInput(Handler handler){
        this.handler = handler;
        release = 0;
        
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
        keyDown[4] = false;
        
        c = new Clock();
    }
    
    // key pressed event
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        // used for two players at a later date
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getID() == ID.Player){
                float x = tempObject.getX();
                float y = tempObject.getY();
                // key events for player 1
                // use velocity for smooth movement
                if(key == KeyEvent.VK_W) tempObject.setVelY(-3); keyDown[0] = true;
                if(key == KeyEvent.VK_S) tempObject.setVelY(3); keyDown[1] = true;
                if(key == KeyEvent.VK_A) tempObject.setVelX(-3); keyDown[2] = true;
                if(key == KeyEvent.VK_D) tempObject.setVelX(3); keyDown[3] = true;
                
                // player laster
                
                    
                if(key == KeyEvent.VK_SPACE)handler.addObject(new PlayerLaser(x+14,y,ID.PlayerLaser,handler));
                
                     
                    
                         
                     
                    
                
                
          
            }
        }
        
        
      //  System.out.println(key);
    }
    
    
    
    // key pressed event
    @Override
    public void keyReleased(KeyEvent e){
       
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player){
                // key events for player 1
                
                if(key == KeyEvent.VK_W)  keyDown[0] = false;
                if(key == KeyEvent.VK_S)  keyDown[1] = false;
                if(key == KeyEvent.VK_A)  keyDown[2] = false;
                if(key == KeyEvent.VK_D)  keyDown[3] = false;
            
                if(key == KeyEvent.VK_W) tempObject.setVelY(0); 
                if(key == KeyEvent.VK_S) tempObject.setVelY(0); 
                if(key == KeyEvent.VK_A) tempObject.setVelX(0); 
                if(key == KeyEvent.VK_D) tempObject.setVelX(0); 
//            if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
//            
//            if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
//                if(key == KeyEvent.VK_SPACE) keyDown[4] = false;
            }
        }
        
    }
}
