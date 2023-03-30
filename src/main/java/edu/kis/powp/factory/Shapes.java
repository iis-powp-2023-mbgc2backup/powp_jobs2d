package edu.kis.powp.factory;

public enum Shapes {

    SQUARE("square"),
    CIRCLE("circle"),
    TRIANGLE("triangle"),
    RECTANGLE("rectangle");

    public final String shapeName;

    Shapes(String shapeName){
        this.shapeName = shapeName;
    }

}
