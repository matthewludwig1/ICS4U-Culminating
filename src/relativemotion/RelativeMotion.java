/*
    Matt, Aisik, Michelle, Liam
    2019-06-11
    This is the main class for the relative motion simulation
 */
package relativemotion;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lidea9928, malud0519
 */
public class RelativeMotion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Physics[] objects = new Physics[3];
            objects[0] = new Rocket(0,0,0,2,2,3,500);
            objects[1] = new Physics(3,3,3,12,12,12,30);
            objects[3] = new Physics(25,25,12,23,43,20,3);
            
            while(true){ //mr kaune hates while true, so we'll delete
                for (int i=0; i<objects.length;i++){
                objects[i].go();
                }    
            }
      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelativeMotion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}