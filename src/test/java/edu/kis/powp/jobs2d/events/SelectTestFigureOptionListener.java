package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int actionID;

	public SelectTestFigureOptionListener(DriverManager driverManager, int actionID) {
		this.driverManager = driverManager;
		this.actionID = actionID;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(actionID == 1) FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		if(actionID == 2) FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
