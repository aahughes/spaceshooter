/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ralpoh
 */
public class HUD {
    
    public static float HEALTH = 100;
    
    private float greenVal = 255;
    
    public static int score = 0;
    public int level = 0;
    
    private Clock c = new Clock();
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    
    
    
    public void tick(){
     
      
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenVal = Game.clamp(greenVal,0,255);
        greenVal = HEALTH*2;
        c.tick();
       
       seconds = c.deltaSeconds;
       minutes = c.deltaMinutes;
    }
    public void render(Graphics g){
        
        g.setColor(Color.gray);
        g.fillRect(7,540,200,20);
        
        g.setColor(new Color(75,(int)greenVal,0));
        g.fillRect(7, 540, (int)HEALTH * 2, 20);
        
        g.setColor(Color.white);
        g.drawRect(7, 540, 200, 20);
        
        g.drawString("Score " + score,10,505);
        g.drawString("Level "+ level,10,520);
        
        g.drawString("Clock - Minutes: " + minutes + " Seconds: " + seconds, 10, 535);
     
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
        
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void scoreAdd(int score){
        this.score += score;
//        System.out.println("here"
//                + "");
//        System.out.println(this.score);
    }
}
