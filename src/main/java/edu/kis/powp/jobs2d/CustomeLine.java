package edu.kis.powp.jobs2d;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

import java.awt.*;

public class CustomeLine extends AbstractLine {

    public CustomeLine(Color color, float thickness, boolean dotted)
    {
        super();
        this.color = color;
        this.thickness = thickness;
        this.dotted = dotted;
    }
}
