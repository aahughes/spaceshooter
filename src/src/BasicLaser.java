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
public class BasicLaser extends GameObject {
    Handler handler;
    Image img;
    Clock c;
    public BasicLaser(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        c = new Clock();
        img = new JFrame().getToolkit().getImage("3.jpg");
    }
    @Override
    public void tick() {
         x += velX;
        y += velY;
        
        velY = 1;
   
        
        collision();
    }

    @Override
    public void render(Graphics g) {
//         g.setColor(Color.blue);
//        g.fillRect((int)x,(int)y,5,15);
    	
   	 	g.drawImage(img, (int)x, (int)y, (int)5, (int)15, null);
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
                    }
                
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
        
        
    
    
    
    

