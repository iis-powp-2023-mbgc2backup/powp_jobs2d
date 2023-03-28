package edu.kis.powp.jobs2d.drivers.adapter;


import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;



public class LineDrawerAdapter extends DriverAdapterToDrawer implements Job2dDriver {
    private int startX = 0, startY = 0;
    private ILine line;
    private DrawPanelController drawPanelController;
    public LineDrawerAdapter(ILine iline, DrawPanelController drawer) {
        super();
        this.line = iline;
        drawPanelController =  drawer;
    }
    @Override
    public void setPosition(int x0, int y0) {
        startX = x0;
        startY = y0;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        drawPanelController.drawLine(line);
        setPosition(x,y);
    }

    @Override
    public String toString() {
        return "New driver";
    }
}
