/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author ralpoh
 */

public class Player extends GameObject{
    Handler handler;
    
    public Player(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        
        x += velX;
        y += velY;
        // limit of frame
        x = Game.clamp(x, 0, Game.WIDTH - 34);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        
        collision();
    }

    @Override
   public void collision(){
       
       for(int i = 0; i < handler.object.size(); i++){
           GameObject tempObject = handler.object.get(i);
           
           if(tempObject.getID() == ID.BasicFighter){
               //collision code
     
               if(getBounds().intersects(tempObject.getBounds())){
               HUD.HEALTH -= 5;    
               } 
           }
           if(tempObject.getID() == ID.BasicLaser){
               //collision code
               
                if(getBounds().intersects(tempObject.getBounds())){
               HUD.HEALTH -= 5;    
               }
               
           }
       }
   }
    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
      
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
