/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.LinkedList;
import java.util.Random;
import static src.Game.HEIGHT;
import static src.Game.WIDTH;

/**
 *
 * @author ralpoh
 */
public class Spawner {
    private Handler handler;
    private HUD hud;
    Clock c;
    private int scoreKeep = 0;
    private int seconds;
    boolean stillEnemy;
    int increment;
    int whichLevel;
    Random r;
    boolean cont;
    ID tempID;
    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
        c = new Clock();
        seconds = 0;
        stillEnemy = true;
        r = new Random();
        whichLevel = 1;
        cont = false;
       tempID = null;
        
    }
    public Spawner(){
        seconds = 0;
        c = new Clock();
        stillEnemy = false;
       r = new Random();
        whichLevel = 1;
    }
    public void tick(){
        
        scoreKeep++;
        
        seconds = c.deltaSeconds;
        
          cont = spawnUpgrade();
          c.tick();
        //stillEnemy = presentEnemy();
        if(cont == true){
            
            int tempLocation = r.nextInt((int)WIDTH);
            int whichUpgrade = r.nextInt(3);
            
            if(whichUpgrade == 0){
            tempID = ID.UpgradeShotGun;
            }
            else if(whichUpgrade == 1){
            tempID = ID.UpgradeAirBurst; 
            }
            else if(whichUpgrade == 2){
            tempID = ID.UpgradeFastBeam;
            }  
            handler.addObject(new upgradeWeapons(tempLocation,0,tempID,handler));
            
        }
       
        // level system
        if(whichLevel == 1 && stillEnemy == false){     
            level1();
            stillEnemy = true;
            whichLevel += 1;
            hud.level += 1; 
        }  
        else if(whichLevel == 2 && stillEnemy == false){
            clearScreen();
            level2();
            stillEnemy = true;
            whichLevel += 1;
            hud.level += 1; 
        }
        else if(whichLevel == 3 && stillEnemy == false){
            clearScreen();
             level3();
            stillEnemy = true;
            whichLevel += 1;
            hud.level += 1; 
        }
        else if(whichLevel == 4 && stillEnemy == false){
            clearScreen();
             level4();
            stillEnemy = true;
            whichLevel += 1;
            hud.level += 1; 
        }
        
       // System.out.println(whichLevel);
    }
    public boolean presentEnemy(){ 
        boolean tempEnemy = false;
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.id == ID.BasicFighter){
                tempEnemy = true;
                return true;
            }
             if(tempObject.id == ID.EnemyDestroyer){
                tempEnemy = true;
                return true;
            }
             if(tempObject.id == ID.EnemyStriker){
                tempEnemy = true;
                return true;
            }
        }
        if(tempEnemy == false){
         //   System.out.println("h");
            return false;
        }
        
        return false;
    }
    public void level1(){
        increment = -400;
        for(int i = 0; i <= 5; i++){
           handler.addObject(new BasicFighter((WIDTH + increment)/2-32,HEIGHT/7,ID.BasicFighter,handler));
         
           increment += 200;
           
       }
    }
    public void level2(){
        increment = -600;
        
          for(int i = 0; i <= 10; i++){
           handler.addObject(new BasicFighter((WIDTH + increment)/2-32,HEIGHT/7,ID.BasicFighter,handler));
           
           increment += 100;
           
       }
   
    }
    public void level3(){
        increment = -600;
        
        for(int i = 0; i <= 2; i++){
            handler.addObject(new EnemyDestroyer((WIDTH + increment)/2-32,HEIGHT/7,ID.EnemyDestroyer,handler));
            increment += 600;
        }
         increment = -300;
        for(int i = 0; i <= 1; i++){
            handler.addObject(new EnemyDestroyer((WIDTH + increment)/2-32,HEIGHT/3,ID.EnemyDestroyer,handler));
            increment += 600;
        }
        
    }
      public void level4() {
         
          for(int i = 0; i <= 3; i++){
           handler.addObject(new EnemyStriker((r.nextInt((int) WIDTH - 32)),r.nextInt((int)HEIGHT - 32),ID.EnemyStriker,handler));
            
       }
        
    }
    public void clearScreen(){
        
        for(int i = 0; i < handler.object.size(); i++){
           GameObject tempObject = handler.object.get(i);
           if(tempObject.getID() != ID.Player){
               handler.object.remove(tempObject);
               i = 0;
           }  
        }        
    }
    public boolean spawnUpgrade(){
        boolean timerToSpawn = false;
        
        if(c.seconds == 5){
            timerToSpawn = true;
            c.seconds = 0;
        }
        return timerToSpawn;
    }
}   
    
    

