/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author ralpoh
 */

public class Player extends GameObject{
    Handler handler;
    HUD hud;
    Image img;
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
        img = new JFrame().getToolkit().getImage("1.jpg");
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
                if(tempObject.getID() == ID.UpgradeShotGun){
                if(getBounds().intersects(tempObject.getBounds())){
                    currentWeapon = 'b';
                //    System.out.println(currentWeapon);
                }
            }
                if(tempObject.getID() == ID.UpgradeAirBurst){
                if(getBounds().intersects(tempObject.getBounds())){
                    currentWeapon = 'c';
                 //   System.out.println(currentWeapon);       
                } 
            }
                if(tempObject.getID() == ID.UpgradeFastBeam){
                if(getBounds().intersects(tempObject.getBounds())){
                    currentWeapon = 'd';
                 //   System.out.println(currentWeapon);
                } 
            }
        }
        
        
   }
    @Override
    public void render(Graphics g) {
        
//        g.setColor(Color.BLUE);
//        g.fillRect((int)x,(int)y,32,32);
//    	 URL u=Player.class.getClassLoader().getResource("1.jpg");
//         BufferedImage img=null;
//         try {
//             img=ImageIO.read(u);
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
    	
    	 g.drawImage(img, (int)x, (int)y, (int)32, (int)32, null);
      
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
    @Override
    public void action(){
        
        // basic laser    
        if(currentWeapon == weapon[0]){
                handler.addObject(new PlayerLaser(x+14,y,ID.PlayerLaser,handler,0,-2));
            }
        // shotgun
        else if(currentWeapon == weapon[1]){
            handler.addObject(new ShotGun(x+14,y,ID.ShotGun,handler,0,-3));
            handler.addObject(new ShotGun(x+28,y,ID.ShotGun,handler,1,-3));
            handler.addObject(new ShotGun(x,y,ID.ShotGun,handler,-1,-3));
        }
        //airburst
        else if(currentWeapon == weapon[2]){
            handler.addObject(new AirBurst(x+14,y,ID.AirBurst,handler,0,-2));
            
        }
        // fastBeam
        else if(currentWeapon == weapon[3]){
            handler.addObject(new FastBeam(x+14,y,ID.FastBeam,handler,0,-4));
        }
        else if(currentWeapon == weapon[4]){
            
        }
    }
}
