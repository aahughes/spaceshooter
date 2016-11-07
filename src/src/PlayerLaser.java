/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 *
 * @author ralpoh
 */
public class PlayerLaser extends GameObject{

    Handler handler;
    Clock c;
    Image img;
    public PlayerLaser(float x, float y, ID id,Handler handler,float velX, float velY) {
        super(x, y, id);
        this.handler = handler;
        c = new Clock();
        this.velX = velX;
        this.velY = velY;
        img = new JFrame().getToolkit().getImage("1.jpg");
    }

    @Override
    public void tick() {
         x += velX;
        y += velY; 
        collision();
      
    }

    @Override
    public void render(Graphics g) {
//         g.setColor(Color.GREEN);
//        g.fillRect((int) x,(int) y,5,12);
    	
   	 	g.drawImage(img, (int)x, (int)y, (int)5, (int)12, null);
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle((int)x,(int) y,5,15);
        
        
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
           if(tempObject.getID() == ID.EnemyDestroyer){
                     //collision code
                     tempEnemyObject = tempObject;
              if(getBounds().intersects(tempObject.getBounds())){
                  
                  tempEnemyObject.collision();
                   handler.removeObject(this);
               }
                
           
           }
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
              if (x >= WIDTH-34) handler.removeObject(this);
              if(y <= 0) handler.removeObject(this);
              if (y >= HEIGHT-64) handler.removeObject(this);
           
           
       } 

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }