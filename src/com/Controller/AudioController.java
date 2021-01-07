package com.Controller;

import com.Model.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AudioController {


    public void barcodeBeep()  {
        try
        {
            String filePath = "src/resources/scannerBeep.wav";
            AudioPlayer audioPlayer =
                    new AudioPlayer(filePath);
            audioPlayer.play();

        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }
    public void receiptPrinting() {
        try
        {
            String filePath = "src/resources/receiptPrinter.wav";
            AudioPlayer audioPlayer =
                    new AudioPlayer(filePath);
            audioPlayer.play();

        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

}

