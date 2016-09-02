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
public class BasicLaser extends GameObject {
    Handler handler;
    public BasicLaser(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
         x += velX;
        y += velY;
        
        velY = 1;
        if(y <= 0 || y >= Game.HEIGHT) velY*= -1;
        if(x <= 0 || x >= Game.WIDTH) velX *= -1;
        
        collision();
    }

    @Override
    public void render(Graphics g) {
         g.setColor(Color.RED);
        g.fillRect(x,y,10,10);
        
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle(x,y,10,10);
        
        
    }

    @Override
    public void collision() {
        
        for(int i = 0; i < handler.object.size(); i++){
            
           
           GameObject tempPlayerObject;
           GameObject tempObject = handler.object.get(i);
           
           if(tempObject.getID() == ID.Player){
              tempPlayerObject = tempObject;
              
           
           
           if(tempObject.getID() == ID.Player){
               //collision code
               
              if(getBounds().intersects(tempObject.getBounds())){
                  
                  tempPlayerObject.collision();
                   handler.removeObject(this);
               }
                
               }
           }
           // FIX BUG, INDEX OUT OF BOUNDS AFTER REMOVING OBJECT
            if(handler.object.get(i).y >= HEIGHT-64){
                handler.removeObject(handler.object.get(i));
                i = 0; return;
            }
            if(handler.object.get(i).y <= 0){
                handler.removeObject(handler.object.get(i));
                i = 0; return;
            } 
            if(handler.object.get(i).x >= WIDTH-32){
                handler.removeObject(handler.object.get(i));
                i = 0; return;
            }
            if(handler.object.get(i).x <= 0)
                handler.removeObject(handler.object.get(i));
                i = 0; return;
        }
           
               
           
        }
       }
        
        
    
    
    
    

