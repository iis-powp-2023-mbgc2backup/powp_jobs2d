package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.awt.Color;

import edu.kis.legacy.drawer.panel.DrawPanelController;

public class LineDrawerAdapter implements Job2dDriver {

	private int startX =0, startY = 0;
	private ILine line;
	private final DrawPanelController dpc;
	
	public LineDrawerAdapter(ILine line, DrawPanelController dpc) {
		this.line = line;
		this.dpc = dpc;
	}
	
	
    @Override
    public void setPosition(int x, int y) {
    	this.startX = x;
    	this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
    	line.setStartCoordinates(startX, startY);
    	line.setEndCoordinates(x, y);
    	
    	setPosition(x, y);
    	
    	dpc.drawLine(line);
    }
    
    @Override
    public String toString() {
    	if(line.getColor() == Color.CYAN) return "Special Line Drawer";
    	else if(line.isDotted() == true) return "Dotted Line Drawer";
    	else return "Basic Line Drawer";
    }
}
