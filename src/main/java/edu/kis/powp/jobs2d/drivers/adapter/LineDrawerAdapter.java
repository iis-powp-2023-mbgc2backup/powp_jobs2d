package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;
    private final ILine line;

    public LineDrawerAdapter(DrawPanelController drawPanelController, ILine line) {
        this.drawPanelController = drawPanelController;
        this.line = line;
    }

    @Override
    public void setPosition(int i, int i1) {
        this.startX = i;
        this.startY = i1;
    }

    @Override
    public void operateTo(int i, int i1) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(i, i1);

        setPosition(i, i1);

        drawPanelController.drawLine(line);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter";
    }
}
