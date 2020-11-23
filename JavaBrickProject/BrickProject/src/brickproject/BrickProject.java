package brickproject;

/**
 * @author Sene A.
 * @author Alex V. 
 */

public class BrickProject {
    public static void main(String[] args) {
        
        Brick brick = new Brick(3,3,7,.5);
        
        brick.getBrickInfo();
        System.out.println(brick.getArea() + " sq. inches");
    }    
}
