package com.Controller;
import com.Model.AudioPlayer;
public class AudioController {

    //Method for playing the barcode beep sound file, called when a product is added to the basket
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
    //Method for playing the receipt printer sound file, called when we view a receipt
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

