package brickproject;

/**
 *
 * @author apulus8050
 */
public class CircleVoid {
    private double _radius;
    
    public CircleVoid() {
        _radius = 0;
    }
    
    public CircleVoid(double newRadius) {
        _radius = newRadius;
    }
    
    public void setRadius(double newRadius) {
        _radius = newRadius;
    }
    
    public double getRadius() {
        return _radius;
    }
    
    public double getArea() {
        return Math.PI * Math.pow(_radius, 2);
    }
    
}
