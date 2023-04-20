package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.CustomeLine;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class DrawerAdapterToDriver implements Job2dDriver {
	private int startX = 0;
	private int startY = 0;
	private final DrawPanelController drawPanelController;

	private final ILine line;

	public DrawerAdapterToDriver(DrawPanelController drawPanelController) {
		super();
		this.drawPanelController = drawPanelController;
		this.line = LineFactory.getBasicLine();
	}

	public DrawerAdapterToDriver(DrawPanelController drawPanelController, CustomeLine customeLine ) {
		super();
		this.line = customeLine;
		this.drawPanelController = drawPanelController;
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
		this.drawPanelController.drawLine(line);
	}

	@Override
	public String toString() {
		return "RYSOWANKO :)";
	}
}
