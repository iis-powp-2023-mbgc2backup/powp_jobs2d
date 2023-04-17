package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class DrawerAdapter extends DrawPanelController implements Job2dDriver {
	int startX = 0;
	int startY = 0;
	DrawPanelController drawPanelController;

	ILine line;

	public DrawerAdapter(DrawPanelController drawPanelController) {
		super();
		this.drawPanelController = drawPanelController;
		this.line = LineFactory.getBasicLine();
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

		this.startX = x;
		this.startY = y;

		this.drawPanelController.drawLine(line);
	}

	@Override
	public String toString() {
		return "RYSOWANKO :)";
	}
}
