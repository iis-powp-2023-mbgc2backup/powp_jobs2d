package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
    private final DrawPanelController dpc;
    private int startX = 0, startY = 0;
    private Modes mode = Modes.BASIC;

    public LineDrawerAdapter(DrawPanelController dpc) {
        super();
        this.dpc = dpc;
    }


    public Job2dDriver setMode(Modes mode) {
        this.mode = mode;
        return null;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line;

        if (mode == Modes.DOTTED) {
            line = LineFactory.getDottedLine();
        } else if (mode == Modes.SPECIAL) {
            line = LineFactory.getSpecialLine();
        } else {
            line = LineFactory.getBasicLine();
        }
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        this.startX = x;
        this.startY = y;
        dpc.drawLine(line);
    }

    @Override
    public String toString() {
        return "@Q!$!@$!#@$(*#@&Q(%^*#@";
    }
}
