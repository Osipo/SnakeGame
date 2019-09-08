package src;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

import javax.swing.JOptionPane;

public class Snake {
	static final int UP=0,DOWN=550,LEFT=0,RIGHT=575;//windows
	int point = 0;//points.
URL url = Snake.class.getResource("resources/snake.png");
Image img = Toolkit.getDefaultToolkit().getImage(url);
int dots = 1; int dotssize = 10;//size of snake's part and start quality.
final int ALLPARTS = 900;//all parts of our snake.
private boolean left = false;//directions.
private boolean right = true;
private boolean up = false;
private boolean down = false;
boolean draw = false;
int x[] = new int[ALLPARTS],y[] = new int[ALLPARTS];//our snake.
public Snake(int x,int y){this.x[0]=x;this.y[0]=y;}//zero index - this is the snake's head.
Random g = new Random(550);
int s = 1;//position of repart.
int s1 = 1;//position of box.
Part pr = new Part(g.nextInt(550),g.nextInt(550));//part of our snake or apple, which increase snake's size.
Repart rep;//part of our snake or apple,which DECREASE snake's size. 
Box box;//Simply box, not more.
boolean boxe = false;
public void move(){
	for(int z=dots;z>0;z--){//to move parts.
		x[z]=x[(z-1)];y[z]=y[(z-1)];
	}
	 if (left) {//follow left, right, up, down. Head follow and the parts of snake moves with her.
         x[0] -=dotssize;
     }

     if (right) {
         x[0] +=dotssize;
     }

     if (up) {
         y[0] -=dotssize;
     }

     if (down) {
         y[0] +=dotssize;
     }
	if((x[0]>=pr.x-25&&x[0]<=pr.x+25)&&(y[0]>=pr.y-25&&y[0]<=pr.y+25)){dots++;point++;pr = new Part(g.nextInt(550),g.nextInt(550));s = g.nextInt(500);if(s%5==0){rep = new Repart(g.nextInt(550),g.nextInt(550));draw = true;}else{draw = false;}//if we reach the part(apple).
    if(!boxe) s1 = g.nextInt(500); if(s1%4==0){if(!boxe)box = new Box(g.nextInt(500),g.nextInt(500));boxe=true;}else{boxe=false;}}
	if(draw){if((x[0]>=rep.x-25&&x[0]<=rep.x+25)&&(y[0]>=rep.y-25&&y[0]<=rep.y+25)){if(dots>1)dots--;draw=false;}}
	if(boxe){if((x[0]>=box.x-25&&x[0]<=box.x+25)&&(y[0]>=box.y-25&&y[0]<=box.y+25)){
		//to move parts.
			box.x=x[0]+25;box.y=y[0];
		
		//box.x=x[(0)]+25;box.y=y[0];
	}}
	if(boxe){if(box.x<=LEFT||box.x>=RIGHT||box.y<=UP||box.y>=DOWN){box=null;boxe=false;point+=10;}}
}
public void checkCollision() {
    for (int z = dots; z > 0; z--) {
        if ((z > 1) && (x[0] == x[z]) && (y[0] == y[z])) {
            JOptionPane.showMessageDialog(null, "GAME OVER! Your points are: "+point);System.exit(1);
        }
    }
    if(x[0]<=LEFT||x[0]>=RIGHT||y[0]>=DOWN||y[0]<=UP){JOptionPane.showMessageDialog(null, "GAME OVER! Your points are: "+point);System.exit(1);}
}
public void keyPressed(KeyEvent e) {
	int key=e.getKeyCode();
	 if ((key == KeyEvent.VK_LEFT) && (!right)) {
         left = true;
         up = false;
         down = false;
     }

     if ((key == KeyEvent.VK_RIGHT) && (!left)) {
         right = true;
         up = false;
         down = false;
     }

     if ((key == KeyEvent.VK_UP) && (!down)) {
         up = true;
         right = false;
         left = false;
     }

     if ((key == KeyEvent.VK_DOWN) && (!up)) {
         down = true;
         right = false;
         left = false;
     }
}
public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();
	if(key==KeyEvent.VK_LEFT){}
	else if(key==KeyEvent.VK_RIGHT){}
	else if(key==KeyEvent.VK_UP){}
	else if(key==KeyEvent.VK_DOWN){}
	
}
}
