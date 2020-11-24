package brickproject;
import java.util.Scanner;

/**
 * @author Sene A.
 * @author Alex V. 
 */

        //TODO Loop for multiple voids, if any
        //TODO Polish up GUI and code.
        //TODO Error handling.
        //TODO consider padding bricks
        //TODO will we consider pricing?


public class BrickProject {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double brickH, brickW, mortar, brickArea;
        double wallH, wallW, wallArea;
        double voidH, voidW, voidRadius, voidArea = 0.0;
        double totalBricks;
        String input;
        
        //Bricks dimensions       
        System.out.print("Enter Height of brick in inches: ");
        brickH = kb.nextDouble();
        
        System.out.print("Enter Width of brick in inches: ");
        brickW = kb.nextDouble();
        
        //mortar thickness
        System.out.print("Enter Mortar Thickness in inches: ");
        mortar = kb.nextDouble();
        
        //wall dimensions   
        System.out.print("Enter Height of Wall in feet: ");
        wallH = kb.nextDouble();
        
        System.out.print("Enter Width of Wall in feet: ");
        wallW = kb.nextDouble();
        
        Brick brick = new Brick(brickH, brickW, mortar); //Brick object.
        
        wallH = ConvertMeasurements.FeetToInches(wallH); //Convert Feet to Inches.
        wallW = ConvertMeasurements.FeetToInches(wallW);
        
        Wall myWall = new Wall(wallH, wallW); //Wall object.
        
        wallArea = myWall.getArea(); //Area of desired wall.
        brickArea = brick.getArea(); //Area of a single brick.

        //void dimensions  
        System.out.println("Are there any voids in the wall?");
        input = kb.next();
        if(input.equalsIgnoreCase("yes")) {
            System.out.print("1. Rectangle"
                           + "\n2. Circular"
                           + "\n >> ");
            input = kb.next();
            if(input.equals("1")){
                System.out.println("Rectangle");
                System.out.println("Enter Height of the rectangle void in feet: ");
                voidH = kb.nextDouble();
                voidH = ConvertMeasurements.FeetToInches(voidH);
                
                System.out.println(voidH);
                
                System.out.println("Enter Width of the rectangle void in feet: ");
                voidW = kb.nextDouble();
                voidW = ConvertMeasurements.FeetToInches(voidW);
                
                System.out.println(voidW);
                
                RectangleVoid myVoid = new RectangleVoid(voidH, voidW);
                voidArea = myVoid.getArea(); //Area of the rectangular void
            }
            else if (input.equals("2")) {
                System.out.println("Circle");
                System.out.println("Enter Radius of the circular void in feet: ");
                voidRadius = kb.nextDouble();
                voidRadius = ConvertMeasurements.FeetToInches(voidRadius);
                CircleVoid myCircleVoid = new CircleVoid(voidRadius);
                voidArea = myCircleVoid.getArea(); //Area of the circle void
            }
            else {
                System.out.println("Enter a valid choice.");
            } 
            
            //System.out.println(wallArea + " " + voidArea + " " + brickArea);
            totalBricks = (wallArea - voidArea) / brickArea;    
            System.out.printf("Bricks: %.0f\n",totalBricks);
        }
        else if(input.equalsIgnoreCase("no")) {
            totalBricks = wallArea / brickArea;    
            System.out.printf("Bricks: %.0f\n",totalBricks);
        }
        else {
            System.out.println("Enter a valid choice.");
        }
     
    }    
}
