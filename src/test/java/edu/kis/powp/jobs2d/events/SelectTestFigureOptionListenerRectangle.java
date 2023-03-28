package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.CreateRectangleCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListenerRectangle implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListenerRectangle(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new CreateRectangleCommand(driverManager.getCurrentDriver());
	}
}

