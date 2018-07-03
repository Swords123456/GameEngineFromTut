package me.spirafy.engine.gfx;

/*
 * This code was originally designed and coded by Swords1234.
 * You may contact by his email: Nintendodeveloper8@gmail.com
 * You can also contact him by his Discord: sword1234#6398
 */

public class ImageTile extends Image{

    private int tileW;
    private int tileH;

    public ImageTile(String path, int tileW, int tileH) {
        super(path);
        this.tileW = tileW;
        this.tileH = tileH;
    }

    public int getTileW() {
        return tileW;
    }

    public void setTileW(int tileW) {
        this.tileW = tileW;
    }

    public int getTileH() {
        return tileH;
    }

    public void setTileH(int tileH) {
        this.tileH = tileH;
    }
}
