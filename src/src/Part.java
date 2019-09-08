package src;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Part {
URL url = Part.class.getResource("resources/snake.png");
Image img = Toolkit.getDefaultToolkit().getImage(url);
int x,y;
public Part(int x,int y){this.x=x;this.y=y;}
}
