package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.CreateRectangleCommand;
import edu.kis.powp.command.CreateTriangleCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListenerTriangle implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListenerTriangle(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new CreateTriangleCommand(driverManager.getCurrentDriver()).draw();
	}
}

