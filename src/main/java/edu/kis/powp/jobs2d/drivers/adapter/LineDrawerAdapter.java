/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 *
 * @author student
 */
public class LineDrawerAdapter extends DrawerFeature implements Job2dDriver {
    private int startX = 0, startY = 0;
    private LineType lineType;

    public LineDrawerAdapter(LineType lineType) {
        super();
        this.lineType = lineType;
    }
    
    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line;
        switch (lineType) {
            case DOTTED:
                line = LineFactory.getDottedLine();
                break;
            case SPECIAL:
                line = LineFactory.getSpecialLine();
                break;
            default:
                line = LineFactory.getBasicLine();
                break;
        }
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        setPosition(x, y);
        DrawerFeature.getDrawerController().drawLine(line);
    }
    
}
