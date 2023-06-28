package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver {

    public enum LineType {
        BASIC, DOTTED, SPECIAL
    }
    private int startX, startY;
    private final DrawPanelController controller;
    private final LineType lineType;

    public LineDrawerAdapter(DrawPanelController controller, LineType type) {
        this.startX = 0;
        this.startY = 0;
        this.controller = controller;
        this.lineType = type;
    }

    public ILine getLineType() {
        switch (this.lineType) {
            case BASIC:
                return LineFactory.getBasicLine();
            case DOTTED:
                return LineFactory.getDottedLine();
            default:
                return LineFactory.getSpecialLine();
        }
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = getLineType();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        setPosition(x, y);
        this.controller.drawLine(line);
    }

    @Override
    public String toString() {
        return "Line Drawer Adapter";
    }
}
