package com.Model;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

//Audio player class for playing audio files (used for receipt printer noise and barcode scanner beep)
public class AudioPlayer {
    //Clip variable - for holding our sound effect files
    Clip clip;
    AudioInputStream audioInputStream;
    //Audio player constructor
    public AudioPlayer(String filePath)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        //Create an Audio Input Stream using the file path passed in
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        //Get a clip reference
        clip = AudioSystem.getClip();

        //Opens the audio file
        clip.open(audioInputStream);

    }
    //Play our audio file
    public void play() {
        clip.start();
    }
}
