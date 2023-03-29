package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figureScriptNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureScriptNumber) {
		this.driverManager = driverManager;
		this.figureScriptNumber = figureScriptNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(figureScriptNumber){
			case 1: {FiguresJoe.figureScript1(driverManager.getCurrentDriver()); break;}
			case 2: {FiguresJoe.figureScript2(driverManager.getCurrentDriver()); break;}
			default: break;
		}
	}
}
