/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author ralpoh
 */
public class Clock {
    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;
    public int delta = 0;
    public int deltaSeconds = 0;
    public int deltaMinutes = 0;
    
    
    public void tick(){
        long current = System.nanoTime();
        if(current >= 1000000000){
            delta ++;
        }
            if(delta >= 60){
                seconds++;
                deltaSeconds++;
                delta = 0;
            }
                if(seconds >= 60){
                    minutes++;
                    deltaMinutes++;
                    deltaSeconds = 0;
                    seconds = 0;
                }
                        if(minutes <= 60){
                            hours++;
                            minutes = 0;
                        }
                
              
        }
        
    }
                  
    

