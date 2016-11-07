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
public class BasicFighter extends GameObject {
    Handler handler;
    float initialX;
    Clock c;
    Image img;
    
    public BasicFighter(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.initialX = x;
        this.handler = handler;
        velX = 1;
        c = new Clock();
        img = new JFrame().getToolkit().getImage("2.jpg");
        
    }

    @Override
    public void tick() {
        c.tick();
        x += velX;
        y += velY;
        
        // laser shooting
        if(c.deltaSeconds >= 2){
            handler.addObject(new BasicLaser(x,y,ID.BasicLaser,handler));   
            c.deltaSeconds = 0;
        } 
        
        if(x <= initialX - 50 || x >= initialX + 50) velX*= -1;  
        if(y <= 0 || y >= Game.HEIGHT - 64) velY*= -1;
        if(x <= 0 || x >= Game.WIDTH - 34) velX *= -1;
       
    }

    @Override
    public void render(Graphics g) {
        
//        g.setColor(Color.RED);
//        g.fillRect((int)x,(int)y,32,32);
    	
   	 	g.drawImage(img, (int)x, (int)y, (int)32, (int)32, null);
      
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
              if(getBounds().intersects(tempObject.getBounds())){
                   handler.removeObject(this);
                   HUD.score++;
               }
                
               }
           }
           ///////////////////////////////////////////////////
           if(tempObject.getID() == ID.ShotGun){
              tempPlayerObject = tempObject;
           if(tempObject.getID() == ID.ShotGun){
              if(getBounds().intersects(tempObject.getBounds())){
                   handler.removeObject(this);
                   HUD.score++;
               }
               }
           }
           ///////////////////////////////////////////////////
           if(tempObject.getID() == ID.AirBurst){
              tempPlayerObject = tempObject;
           if(tempObject.getID() == ID.AirBurst){
              if(getBounds().intersects(tempObject.getBounds())){
                   handler.removeObject(this);
                   HUD.score++;
               }
               }
           }
           ///////////////////////////////////////////////////
        if(tempObject.getID() == ID.FastBeam){
              tempPlayerObject = tempObject;
           if(tempObject.getID() == ID.FastBeam){
              if(getBounds().intersects(tempObject.getBounds())){
                   handler.removeObject(this);
                   HUD.score++;
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
