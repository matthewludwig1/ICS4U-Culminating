/*
    Matt, Aisik, Michelle, Liam
    2019-06-13
    This is the canvas class, which contains code to generate graphics
 */

package relativemotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author aipil3692
 */

public class Canvas extends JPanel{
    
    
    public void paint(Graphics g) {
    g.setColor(Color.green);
    
    
//    for(int i=0; i<RelativeMotion.objects.length; i++){
//       int x = (int)(RelativeMotion.objects[i].getX());
//       int y = (int)(RelativeMotion.objects[i].getY());
//        g.drawRect(x, y, 5, 5);
//    }
    
//    for(int z = 0; z < 10; z++){
//        g.drawRect(RelativeMotion.x+(z*10), RelativeMotion.y+(z*10), RelativeMotion.x/25, RelativeMotion.y/25);
//    }
    
    g.drawLine(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x, RelativeMotion.y*2); //y-axis back
    g.drawLine(0,RelativeMotion.y,RelativeMotion.x,RelativeMotion.y); //x-axis back
    g.drawLine(RelativeMotion.x,RelativeMotion.y,RelativeMotion.x*2,0); //z-axis back
    
    
    //g.fillRect(TestGUI.x/3,TestGUI.y/3,TestGUI.x,TestGUI.y);
    g.drawRect(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x/25, RelativeMotion.y/25);
    
    g.drawLine(RelativeMotion.x, 0, RelativeMotion.x, RelativeMotion.y); //y-axi front
    g.drawLine(RelativeMotion.x, RelativeMotion.y, RelativeMotion.x*2, RelativeMotion.y); //x-axi front
    g.drawLine(RelativeMotion.x, RelativeMotion.y, 0, RelativeMotion.y*2); //z-axi front 

    repaint();
  }
     
    public void trace(Physics object){
            double x = object.getX();
            double y = object.getY();
            double z = object.getZ();   
    }
    
    public void draw(){
    repaint();
    
    }
}
