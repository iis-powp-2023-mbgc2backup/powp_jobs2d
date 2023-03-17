package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class LineDrawerAdapter extends Job2dDriverDrawingInterpreter implements Job2dDriver {

    private String name;
    private int lineType;

    public LineDrawerAdapter(DrawPanelController drawPanelController, String name, int lineType) {
        super(drawPanelController);
        this.name = name;
        this.lineType = lineType;
    }
    @Override
    public void operateTo(int x, int y) {
        ILine line;
        switch (lineType)
        {
            case 0:
                line = LineFactory.getBasicLine();
                break;
            case 1:
                line = LineFactory.getDottedLine();
                break;
            case  2:
                line = LineFactory.getSpecialLine();
                break;
            default:
                line = LineFactory.getBasicLine();
        }
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        setPosition(x, y);

        drawPanelController.drawLine(line);
    }

    @Override
    public String toString() {
        return name;
    }
}

