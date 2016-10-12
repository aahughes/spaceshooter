/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.LinkedList;
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
    
    
   
    
    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
        c = new Clock();
        seconds = 0;
        stillEnemy = false;
        
        whichLevel = 1;
    }
    public Spawner(){
        seconds = 0;
        c = new Clock();
        stillEnemy = false;
       
        whichLevel = 1;
    }
    public void tick(){
        scoreKeep++;
  
        seconds = c.deltaSeconds;
       
        stillEnemy = presentEnemy();
          c.tick();
        
        
       
        // level system
        if(whichLevel == 1 && stillEnemy == false){
            level1();
            stillEnemy = true;
            whichLevel += 1;
            hud.level += 1; 
        }
        if(whichLevel == 2 && stillEnemy == false){
            level2();
            stillEnemy = true;
            whichLevel += 1;
            hud.level += 1; 
        }
         if(whichLevel == 3 && stillEnemy == false){
            level3();
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
        
        for(int i = 0; i <= 5; i++){
            handler.addObject(new EnemyDestroyer((WIDTH + increment)/2-32,HEIGHT/7,ID.BasicFighter,handler));
            increment += 200;
        }
        
    }
}   
    
    

