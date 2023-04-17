package edu.kis.powp.jobs2d.drivers.adapter;


import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.CustomeLine;
import java.awt.*;

public class SepcialDrawerAdapter extends  DrawerAdapter {


    public SepcialDrawerAdapter(DrawPanelController drawPanelController, boolean isDotted , Color color, float thick ) {
        super(drawPanelController);
        this.line = new CustomeLine(color, thick , isDotted );
    }


}
