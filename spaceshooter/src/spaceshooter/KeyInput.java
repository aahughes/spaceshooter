/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ralpoh
 */
public class KeyInput extends KeyAdapter{
    // the handler being used
    private Handler handler;
    private int release;
    // constructor
    public KeyInput(Handler handler){
        this.handler = handler;
        release = 0;
    }
    
    // key pressed event
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        // used for two players at a later date
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getID() == ID.Player){
                int x = tempObject.getX();
                int y = tempObject.getY();
                // key events for player 1
                // use velocity for smooth movement
                if(key == KeyEvent.VK_W) tempObject.setVelY(-3);
                if(key == KeyEvent.VK_S) tempObject.setVelY(3);
                if(key == KeyEvent.VK_A) tempObject.setVelX(-3);
                if(key == KeyEvent.VK_D) tempObject.setVelX(3);
                
                // player laster
                if(key == KeyEvent.VK_SPACE){
                    release++;
                    if(release == 1) handler.addObject(new PlayerLaser(x+14,y,ID.PlayerLaser,handler));                   
                }
                
                release = 0;
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
                
                if(key == KeyEvent.VK_W) tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) tempObject.setVelY(0);
                if(key == KeyEvent.VK_A) tempObject.setVelX(0);
                if(key == KeyEvent.VK_D) tempObject.setVelX(0);
            }
        }
        
    }
}
