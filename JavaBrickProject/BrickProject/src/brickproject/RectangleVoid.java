/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickproject;

/**
 *
 * @author apulus8050
 */
public class RectangleVoid {
    
    private double _h;
    private double _w;
    
    public RectangleVoid() {
        _h = 0;
        _w = 0;
    }
    
    public RectangleVoid(double height, double width) {
        _h = height;
        _w = width;
    }
    
    public void setHeight(double height) {
        _h = height;
    }
    public double getHeight() {
        return _h;
    }
    
    public void setWidth(double width) {
        _w = width;
    }
    public double getWidth() {
        return _w;
    }
    
    public double getArea() {
        return _w * _h;
    }
    
}
