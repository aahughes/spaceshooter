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
public class upgradeWeapons extends GameObject {
    Handler handler;
    Clock c;
    int whichWeapon;
    int thisWeapon;
    
    public upgradeWeapons(float x, float y, ID id,Handler handler) {     
        super(x, y, id);
       
        this.handler = handler;
        velY = 1;
        c = new Clock();
       // System.out.println(id);
    }

    @Override
    public void tick() {      
        x += velX;
        y += velY;
        collision();
    }

    @Override
    public void render(Graphics g) {
         
        
        if(this.id == ID.UpgradeFastBeam){
             g.setColor(Color.RED);
        }
        else if(this.id == ID.UpgradeShotGun){
            g.setColor(Color.white);
        }
        else if(this.id == ID.UpgradeAirBurst){
            g.setColor(Color.GREEN);
        }
         g.fillRect((int)x,(int)y,15,15);
       
        
      
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
                  System.out.println("RIGHT HERE FAGGOT");
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
