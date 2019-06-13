/*
    Matt, Aisik, Michelle, Liam
    2019-06-13
    This is the main class for the relative motion simulation
 */
package relativemotion;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author lidea9928, malud0519
 */
public class RelativeMotion {

    /**
     * @param args the command line arguments
     */
    
    static int x,y;
    
    public static void main(String[] args) {
        
        Canvas panel = new Canvas();

    
        // create a basic JFrame
        JFrame frame = new JFrame("JFrame Color Example");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);

        // add panel to main frame
        frame.add(panel);
        frame.setVisible(true);

        x = (frame.getSize().width) / 2;
        y = (frame.getSize().height) / 2;

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                panel.draw();
                x = (frame.getSize().width) / 2;
                y = (frame.getSize().height) / 2;
                //frame.setSize(y,x);
            }
        });
        
        try {
            // adds each rocket to an array of Physics objects
            Physics[] objects = new Physics[3];
            objects[0] = new Rocket(0,0,0,2,2,3,500);
            objects[1] = new Physics(3,3,3,12,12,12,30);
            objects[2] = new Physics(4,5,4,23,43,20,3);
            
            
            while(objects.length > 0){ //mr kaune hates while true, so we'll delete
                for (int i = 0; i<objects.length;i++){
                    objects[i].go();
               
                }    
            }
      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelativeMotion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
 
}