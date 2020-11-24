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
public class ConvertMeasurements {
    public static double FeetToInches(double feet) {
        double inches = feet * 12;
        return inches;
    }
    public static double InchesToFeet(double inches) {
        double feet = inches / 12;
        return feet;
    }
}
