package brickproject;

/**
 *
 * @author apulus8050
 */
public class Brick {
    private double _h;      //height inches
    private double _w;      //width  inches
    private double _l;      //length inches
    private double _area;   //sq. inches
    private double _mortarThickness; //inches
    
    //Constructors
    public Brick() {
        _h = 0;
        _w = 0;
        _l = 0;
    }
    public Brick(double h, double w, double l, double mortarThickness) {
        _h = h;
        _w = w;
        _l = l;
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
    
    //set and get length
    public void setLength(double newLength) {
        _l = newLength;
    }
    public double getLength() {
        return _l;
    }
    
    //set and get mortar thickness
    public void setMortarThickness(double newThickness) {
        _mortarThickness = newThickness / 2;
    }
    public double getMortarThickness() {
        return _mortarThickness;
    }
    
    public double getArea() {
        _area = (_l + _mortarThickness) * (_h + _mortarThickness);  //length times height
        return _area;
    }
    
    public void getBrickInfo() {
        System.out.println("\nBrick Info"
                + "\nHeight: " + this.getHeight() + " inches"
                + "\nWidth: " + this.getWidth() + " inches"
                + "\nLength: " + this.getLength() + " inches");
    }
}
