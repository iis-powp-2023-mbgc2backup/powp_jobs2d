package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;


public class LineDrawerAdapter implements Job2dDriver {

	public enum Line {
		BASIC, DOTTED, SPECIAL
	}

	private int startX = 0, startY = 0;
	private final DrawPanelController controller;
	private Line lineType = Line.SPECIAL;

	public LineDrawerAdapter(DrawPanelController controller){
		this.controller = controller;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	public void setLineType(Line lineType) {
		this.lineType = lineType;
	}

	public ILine getLineType() {
		switch (lineType) {
			case BASIC:
				return LineFactory.getBasicLine();
			case DOTTED:
				return LineFactory.getDottedLine();
			case SPECIAL:
				return LineFactory.getSpecialLine();
		}
		return LineFactory.getBasicLine();
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = getLineType();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		setPosition(x, y);
		controller.drawLine(line);
	}

	@Override
	public String toString() {
		return "Line Drawer Adapter Driver";
	}
}
