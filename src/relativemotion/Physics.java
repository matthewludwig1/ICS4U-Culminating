/*
    Matt, Aisik, Michelle, Liam
    2019-06-13
    This is the template for the physics object(engine)
 */
package relativemotion;

/**
 *
 * @author lidea9928, malud0519
 */
public class Physics {
    // variables declaration
    double [] spacialPositions = new double [3]; 
    Vector [] forces = new Vector[9];
    Vector velocity = new Vector();
    private double mass; 
    /**
     * 
     * @param x
     * x position
     * @param y
     * y position
     * @param z
     * z position
     * @param spdx
     * x component of speed
     * @param spdy
     * y component of speed
     * @param spdz
     * z component of speed
     * @param ms 
     * object's mass
     */
    Physics(double x, double y, double z, double spdx, double spdy, double spdz, double ms) { // default

        spacialPositions[0] = x;   // x dimension
        spacialPositions[1] = y;   // y dimension
        spacialPositions[2] = z;   // z dimension
        mass = ms;
        velocity.set(spdx, spdy, spdz); 
    }
    
    /**
     * 
     * @param ms 
     * sets the value of the object's mass (kilograms)
     */
    public void setMass(double ms) { 
        mass = ms;
    }
    
    /**
     * 
     * @return mass
     */
    public double getMass() {
        return mass;
    }
    
    // position getters
    
    /**
     * 
     * @return spacialPositions[0]
     * x-coordinate of rocket's position
     */
    public double getX() {
        return spacialPositions[0];
    }
    
    /**
     * 
     * @return spacialPositions[1]
     * y-coordinate of rocket's position
     */
    public double getY() {
        return spacialPositions[1];
    }
    
    /**
     * 
     * @return spacialPositions[2]
     * z-coordinate of rocket's position
     */
    public double getZ() {
        return spacialPositions[2];
    }
    
    /**
     * Adds components of velocity to the corresponding dimension
     */ 
    public void go(){
        spacialPositions[0] += velocity.x();  
        spacialPositions[1] += velocity.y();
        spacialPositions[2] += velocity.z();
        useTheForce();   
    }
    
    /**
     * General purpose method for adding force
     * @param vec 
     * Forces are added to Vector object, vec
     * forces[0]: Adds force in x-direction
     * forces[1]: Adds force in y-direction
     * forces[2]: Adds force in z-direction
     */
    public void addForce(Vector vec){  
        for (int i =1; i<forces.length; i++){
            if(forces[i]== null){
                forces[i] = vec;
            }
        }
    }
    
    /**
     * Each measure of velocity will be changed based on the acceleration:
     * forces[i]: retrieves components of force
     * velocity: new Vector object with the positions adjusted via forces array
     * Iterates until end of array
     */
    public void useTheForce(){  
        for (int i = 0; i < forces.length; i++) { // no enhanced loop, java
            if(forces[i] != null) {
                velocity = new Vector(velocity.x()+ forces[i].x() / mass, 
                        velocity.y() + forces[i].y()/ mass,
                        velocity.z() + forces[i].z()/ mass);  // beautiful equation
            }
        }
    }
  
}