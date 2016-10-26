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
public class EnemyStriker extends GameObject {
    Handler handler;
    float initialX;
    Clock c;
    Random r;
    int health;
    Graphics g;
    public EnemyStriker(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.initialX = x;
        this.handler = handler;
        health = 5;
       // velX = 1;
       // velY = 1;
        c = new Clock();
        r = new Random();
        
        if(r.nextInt(11) >= 5){
            velX = 1;
        }
         if(r.nextInt(11) < 5){
            velX = -1;
        }
         if(r.nextInt(11) > 5){
            velY = 1;
        }
         if(r.nextInt(11) <= 5){
            velY = -1;
        }
         else{
             velX = 1;
             velY = 1;
         }
    }

    @Override
    public void tick() {
        c.tick();
        x += velX;
        y += velY;
        
        // laser shooting
        if(c.deltaSeconds >= 1){
            handler.addObject(new StrikerLaser(x,y,ID.StrikerLaser,handler));   
            c.deltaSeconds = 0;
        } 
        
      //  if(x <= initialX - 50 || x >= initialX + 50) velX*= -1;  
        if(y >= Game.HEIGHT) y = 10;
        if(x >= Game.WIDTH)  x = 10;
        if(y <= 0) y = Game.HEIGHT - 10;
        if(x <= 0) x = Game.WIDTH - 10;
    }

    @Override
    public void render(Graphics g) {
        this.g = g;
        if(health >= 4){
            g.setColor(Color.YELLOW);
            g.fillRect((int)x,(int)y,32,32);
        }
        
        if(health <= 3){
            g.setColor(Color.RED);
            g.fillRect((int)x,(int)y,32,32);
        }
      
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
                  
                  health--;
                   
              
               }
              if(health <=3){
                  render(g);
              }
                if(health <= 0){
                handler.removeObject(this);
                    }
                
            }
           }
           
        }
        
        
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
