package edu.kis.powp.factory;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.enums.FigureType;

public class ShapeFactory {
    private final Job2dDriver job2dDriver;

    public ShapeFactory(Job2dDriver job2dDriver){
        this.job2dDriver = job2dDriver;
    }
    public Shape getShape(FigureType figureType){
        switch(figureType){
            case FIGURE_TRIANGLE: { return new Triangle(this.job2dDriver); }
            case FIGURE_RECTANGLE: { return new Rectangle(this.job2dDriver); }
            default: return null;
        }
    }
}
