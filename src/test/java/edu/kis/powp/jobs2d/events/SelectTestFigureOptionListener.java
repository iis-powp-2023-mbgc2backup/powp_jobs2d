package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriverTestConstants;
import edu.kis.powp.jobs2d.commands.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private ComplexCommandFactory complexCommandFactory;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
		this.complexCommandFactory = new ComplexCommandFactory(0, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case Job2dDriverTestConstants.FIGURE1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case Job2dDriverTestConstants.FIGURE2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case Job2dDriverTestConstants.FIGURE_RECTANGLE:
				this.complexCommandFactory.createRectangleCommand(50, 50, driverManager.getCurrentDriver()).execute();
				break;
			case Job2dDriverTestConstants.FIGURE_TRIANGLE:
				this.complexCommandFactory.createTriangleCommand(50, 50, driverManager.getCurrentDriver()).execute();
				break;
		}
	}
}
