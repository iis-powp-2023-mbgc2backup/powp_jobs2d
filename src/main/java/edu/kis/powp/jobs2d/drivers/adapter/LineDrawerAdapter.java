package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.function.Supplier;

/**
 * driver adapter to drawer with several bugs.
 */
public class LineDrawerAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;
	private final DrawPanelController controller;
	private Supplier<ILine> lineSupplier;

	public LineDrawerAdapter(DrawPanelController controller, Supplier<ILine> lineSupplier) {
		this.controller = controller;
		this.lineSupplier = lineSupplier;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = lineSupplier.get();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		controller.drawLine(line);

		this.startX = x;
		this.startY = y;
	}

	@Override
	public String toString() {
		return "LineDrawerAdapter";
	}
}
