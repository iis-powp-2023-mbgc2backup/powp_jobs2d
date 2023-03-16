package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private String name;

	public SelectTestFigureOptionListener(DriverManager driverManager, String name) {
		this.driverManager = driverManager;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.name.contains("1"))
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else	
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
