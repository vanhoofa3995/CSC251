package brickproject;
import java.util.Scanner;

/**
 * @author Sene A.
 * @author Alex V. 
 */

public class BrickProject {    
    public static double GetBrickHeight(Scanner kb) {
        String input;
        double brickH;
        do {
            System.out.print("Enter Height of brick in inches: ");
            input = kb.next();
            try {
                brickH = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        }while(true);
        return brickH;
    }
    
    public static double GetBrickWidth(Scanner kb) {
        String input;
        double brickW;
        do {
            System.out.print("Enter Width of brick in inches: ");
            input = kb.next();
            try {
                brickW = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        }while(true);
        return brickW;
    }
    
    public static double GetMortarThickness(Scanner kb) {
        String input;
        double mortar;
        do {

            System.out.print("Enter Mortar Thickness in inches: ");
            input = kb.next();
            try {
                mortar = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        }while(true);
        return mortar;
    }
    
    public static double GetWallHeight(Scanner kb) {
        String input;
        double wallH;
        do {
            System.out.print("Enter Height of Wall in feet: ");
            input = kb.next();
            try {
                wallH = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        }while(true);
        wallH = ConvertMeasurements.FeetToInches(wallH); //Convert to inches
        return wallH;
    }
    
    public static double GetWallWidth(Scanner kb) {
        String input;
        double wallW;
        do {
            System.out.print("Enter Width of Wall in feet: ");
            input = kb.next();
            try {
                wallW = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        }while(true);
        wallW = ConvertMeasurements.FeetToInches(wallW);
        return wallW;
    }
    
    public static double GetVoidHeight(Scanner kb) {
        String input;
        double voidH;
        do {
            System.out.print("Enter Height of the "
                             + "rectangular void in feet: ");
            input = kb.next();
            try {
                voidH = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        } while(true);
        voidH = ConvertMeasurements.FeetToInches(voidH);
        return voidH;
    }
    
    public static double GetVoidWidth(Scanner kb) {
        String input;
        double voidW;
        do {
            System.out.print("Enter Width of the rectangular void in feet: ");
            input = kb.next();
            try {
                voidW = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        } while(true);
        voidW = ConvertMeasurements.FeetToInches(voidW);
        return voidW;
    }
    
    public static double GetVoidRadius(Scanner kb) {
        String input;
        double voidRadius;
        do {
            System.out.print("Enter Radius of the circular void in feet: ");
            input = kb.next();
            try {
                voidRadius = Double.parseDouble(input);
                break;
            }
            catch(Exception e) {
                System.out.println("Invalid input");
            }
        }while(true);
        voidRadius = ConvertMeasurements.FeetToInches(voidRadius);
        System.out.println(voidRadius);
        return voidRadius;
    }
    
    public static double CalcTotalBricks(double wallArea, double voidArea, double brickArea) {
        return (wallArea - voidArea) / brickArea;
    }
    
    public static double CalcPadding(double totalBricks) {
        return totalBricks * .2; //adding 20% to total bricks
    }
    
    public static void DisplayBricksNeeded(double totalBricks, double padding) {
        System.out.printf("Bricks needed: %.1f\n",totalBricks);
        System.out.printf("Suggested amount: %.1f\n", padding + totalBricks);
        System.out.println();
    }
                    
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Brick myBrick = new Brick();
        Wall myWall;
        double brickH, brickW, mortar, brickArea; //Brick Properties
        double wallH, wallW, wallArea; //Wall Properties
        double voidH, voidW, voidRadius, voidArea = 0.0; //Void Properties
        double totalBricks, padding;
        String input;
        boolean replay = true,
                subMenu = true;
        
        //Started refactoring for menu options
        do {
            System.out.println("\tCSC 251 Brick Project");
            System.out.print("1. View/Adjust Brick Properties"
                           + "\n2. Build Your Wall"
                           + "\n3. Exit"
                           + "\nChoose: ");
            input = kb.next();
            
            switch (input) {
                case "1":    
                    do {
                        myBrick.getBrickInfo();
                        System.out.print("1. Adjust Brick Properties"
                                + "\n2. Return to Main Menu"
                                + "\nChoose: ");
                        input = kb.next();
                        System.out.println();
                        switch(input) {
                            case "1":
                                //Adjust brick properties          
                                brickH = GetBrickHeight(kb);
                                brickW = GetBrickWidth(kb);
                                mortar = GetMortarThickness(kb);    
                                myBrick = new Brick(brickH, brickW, mortar);
                                System.out.println();                                
                                break;

                            case "2":
                                subMenu = false;
                                break;

                            default:
                                System.out.print("Choose: ");
                                break;
                        }
                    } while(subMenu);
                    break;
                    
                case "2":
                    System.out.println("\nEnter Wall Dimensions");
                    //wall dimensions  
                    wallH = GetWallHeight(kb);
                    wallW = GetWallWidth(kb);
                    myWall = new Wall(wallH, wallW); //Create Wall obj.
                    System.out.println();
                    wallArea = myWall.getArea(); //Area of desired wall.
                    brickArea = myBrick.getArea(); //Area of a single brick.
                    //void dimensions 
                    do {    
                        System.out.println("Insert a void in your wall?('Yes' or 'No')");
                        input = kb.next();
                        if(input.equalsIgnoreCase("yes")) {
                            System.out.print("1. Rectangular"
                                         + "\n2. Circular"
                                         + "\nChoose: ");
                            input = kb.next();
                            if(input.equals("1")){
                                voidH = GetVoidHeight(kb);
                                voidW = GetVoidWidth(kb);
                                RectangleVoid myVoid = new RectangleVoid(voidH, voidW);
                                voidArea += myVoid.getArea();
                                System.out.println();
                            }
                            else if (input.equals("2")) {
                                System.out.println("Circular Void");
                                voidRadius = GetVoidRadius(kb);
                                CircleVoid myCircleVoid = new CircleVoid(voidRadius);
                                voidArea += myCircleVoid.getArea();
                                System.out.println();
                            }
                            else {
                                System.out.println("Enter a valid choice.");
                            } 
                        }
                    } while(!input.equalsIgnoreCase("no"));  
                    
                    totalBricks = CalcTotalBricks(wallArea, voidArea, brickArea);
                    padding = CalcPadding(totalBricks);
                    DisplayBricksNeeded(totalBricks, padding);
                    break;
                    
                case "3":
                    replay = false;
                    System.out.println("Exit");
                    break;
                default:
                    break;
            }
        }while(replay);  
    }    
}
