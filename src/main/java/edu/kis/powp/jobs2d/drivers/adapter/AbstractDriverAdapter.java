package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;


public class AbstractDriverAdapter extends AbstractDriver {

    public  AbstractDriverAdapter(int x, int y){
        super(x,y);

    }
    @Override
    public void operateTo(int x, int y) {
        ILine line = LineFactory.getBasicLine();
        line.setStartCoordinates(getX(), getY());
        line.setEndCoordinates(x ,y);
        setPosition(x,y);
        DrawerFeature.getDrawerController().drawLine(line);
    }

    @Override
    public String toString() {
        return "Abstract";
    }
}
