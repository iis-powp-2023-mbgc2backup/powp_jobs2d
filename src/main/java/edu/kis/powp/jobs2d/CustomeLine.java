package edu.kis.powp.jobs2d;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

import java.awt.*;

public class CustomeLine extends AbstractLine {

    public CustomeLine()
    {
        super();
        this.color = Color.black;
        this.thickness = 3;
        this.dotted = false;
    }

    public void setColor( Color color) {
        this.color = color;
    }

    public void setDotted( boolean isDotted) {
        this.dotted = isDotted;
    }

    public void setThick( float thick) {
        this.thickness = thick;
    }

}
