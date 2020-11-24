package brickproject;

/**
 *
 * @author apulus8050
 */
public class Brick {
    private double _h;      //height inches
    private double _w;      //width  inches
    private double _area;   //sq. inches
    private double _mortarThickness; //inches
    
    //Constructors
    public Brick() {
        _h = 0;
        _w = 0;
    }
    public Brick(double h, double w, double mortarThickness) {
        _h = h;
        _w = w;
        _mortarThickness = mortarThickness;
    }
    
    //set and get heights
    public void setHeight(double newHeight) {
        _h = newHeight;
    }
    public double getHeight() {
        return _h;
    }
    
    //set and get width
    public void setWidth(double newWidth) {
        _w = newWidth;
    }
    public double getWidth() {
        return _w;
    }
    
    //set and get mortar thickness
    public void setMortarThickness(double newThickness) {
        _mortarThickness = newThickness / 2;
    }
    public double getMortarThickness() {
        return _mortarThickness;
    }
    
    public double getArea() {
        _area = (_w + _mortarThickness) * (_h + _mortarThickness);  //width * height
        return _area;
    }
    
    public void getBrickInfo() {
        System.out.println("\nBrick Info"
                + "\nHeight: " + this.getHeight() + " inches"
                + "\nWidth: " + this.getWidth() + " inches");
    }
}
