package src;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Box {
	URL url = Repart.class.getResource("resources/box.png");
	Image img = Toolkit.getDefaultToolkit().getImage(url);
	int x,y;
	public Box(int x,int y){
		this.x=x;this.y=y;
	}
}
