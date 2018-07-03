package me.spirafy.game;

import me.spirafy.engine.AbstractGame;
import me.spirafy.engine.GameContainer;
import me.spirafy.engine.Renderer;
import me.spirafy.engine.audio.SoundClip;
import me.spirafy.engine.gfx.Image;
import me.spirafy.engine.gfx.ImageTile;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    public ImageTile image;
    public SoundClip clip;

    public GameManager(){
        System.out.println("This is being executed");
        image = new ImageTile("/ExplosionAlpha.png", 16, 16);
        clip = new SoundClip("/audio.wav");
        clip.setVolume(-20);
    }

    public void update(GameContainer gc, float dt) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_A)){
            clip.play();
            System.out.println("A was pressed!");
        }

        temp += dt * 20;
        if(temp > 4){
            temp = 0;
        }
    }

    float temp = 0;

    public void render(GameContainer gc, Renderer r) {
        //r.drawRect(10 , 10, 64, 32, 0xffffffff);
        //r.drawFillRect(gc.getInput().getMouseX() - 20 , gc.getInput().getMouseY() - 20, 40, 80, 0xffffffff);
        r.drawImageTile(image, gc.getInput().getMouseX() - 8 ,gc.getInput().getMouseY() - 16, (int) temp, 0);
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
