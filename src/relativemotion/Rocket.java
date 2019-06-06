package relativemotion;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lidea9928, malud0519
 */
public class Rocket extends Physics {
    FileReader commandsIn;
    boolean firing;
    double angle[];
    Rocket(double x, double y, double z, double spdx, double spdy, 
            double spdz, double ms) throws FileNotFoundException{   // default (instantiated on run-time)
        super(x,y,z,spdx,spdy,spdz,ms);  
        firing = false;
        angle = new double[]{0,0}; //x rot = pitch, yrot = yaw, zrot = spin in that order
        commandsIn = new FileReader("Command.txt");
    }
    
    public String readCommand(){
        Scanner sc = new Scanner(commandsIn);
        return sc.nextLine();
    }
    
    public void excecuteCommand(){  // this method checks the commands from the text file
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
            }
            else if("contine".equals(com[0])){
                cont(Double.parseDouble(com[1]));
            }
            else if("cut".equals(com[1])){
                cut();
            }
        }
    }

    private void yaw(double rot) {  // y- direction
        angle[1] += rot;
    }

    private void pitch(double rot) { // x- direction
       angle[0] += rot;
    }
    
    private void fire() { // adding a force to the vector
        firing = true;
        int forceOfEngine = 30;
        // gets dimensional components of applied force vector
        double y = forceOfEngine*Math.sin(Math.toRadians(angle[0]));  // or forceVector* sin (angle z) * sin angle y to x
        double x = forceOfEngine*Math.sin(Math.toRadians(angle[1]));  
       // Vector v = new Vector(); might need to declare a new vector
        double z = forceOfEngine*Math.cos(Math.toRadians(angle[2]));  // 3rd dimension might not be implemented
    }

    private void cont(double rot) {
       
    }

    private void cut() {
        
    }

}