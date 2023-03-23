package edu.kis.powp.jobs2d.drivers.adapter;


import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {

    private int startX = 0, startY = 0;
    private DrawPanelController drawpanelcontroller;
    private ILine line = LineFactory.getSpecialLine();

    public LineDrawerAdapter(DrawPanelController dpc) {
        super();
        this.drawpanelcontroller = dpc;
    }

    public void setLine(ILine l){
        this.line = l;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        setPosition(x,y);
        drawpanelcontroller.drawLine(line);
    }
}
