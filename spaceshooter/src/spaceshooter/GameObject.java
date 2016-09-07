/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ralpoh
 */

public abstract class GameObject {
   // Location of object
    protected int x,y;
    // ID of object
    protected ID id;
    // movement of object
    protected int velX, velY;
    protected int WIDTH, HEIGHT;
    protected Handler handler;
    
    public GameObject(int x, int y, ID id){
        // Initial position of object
        
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
        // Change the width if you are making the screen bigger. These values arent connected to game clase
        WIDTH = 800;
        HEIGHT = WIDTH /12 *9;
    }
    
    // abstract methods
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract void collision();
        
    //getter and setters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y ){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void setID(ID id){
        this.id = id;
    }
    public ID getID(){
        return id;
    }
    
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
}
