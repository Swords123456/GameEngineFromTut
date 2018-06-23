package me.spirafy.game;

import me.spirafy.engine.AbstractGame;
import me.spirafy.engine.GameContainer;
import me.spirafy.engine.Renderer;
import me.spirafy.engine.gfx.Image;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    public Image image;

    public GameManager(){
        System.out.println("This is being executed");
        image = new Image("/Pine.png");
    }

    public void update(GameContainer gc, float dt) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_A)){
            System.out.println("A was pressed!");
        }
    }

    public void render(GameContainer gc, Renderer r) {
        r.drawImage(image, 10,10);
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
