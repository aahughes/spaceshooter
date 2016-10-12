/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ralpoh
 */
public class EnemyDestroyer extends GameObject {
    Handler handler;
    float initialX;
    Clock c;
    
    
    public EnemyDestroyer(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.initialX = x;
        this.handler = handler;
        velX = 1;
        c = new Clock();
        
        
    }

    @Override
    public void tick() {
        c.tick();
        x += velX;
        y += velY;
        
        // laser shooting
        if(c.deltaSeconds >= 1){
            handler.addObject(new DestroyerLaser(x,y,ID.DestroyerLaser,handler));   
            c.deltaSeconds = 0;
        } 
        
        if(x <= initialX - 50 || x >= initialX + 50) velX*= -1;  
        if(y <= 0 || y >= Game.HEIGHT - 64) velY*= -1;
        if(x <= 0 || x >= Game.WIDTH - 34) velX *= -1;
       
    }

    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillRect((int)x,(int)y,32,32);
        
      
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }

    @Override
    public void collision() {
        
        for(int i = 0; i < handler.object.size(); i++){
           GameObject tempPlayerObject;
           GameObject tempObject = handler.object.get(i);
           if(tempObject.getID() == ID.PlayerLaser){
              tempPlayerObject = tempObject;
              
           
           
           if(tempObject.getID() == ID.PlayerLaser){
               //collision code
               
              if(getBounds().intersects(tempObject.getBounds())){
                  
                   handler.removeObject(this);
                   hud.scoreAdd(10);
               }
                
               }
           }
           
        }
        
        
    }
    
    
    
}