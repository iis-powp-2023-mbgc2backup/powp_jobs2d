package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.lines.EditableLine;

import java.awt.*;

/**
 * driver adapter to drawer with editable parameters
 */
public class DriverToDrawerEditableLineAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;
	private DrawPanelController drawPanelController;

	public DriverToDrawerEditableLineAdapter(DrawPanelController drawPanelController) {
		super();
		this.drawPanelController = drawPanelController;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = new EditableLine();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		this.drawPanelController.drawLine(line);
		setPosition(x, y);
	}

	public void operateTo(int x, int y, Color color, float thickness, boolean dotted) {
		ILine line = new EditableLine(color, thickness, dotted);
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		this.drawPanelController.drawLine(line);
		setPosition(x, y);
	}

	@Override
	public String toString() {
		return "Editable line";
	}
}
