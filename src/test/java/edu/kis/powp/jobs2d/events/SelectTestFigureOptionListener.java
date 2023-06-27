package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.fabrics.FigureFactory;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DriverCommand command;
		switch (e.getActionCommand()) {
			case "Figure Joe 1":
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case "Figure Joe 2":
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case "Figure Square":
				command = FigureFactory.getSquare();
				command.execute(driverManager.getCurrentDriver());
				break;
			case "Figure Rectangle":
				command = FigureFactory.getRectangle();
				command.execute(driverManager.getCurrentDriver());
				break;
			case "Figure Triangle":
				command = FigureFactory.getTriangle();
				command.execute(driverManager.getCurrentDriver());
				break;
		}
	}
}
