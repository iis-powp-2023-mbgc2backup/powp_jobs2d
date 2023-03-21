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
public class LineDrawerAdapter implements Job2dDriver{

	private int startX = 0, startY = 0;
        private ILine line;
        
	public LineDrawerAdapter(ILine line) {
		super();
                this.line = line;
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
		this.setPosition(x, y);
		DrawerFeature.getDrawerController().drawLine(line);
	}

	@Override
	public String toString() {
		return "New Driver";
	}
    
}
