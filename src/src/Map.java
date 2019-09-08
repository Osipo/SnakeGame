package src;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class Map extends JPanel implements ActionListener{
URL url = Map.class.getResource("resources/map.jpg");
Image img = Toolkit.getDefaultToolkit().getImage(url);
Timer time = new Timer(125,this);
Snake p = new Snake(250,250);
Music m = new Music();//thread
Thread myThread = new Thread(m);//thread
int k = 0;
public Map(){time.start();addKeyListener(new MyKeyAdapter());setFocusable(true);myThread.start();}
private class MyKeyAdapter extends KeyAdapter {
	public void keyPressed(KeyEvent e){
		p.keyPressed(e);
		
	}
	public void keyReleased(KeyEvent e){
		p.keyReleased(e);
	}
}
public void paint(Graphics g){
	g = (Graphics2D) g;
	g.drawImage(img, 0, 0, null);
	g.setFont(new Font("Verdana",Font.BOLD,15));
	g.drawString("Points : "+p.point, 280, 40);
	 for (int z = 0; z < p.dots; z++) {
           g.drawImage(p.img,p.x[z],p.y[z],null);
          }
    g.drawImage(p.pr.img, p.pr.x, p.pr.y, null);
    if(p.draw) g.drawImage(p.rep.img, p.rep.x, p.rep.y, null);
    if(p.boxe) g.drawImage(p.box.img, p.box.x,p.box.y,null);
    Toolkit.getDefaultToolkit().sync();
}
@SuppressWarnings("deprecation")
@Override
public void actionPerformed(ActionEvent e) {
	p.move();
	p.checkCollision();
	repaint();
	k++;
	if(k>=175*8){myThread.stop(); myThread = new Thread(m);myThread.start();k =0; }
}
}
