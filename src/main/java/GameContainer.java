import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameContainer implements Runnable{

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;

    private boolean running = false;

    private final double UPDATE_CAP = 1.0 / 60.0;
    private int width = 320;
    private int height =240;

    private float scale = 2.0f;
    private String title = "MyEngine v1.2";


    public GameContainer(){

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

                input.update();

                System.out.println("X: "+ input.getMouseX()+ " Y: " + input.getMouseY());

                if(input.isbuttonDown(MouseEvent.BUTTON1)){
                    System.out.println("A is pressed!");
                }
                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);

                }
                //todo update game!


            }
            if(render){
                renderer.clear();
                frames++;
                window.update();
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
    public static void main(String[] args){
        GameContainer gc = new GameContainer();
        gc.start();
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

}
