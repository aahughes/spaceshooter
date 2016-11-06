/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ralpoh
 */

public abstract class GameObject {
   // Location of object
    protected float x,y;
    // ID of object
    protected ID id;
    // movement of object
    protected float velX, velY;
    protected float WIDTH, HEIGHT;
    protected Handler handler;
    HUD hud;
    public GameObject(float x, float y, ID id){
        // Initial position of object
        
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
        // Change the width if you are making the screen bigger. These values arent connected to game clase
        WIDTH = 800;
        HEIGHT = WIDTH /12 *9;
        hud = new HUD();
    }
    // abstract methods
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract void collision();
    public abstract void action();
        
    //getter and setters
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y ){
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setID(ID id){
        this.id = id;
    }
    public ID getID(){
        return id;
    }
    public void setVelX(float velX){
        this.velX = velX;
    }
    public void setVelY(float velY){
        this.velY = velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
}
