import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private Clip boom;
    Sound(){
        try {
            File boomFile = new File("boom.wav");
            Clip boomClip = AudioSystem.getClip();
            boomClip.open(AudioSystem.getAudioInputStream(boomFile));
            this.boom = boomClip;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {    
            e.printStackTrace();
        }
        
    }

    public void playBoom(){
        boom.start();
        
    }
}
