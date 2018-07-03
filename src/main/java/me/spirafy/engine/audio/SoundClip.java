package me.spirafy.engine.audio;

/*
 * This code was originally designed and coded by Swords1234.
 * You may contact by his email: Nintendodeveloper8@gmail.com
 * You can also contact him by his Discord: sword1234#6398
 */

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SoundClip {

    private Clip clip = null;
    private FloatControl gainControl;

    public SoundClip(String path){

        try {
            InputStream audioSrc = this.getClass().getResourceAsStream(path);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(),baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(), false);
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);

            clip = AudioSystem.getClip();
            clip.open(dais);

            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        } catch (UnsupportedAudioFileException |IOException |LineUnavailableException  e) {
            e.printStackTrace();
        }
    }

    public void play(){
        if(clip == null)
            return;
        stop();
        clip.setFramePosition(0);
        while (!clip.isRunning()){
            clip.start();
        }
    }
    public void stop(){
        if(clip.isRunning()){
            clip.stop();
        }
    }

    public void close(){
        stop();
        clip.drain();
        clip.close();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }

    public void setVolume(float value){
        gainControl.setValue(value);
    }

    public boolean isRunning(){
        return clip.isRunning();
    }
}
