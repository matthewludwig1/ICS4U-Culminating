/*
    Matt, Aisik, Michelle, Liam
    2019-06-13
    This is rocket object class
 */


package relativemotion;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lidea9928, malud0519
 */
public class Rocket extends Physics {
    FileReader commandsIn;
    boolean firing;
    Vector direction = new Vector();
    double angle[];  
    int forceOfEngine = 0;
    /**
     * @param x
     * @param y
     * @param z
     * @param spdx
     * @param spdy
     * @param spdz
     * @param ms
     * @throws FileNotFoundException 
     */
    Rocket(double x, double y, double z, double spdx, double spdy, 
        double spdz, double ms) throws FileNotFoundException{   // default (instantiated on run-time)
        super(x,y,z,spdx,spdy,spdz,ms);  
        firing = false;
        angle = new double[]{0,0,0}; //x rot = "pitch", yrot = "yaw", zrot = "spin" in that order
        commandsIn = new FileReader("Command.txt");
    }

    public String readCommand(){
        Scanner sc = new Scanner(commandsIn);
        
        if (sc.hasNextLine()) {  
            return sc.nextLine();
        }
       else{
            return "continue";
        }                                                           
    }
    
    public void excecuteCommand(){  // this method excecutes the commands from the text file
        String[] com = readCommand().split(" ");
        if (com.length >0){
            if ("yaw".equals(com[0])){
                yaw(Double.parseDouble(com[1]));
            }
            else if("pitch".equals(com[0])){
                pitch(Double.parseDouble(com[1]));
            }
            else if("fire".equals(com[0])){  
                fire();
         
                /*     alternate
                       String [] fireComponent = com[1].split(",");
                       fire(Double.parseDouble(fireComponent[0]),Double.parseDouble(fireComponent[1])
                       ,Double.parseDouble(fireComponent[2])); 
                */
            }
            else if("continue".equals(com[0])){
                while (firing == true) {
                    cont();
                }
            }
            else if("cut".equals(com[0])){
                cut();
            }
  
        }
    }

    private void yaw(double rot) {  // y- direction rotation
        double x = direction.x()*Math.cos(Math.toRadians(rot))+direction.y()*Math.sin(Math.toRadians(rot));
        double y = (-direction.x()*Math.sin(Math.toRadians(rot)))+direction.y()*Math.cos(Math.toRadians(rot));
        double z = direction.z();
        direction.set(x, y, z);
    }

    private void pitch(double rot) { // x- direction rotation
       rot = Math.toRadians(rot);
       double x = direction.x()*Math.cos(rot)+direction.z()*(-Math.sin(rot));
       double y = direction.y();
       double z = direction.x()*Math.sin(rot)+direction.z()*Math.cos(rot);
       direction.set(x, y, z);
    }
    

    private void fire (){  
        double engineAccel = 200/this.getMass();
        Vector vec = new Vector(direction.x()*engineAccel,direction.y()*engineAccel, direction.z()*engineAccel);
        forces[0] = vec;
    }
    
    /*  alternative
    private void fire(double x, double y, double z) { // adding rocket force
        firing = true;
        forceOfEngine =30;
        // gets dimensional components of applied force vector
      
        Vector vec = new Vector(x,y,z); // declares new vector
        forces[0] = vec; // adds Vector vec to slot 1 of Vector array (in Physics class)
    }
    */
    private void cont() { 
/*       
         Alt:
         forceOfEngine += 0;
         yaw(0);  // stays in place (y -direction)
         pitch(0); // stays in place (x -direction)
         for(int i = 0; i < turns; i++) {
            cont(i);      
*/       }
    }

    private void cut() {
        firing = false;
        forces[0] = null;
    }
    
    @Override
    public void go(){
        spacialPositions[0] += velocity.x();  // adds the velocity to the position
        spacialPositions[1] += velocity.y();
        spacialPositions[2] += velocity.z();
        excecuteCommand();
        useTheForce(); 
    }

}
