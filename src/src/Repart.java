package src;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Repart {
URL url = Repart.class.getResource("resources/repart.png");
Image img = Toolkit.getDefaultToolkit().getImage(url);
int x,y;
public Repart(int x,int y){
	this.x=x;this.y=y;
}
}
