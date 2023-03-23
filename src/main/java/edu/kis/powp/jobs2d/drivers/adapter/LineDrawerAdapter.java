package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {

    private final ILine line;

    public LineDrawerAdapter(ILine line) {
        this.line = line;
    }

    private int startX = 0, startY = 0;

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {

        this.line.setStartCoordinates(this.startX, this.startY);
        this.line.setEndCoordinates(x, y);
        this.startX = x;
        this.startY = y;
        DrawerFeature.getDrawerController().drawLine(this.line);
    }

    @Override
    public String toString() {
        return "Lines Adapter";
    }
}
