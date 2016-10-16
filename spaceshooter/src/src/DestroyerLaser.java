/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ralpoh
 */
public class DestroyerLaser extends GameObject {
    Handler handler;
    Clock c;
    Random r;
    int direction;
    public DestroyerLaser(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        c = new Clock();
        r = new Random();
        direction = r.nextInt(11);
        
        if(direction >= 5){
            velX = 1;
        }
        if(direction < 5){
            velX = -1;
        }
        velY = 1;
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
         g.setColor(Color.WHITE);
        g.fillRect((int)x,(int)y,5,15);
        
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle((int)x,(int)y,5,15);  
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
                   HUD.score += 50;
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
