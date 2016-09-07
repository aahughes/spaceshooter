/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ralpoh
 */
public class PlayerLaser extends GameObject{

    Handler handler;
    Clock c;
    public PlayerLaser(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        c = new Clock();
    }

    @Override
    public void tick() {
         x += velX;
        y += velY;
        
        velY = -1;
        if(y <= 0 || y >= Game.HEIGHT-64) velY*= -1;
        if(x <= 0 || x >= Game.WIDTH) velX *= -1;
        
        collision();
    }

    @Override
    public void render(Graphics g) {
         g.setColor(Color.GREEN);
        g.fillRect(x,y,10,10);
        
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle(x,y,10,10);
        
        
    }

    @Override
    public void collision() {
        
        for(int i = 0; i < handler.object.size(); i++){

           GameObject tempEnemyObject;
           GameObject tempObject = handler.object.get(i);
           if(tempObject.getID() == ID.BasicFighter){
                     //collision code
                     tempEnemyObject = tempObject;
              if(getBounds().intersects(tempObject.getBounds())){
                  
                  tempEnemyObject.collision();
                   handler.removeObject(this);
               }  
           }
           
           // FIX BUG, INDEX OUT OF BOUNDS AFTER REMOVING OBJECT
           
           outOfBounds();
                 
        }
    }
    
    private void outOfBounds(){
           if(x <= 0) handler.removeObject(this);
           if (x >= WIDTH-34) handler.removeObject(this);
           if(y <= 0) handler.removeObject(this);
           if (y >= HEIGHT-64) handler.removeObject(this);

    } 
        
}