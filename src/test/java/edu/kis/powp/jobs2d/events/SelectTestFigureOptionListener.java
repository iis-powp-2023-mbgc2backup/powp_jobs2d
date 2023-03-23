package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int figureScriptNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureScriptNumber) {
		this.driverManager = driverManager;
		this.figureScriptNumber = figureScriptNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(figureScriptNumber == 1)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else if(figureScriptNumber == 2)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
