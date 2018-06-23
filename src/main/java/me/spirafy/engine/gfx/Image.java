package me.spirafy.engine.gfx;
/*
 * Copyright (c) 2018. Spirafy Network
 * All rights are reserved to the Spirafy Network. Your are not allowed to edit, distribute or copy any code in here without permission
 * Penalties will apply.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    private int w,h;
    private int[] p;

    public Image(String path){

        if(path != null) System.out.println("Pa isnt null");
        BufferedImage image = null;

        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println("Resources are unavailable");
            e.printStackTrace();
        }

        if(image != null){
            System.out.println("Image isn't null");
            return;
        }

        w = image.getWidth();
        h = image.getHeight();
        p = image.getRGB(0, 0,w, h, null, 0, w);

        image.flush();
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }
}