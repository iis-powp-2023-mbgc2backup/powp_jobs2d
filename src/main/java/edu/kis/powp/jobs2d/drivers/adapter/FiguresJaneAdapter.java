package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class FiguresJaneAdapter extends AbstractDriver {

    public FiguresJaneAdapter(int x, int y) {
        super(x, y);
    }

    @Override
    public void operateTo(int i, int i1) {
        FiguresJane.figureScript(this);
    }
}
