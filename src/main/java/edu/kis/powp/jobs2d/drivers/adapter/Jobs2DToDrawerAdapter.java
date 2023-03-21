package edu.kis.powp.jobs2d.drivers.adapter;

import javax.swing.JPanel;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class Jobs2DToDrawerAdapter extends DrawPanelController implements Job2dDriver {
	private int startX = 0, startY = 0;

	public Jobs2DToDrawerAdapter(JPanel freePanel) {
		//add drawpanelcontroller injection
		super.initialize(freePanel);
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		drawLine(line);
		this.setPosition(x, y);
	}

	@Override
	public String toString() {
		return "BuggyAdapter";
	}
}
