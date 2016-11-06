/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ralph
 */
public class Game extends Canvas implements Runnable {
    GameOverScreen gameOver;
    // main linked list of objects rendered to screen
    private Handler handler;
    // frame size
    public static final float WIDTH = 800, HEIGHT = 600;
    // first thread for game
    private Thread thread;
    // main boolean for if the game is running
    private boolean running = false;
    // test for randoms
    Random r = new Random();
    Canvas buffer;
    // heads up display, health and shit
    private HUD hud;
    // spawner for levels
    private Spawner spawner;
    // tracking time dawg
    private int seconds;
    private int minutes;
    private int hours;
    Clock c;
    test test;
    boolean isNew;
    // reference to GameWindow for method use
    private GameWindow window;
    Image img;
    // contructor for game
    
    public Game(GameWindow window){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        hud = new HUD();
       // System.out.println("here");
        spawner = new Spawner(handler, hud);
        // time stuff
        seconds = 0;
        
        minutes = 0;
        hours = 0;
        c = new Clock();
        isNew = true;
        this.window = window;
        hud.score = 0;
        img = new JFrame().getToolkit().getImage("bg.jpg");
        // player           
        handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler,hud));
         
        
       // test
        test = new test();
        
       
    }
    
    
    // start method
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    // stop method
     public synchronized void stop(){
        try{
            // thread.join is to stop the game
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
    @Override
    public void run() {
        this.requestFocus();

        //game loop
        // nano seconds for frame rate
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
                frames++;
                
                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    System.out.println("FPS: "+ frames);
                    frames = 0;
                    timer++;
                  //  System.out.println(c.deltaSeconds);
                    
                    
                    
                    
                }
                if(timer == 100000){
                    System.out.println(timer);
                }
               
                
        }
         stop();
        
    }
    private void tick(){
        handler.tick();
        
        hud.tick();
        
        isNew = spawner.presentEnemy();
        
        if(hud.noHealth){ 
            gameOver();
            //debug
            System.out.println("game over");
            stop();
        }
        if(isNew == false){
            test.action = false;
            boolean cont = false;
            
            while(cont == false){
                
                cont = test.run();
                running = false;
                if(cont == true)
                 {
                System.out.println("here");
                    running = true;
                    spawner.stillEnemy = false;         
                }
            }
            
        }
        c.tick();
        spawner.tick();
    }
    private void render(){
        // main color method for rendering to window, graphics
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        //背景
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);
        
    	
   	g.drawImage(img, (int)0, (int)0, (int)WIDTH, (int)HEIGHT, null);
        
        handler.render(g);
        hud.render(g);
        
        
        g.dispose();
        bs.show();
        
        
    }
    public static float clamp(float var, float min, float max){
        // boundries of window
        
        if(var >= max)return var = max;
        else if(var <= min) return var = min;
        else return var;
        
    }
    
    public void gameOver(){
        window.openGameOver();
    }
    public void levelWindow(){
       
    }  
}
