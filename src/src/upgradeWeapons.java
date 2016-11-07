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
public class upgradeWeapons extends GameObject {
    Handler handler;
    Clock c;
    int whichWeapon;
    Image img;
    int thisWeapon;
    
    public upgradeWeapons(float x, float y, ID id,Handler handler) {     
        super(x, y, id);
       
        this.handler = handler;
        velY = 1;
        c = new Clock();
       // System.out.println(id);
        if(this.id == ID.UpgradeFastBeam){
        	img = new JFrame().getToolkit().getImage("9.jpg");
        }
        else if(this.id == ID.UpgradeShotGun){
//            g.setColor(Color.BLUE);
        	img = new JFrame().getToolkit().getImage("7.jpg");
       	 	
        }
        else if(this.id == ID.UpgradeAirBurst){
        	img = new JFrame().getToolkit().getImage("8.jpg");
        }
    }

    @Override
    public void tick() {      
        x += velX;
        y += velY;
        collision();
    }

    @Override
    public void render(Graphics g) {
         
        
        
         //g.fillRect((int)x,(int)y,15,15);
         g.drawImage(img, (int)x, (int)y, (int)15, (int)15, null);
        
      
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,15,15);
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
