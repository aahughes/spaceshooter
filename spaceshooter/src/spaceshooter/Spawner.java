/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

/**
 *
 * @author ralph
 */
public class Spawner {
    private Handler handler;
    private HUD hud;
    Clock c;
    private int scoreKeep = 0;
    private int seconds;
    
    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
        c = new Clock();
        seconds = 0;
    }
    public Spawner(){
        seconds = 0;
        c = new Clock();
    }
    public void tick(){
        scoreKeep++;
  
        seconds = c.deltaSeconds;
         c.tick();
    }    
}   
    
    

