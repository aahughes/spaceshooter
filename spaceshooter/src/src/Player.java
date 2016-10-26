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
    HUD hud;
    
    public boolean isAlive;
    char[] weapon = new char[5];
    char currentWeapon;
    
            
    public Player(float x, float y, ID id,Handler handler,HUD hud) {
        super(x, y, id);
        this.handler = handler;
        this.hud = hud;
        isAlive = true;
        //different weapons
        weapon[0] = 'a'; // basic laser
        weapon[1] = 'b';
        weapon[2] = 'c';
        weapon[3] = 'd';
        weapon[4] = 'e';
        
        currentWeapon = 'a';
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
       
        for (GameObject tempObject : handler.object) {
            if(tempObject.getID() == ID.BasicFighter){
                //collision code
               
                if(getBounds().intersects(tempObject.getBounds())){
                    hud.loseHealth(5);
                }
            }
            if(tempObject.getID() == ID.BasicLaser){
                //collision code
               
                if(getBounds().intersects(tempObject.getBounds())){
                    hud.loseHealth(5);
                }
                
            }
            if(tempObject.getID() == ID.DestroyerLaser){
                //collision code
               
                if(getBounds().intersects(tempObject.getBounds())){
                    hud.loseHealth(5);
                }
                
            }
            if(tempObject.getID() == ID.StrikerLaser){
                //collision code
                
                if(getBounds().intersects(tempObject.getBounds())){
                    hud.loseHealth(5);
                }
                
            }
        }
        
   }
    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.BLUE);
        g.fillRect((int)x,(int)y,32,32);
      
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
    @Override
    public void action(){
        
        // basic laser    
        if(currentWeapon == weapon[0]){
                handler.addObject(new PlayerLaser(x+14,y,ID.PlayerLaser,handler));
            }
        else if(currentWeapon == weapon[1]){
            
        }
        else if(currentWeapon == weapon[2]){
            
        }
        else if(currentWeapon == weapon[3]){
            
        }
        else if(currentWeapon == weapon[4]){
            
        }
    }
}
