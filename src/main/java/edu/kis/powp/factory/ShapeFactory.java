package edu.kis.powp.factory;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ShapeFactory {
    private final Job2dDriver job2dDriver;

    public ShapeFactory(Job2dDriver job2dDriver){
        this.job2dDriver = job2dDriver;
    }
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("TRIANGLE")){
            return new Triangle(this.job2dDriver);

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle(this.job2dDriver);
        }
        return null;
    }
}
