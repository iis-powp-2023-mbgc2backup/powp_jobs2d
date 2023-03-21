package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class Job2DriverToDrawerAdapterSpecial extends DrawPanelController implements Job2dDriver {
	private int startX = 0, startY = 0;
	private ILine line;
	DrawPanelController dpc;


	public Job2DriverToDrawerAdapterSpecial(DrawPanelController dpc) {
		super();
		line = LineFactory.getSpecialLine();
		this.dpc=dpc;

	}
	public Job2DriverToDrawerAdapterSpecial(ILine line,DrawPanelController dpc) {
		super();
		this.line=line;
		this.dpc=dpc;

	}


	@Override
	public void drawLine(ILine line) {
		this.dpc.drawLine(line);
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
		drawLine(line);
	}

	public void setLine(ILine line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "Job2DriverToDrawerAdapterSpecial";
	}
}
