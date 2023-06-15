package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
	private int startX = 0, startY = 0;

	private DrawPanelController drawPanelController;
	private ILine line;
	public LineDrawerAdapter(DrawPanelController drawPanelController, ILine line) {
		this.line=line;
		this.drawPanelController=drawPanelController;


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
		drawPanelController.drawLine(line);
	}

	@Override
	public String toString() {
		return "LineDrawerAdapter";
	}
}
