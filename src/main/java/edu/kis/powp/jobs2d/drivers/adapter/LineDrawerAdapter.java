package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
    private int startX = 0, startY = 0;

    private ILine currentLine;

    private final DrawPanelController dpc;

    public LineDrawerAdapter(DrawPanelController dpc) {
        super();
        this.currentLine = LineFactory.getBasicLine();
        this.dpc=dpc;
    }

    public void setCurrentLine(ILine currentLine) {
        this.currentLine = currentLine;
    }


    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        currentLine.setStartCoordinates(this.startX, this.startY);
        currentLine.setEndCoordinates(x, y);
        setPosition(x,y);
        drawLine(currentLine);
        dpc.drawLine(currentLine);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter";
    }
}
