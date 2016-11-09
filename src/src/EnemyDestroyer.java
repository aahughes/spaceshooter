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
import java.util.Random;

import javax.swing.JFrame;

/**
 *
 * @author ralpoh
 */
public class EnemyDestroyer extends GameObject {
    Handler handler;
    float initialX;
    Clock c;
    int health;
    Image img;
   Graphics g;
    public EnemyDestroyer(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.initialX = x;
        this.handler = handler;
        velX = 1;
        c = new Clock();
        health = 5;
        img = new JFrame().getToolkit().getImage("12.png");
    }

    @Override
    public void tick() {
        c.tick();
        x += velX;
        y += velY;
        
        // laser shooting
        if(c.deltaSeconds >= 1){
            
            handler.addObject(new DestroyerLaser(x+20,y+64,ID.DestroyerLaser,handler));   
            c.deltaSeconds = 0;
        } 
        
        if(x <= initialX - 50 || x >= initialX + 50) velX*= -1;  
        if(y <= 0 || y >= Game.HEIGHT - 64) velY*= -1;
        if(x <= 0 || x >= Game.WIDTH - 34) velX *= -1;
       collision();
    }

    @Override
    public void render(Graphics g) {
        this.g = g;
        if(health >= 4){
//            g.setColor(Color.WHITE);
//            g.fillRect((int)x,(int)y,40,64); 
        	
       	 	g.drawImage(img, (int)x, (int)y, (int)40, (int)64, null);
        }
        if(health <= 3){
//            g.setColor(Color.RED);
//            g.fillRect((int)x,(int)y,40,64);
        	img = new JFrame().getToolkit().getImage("13.png");
       	 	g.drawImage(img, (int)x, (int)y, (int)40, (int)64, null);
        }
        
      
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,40,64);
    }

    @Override
    public void collision() {
        
        for(int i = 0; i < handler.object.size(); i++){
           GameObject tempPlayerObject;
           GameObject tempObject = handler.object.get(i);
           
           if(tempObject.getID() == ID.PlayerLaser){
              tempPlayerObject = tempObject;
           if(tempObject.getID() == ID.PlayerLaser){
              if(getBounds().intersects(tempObject.getBounds())){
                  health--;
               }               
            }
        }
           ////////////////////////////////////////////////////////////////////////////////////////          
           else if(tempObject.getID() == ID.ShotGun){
              tempPlayerObject = tempObject;
              if(tempObject.getID() == ID.ShotGun){
              if(getBounds().intersects(tempObject.getBounds())){                 
                  health--;
               }
              
            }
        }
 ////////////////////////////////////////////////////////////////////////////////////////          
           else if(tempObject.getID() == ID.AirBurst){
              tempPlayerObject = tempObject;
              if(tempObject.getID() == ID.AirBurst){
              if(getBounds().intersects(tempObject.getBounds())){                 
                  health--;
               }
            }
        }
  ////////////////////////////////////////////////////////////////////////////////// 
            else if(tempObject.getID() == ID.FastBeam){
              tempPlayerObject = tempObject;
                if(tempObject.getID() == ID.FastBeam){
               //collision code
                if(getBounds().intersects(tempObject.getBounds())){
                  health--;
                }
            }
        }   
           if(health <= 3){
                  render(g);
                }
            if(health <= 0){
                handler.removeObject(this);
                HUD.score += 30;
                }
    }    
}

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}