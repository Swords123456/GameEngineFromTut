package me.spirafy.engine;

import java.awt.event.MouseEvent;

public class GameContainer implements Runnable{

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame game;

    private boolean running = false;

    private final double UPDATE_CAP = 1.0 / 60.0;
    private int width = 320;
    private int height =240;

    private float scale = 2.0f;
    private String title = "MyEngine v1.2";


    public GameContainer(AbstractGame game){
        this.game = game;
    }
    public void start(){
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();
    }
    public void stop(){

    }
    public void run(){
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double pastTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int  frames = 0;
        int fps = 0;


        while (running){
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            pastTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += pastTime;
            frameTime += pastTime;


            while (unprocessedTime >= UPDATE_CAP){
                unprocessedTime -= UPDATE_CAP;
                render = true;

                game.update(this, (float) UPDATE_CAP);

                input.update();

                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                }
                //todo update game!


            }
            if(render){
                renderer.clear();
                game.render(this, renderer);
                renderer.drawText("FPS: " + fps, 0, 0, 0xff00ffff);
                window.update();
                frames++;
                //todo render game
            }else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }
    private void dispose(){

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public String getTitle() {
        return title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }
}
