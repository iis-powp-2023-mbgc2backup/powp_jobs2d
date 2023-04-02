package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
    
	private int startX = 0, startY = 0;

	private final DrawPanelController dpc;
	private final int lineType;

	public LineDrawerAdapter(DrawPanelController dpc, int lineType) {
		super();
		this.dpc = dpc;
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
		if(lineType == 1){
			line = LineFactory.getBasicLine();
		}
		else if(lineType == 2){
			line = LineFactory.getDottedLine();
		} else{
			line = LineFactory.getSpecialLine();
		}
		
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		dpc.drawLine(line);
		this.setPosition(x, y);
	}

	@Override
	public String toString() {
		return "LineDrawerAdapter";
	}
}
