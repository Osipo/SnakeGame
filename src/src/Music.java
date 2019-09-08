package src;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music implements Runnable{
URL url = Music.class.getResource("sound/Waterflame - Jumper.wav");
public  void run() {
	try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(url);
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		clip.setFramePosition(0);
		clip.start();
		
	} catch(Exception exc) {
		exc.printStackTrace();
	} 
	

}

}
