package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.FigureType;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.fabrics.FigureFactory;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final FigureType figureType;

	private final DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureType type) {
		this.driverManager = driverManager;
		this.figureType = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DriverCommand command;
		switch (this.figureType) {
			case FIGURE1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case SQUARE:
				command = FigureFactory.getSquare();
				command.execute(driverManager.getCurrentDriver());
				break;
			case RECTANGLE:
				command = FigureFactory.getRectangle();
				command.execute(driverManager.getCurrentDriver());
				break;
			case TRIANGLE:
				command = FigureFactory.getTriangle();
				command.execute(driverManager.getCurrentDriver());
				break;
		}
	}
}
