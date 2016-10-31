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
public class ShotGun extends GameObject {
    Handler handler;
    Clock c;
    public ShotGun(float x, float y, ID id,Handler handler,float velX, float velY) {
        super(x, y, id);
        this.handler = handler;
        c = new Clock();
        this.velX = velX;
        this.velY = velY;
    }

    @Override
    public void tick() {
         x += velX;
        y += velY;
        collision();
      
    }

    @Override
    public void render(Graphics g) {
         g.setColor(Color.WHITE);
        g.fillRect((int) x,(int) y,5,5);
        
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle((int)x,(int) y,5,5);
        
        
    }

    @Override
    public void collision() {
        
        for(int i = 0; i < handler.object.size(); i++){
           GameObject tempEnemyObject;
           GameObject tempObject = handler.object.get(i);
           /////////////////////////////////////////////////////////////////////
           if(tempObject.getID() == ID.BasicFighter){
                     tempEnemyObject = tempObject;
              if(getBounds().intersects(tempObject.getBounds())){    
                  tempEnemyObject.collision();
                   handler.removeObject(this);
               }
           }
           //////////////////////////////////////////////////////////////////////
           if(tempObject.getID() == ID.EnemyDestroyer){
                     tempEnemyObject = tempObject;
              if(getBounds().intersects(tempObject.getBounds())){      
                  tempEnemyObject.collision();
                   handler.removeObject(this);
               }
           }
           /////////////////////////////////////////////////////////////////////
            if(tempObject.getID() == ID.EnemyStriker){
                     //collision code
                     tempEnemyObject = tempObject;
              if(getBounds().intersects(tempObject.getBounds())){                  
                  tempEnemyObject.collision();
                   handler.removeObject(this);
               }
           }
           outOfBounds();    
        }
       }
       private void outOfBounds(){
              if(x <= 0) handler.removeObject(this);
              if (x >= WIDTH) handler.removeObject(this);
              if(y <= 0) handler.removeObject(this);
              if (y >= HEIGHT) handler.removeObject(this);
           
           
       } 

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }

