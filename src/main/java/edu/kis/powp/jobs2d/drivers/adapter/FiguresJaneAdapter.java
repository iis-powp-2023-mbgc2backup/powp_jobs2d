package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiguresJaneAdapter extends AbstractDriver implements ActionListener {

    DrawPanelController dpc;

    public FiguresJaneAdapter(int x, int y,DrawPanelController dpc) {
        super(x, y);
        this.dpc=dpc;
    }

    @Override
    public void operateTo(int i, int i1) {
        ILine line = LineFactory.getBasicLine();
        line.setStartCoordinates(getX(), getY());
        line.setEndCoordinates(i, i1);
        setPosition(i,i1);
        dpc.drawLine(line);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        FiguresJane.figureScript(this);
    }
}
