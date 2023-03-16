package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 * driver adapter to drawer with several bugs.
 */
public class DrawerAdapter extends DrawPanelController implements Job2dDriver {
	private int startX = 0, startY = 0;
	private String drawerType;
	public DrawerAdapter(String drawerType) {
		super();
		this.drawerType = drawerType;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {

		ILine line;
		switch (drawerType){
			case "Buggy":
				line = LineFactory.getBasicLine();
				break;
			case "Dotted":
				line = LineFactory.getDottedLine();
				break;
			case "Special":
				line = LineFactory.getSpecialLine();
				break;
			default:
				line = LineFactory.getBasicLine();
		}

		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		setPosition(x, y);
		DrawerFeature.getDrawerController().drawLine(line);
	}

	@Override
	public String toString() {
		return "@Q!$!@$!#@$(*#@&Q(%^*#@";
	}
}
