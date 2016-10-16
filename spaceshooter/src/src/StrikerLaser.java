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
public class StrikerLaser extends GameObject {
    Handler handler;
    Clock c;
    GameObject playerLocation;
    public StrikerLaser(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        c = new Clock();
        
        
        
        for(int i = 0; i < handler.object.size(); i ++){
           if(handler.object.get(i).id == ID.Player){
               playerLocation = handler.object.get(i);
               break;
           }
        }
        if(x + 25 < playerLocation.x){
            velX = 2;
        }
         if(x - 50>= playerLocation.x){
            velX = -2;
        }
          if(y - 50 >= playerLocation.y){
            velY = -2;
        }
           if(y + 25< playerLocation.y){
            velY = 2;
        }
    }
    @Override
    public void tick() {
         x += velX;
        y += velY;
        
        
        if(y <= 0 || y >= Game.HEIGHT) velY*= -1;
        if(x <= 0 || x >= Game.WIDTH) velX *= -1;
        
        collision();
    }

    @Override
    public void render(Graphics g) {
         g.setColor(Color.YELLOW);
        g.fillRect((int)x,(int)y,5,5);
        
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle((int)x,(int)y,5,5);  
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
          outOfBounds();
        }
        
    }
    private void outOfBounds(){
              if(x <= 0) handler.removeObject(this);
              if (x >= WIDTH-34) handler.removeObject(this);
              if(y <= 0) handler.removeObject(this);
              if (y >= HEIGHT-54) handler.removeObject(this);
           
           
       }
}