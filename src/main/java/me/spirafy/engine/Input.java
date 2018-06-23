package me.spirafy.engine;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    public GameContainer gc;

    private final int NUM_KEYS = 255;
    private final int NUM_BUTTONS = 5;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

    public Input(GameContainer gc){
        this.gc = gc;
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        gc.getWindow().getCanvas().addKeyListener(this);
        gc.getWindow().getCanvas().addMouseMotionListener(this);
        gc.getWindow().getCanvas().addMouseListener(this);
        gc.getWindow().getCanvas().addMouseWheelListener(this);
    }

    public void update(){
        scroll = 0;

        for(int i = 0; i < NUM_KEYS; i++){
            keysLast[i] = keys[i];
        }

        for(int i = 0; i < NUM_BUTTONS; i++){
            buttonsLast[i] = buttons[i];
        }
    }

    public boolean isKey(int KeyCode){
        return keys[KeyCode];
    }

    public boolean isKeyUp(int KeyCode){
        return !keys[KeyCode] && keysLast[KeyCode];
    }

    public boolean isKeyDown(int KeyCode){
        return keys[KeyCode] && !keysLast[KeyCode];
    }

    public boolean isButtom(int KeyCode){
        return buttons[KeyCode];
    }

    public boolean isButtonUp(int KeyCode){
        return !buttons[KeyCode] && buttonsLast[KeyCode];
    }

    public boolean isbuttonDown(int KeyCode){
        return buttons[KeyCode] && !buttonsLast[KeyCode];
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        mouseX = (int)(e.getX()/gc.getScale());
        mouseY = (int)(e.getY()/gc.getScale());
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX()/gc.getScale());
        mouseY = (int)(e.getY()/gc.getScale());
    }

    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getScroll() {
        return scroll;
    }
}
