/*
    Matt, Aisik, Michelle, Liam
    2019-06-12
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
            // adds each rocket to an array of Physics objects
            Physics[] objects = new Physics[3];
            objects[0] = new Rocket(0,0,0,2,2,3,500);
            objects[1] = new Physics(0,0,0,12,12,12,30);
            objects[2] = new Physics(0,0,0,23,43,20,25);
            
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