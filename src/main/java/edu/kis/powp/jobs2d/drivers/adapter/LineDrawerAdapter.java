package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter extends DrawerFeature implements Job2dDriver {
    private int startX;
    private int startY;
    private LineType lineType;
    public enum LineType {
        BASIC,
        DOTTED,
        SPECIAL
    }

    public LineDrawerAdapter(LineType lineType) {
        super();
        this.lineType = lineType;
    }

    public LineDrawerAdapter() {
        super();
        this.lineType = LineType.BASIC;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = getLine();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        this.setPosition(x, y);
        DrawerFeature.getDrawerController().drawLine(line);
    }

    @Override
    public String toString() {
        return "Line Drawer Adapter simulator";
    }

    private ILine getLine() {
        if(this.lineType == LineType.BASIC)
            return LineFactory.getBasicLine();
        else if(this.lineType == LineType.DOTTED)
            return LineFactory.getDottedLine();
        else
            return LineFactory.getSpecialLine();
    }

    public void setLineType(LineType lineType) {
        this.lineType = lineType;
    }
}
