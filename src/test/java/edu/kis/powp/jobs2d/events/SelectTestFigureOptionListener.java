package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.CommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int testNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager,int testNumber) {
		this.driverManager = driverManager;
		this.testNumber = testNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (testNumber){
			case 1: {
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			}
			case 2: {
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			}
			case 3: {
				CommandFactory commandFactory = new CommandFactory(driverManager,0,0);
				commandFactory.createRectangle(150,100).execute();
				break;
			}
			case 4: {
				CommandFactory commandFactory = new CommandFactory(driverManager,0,0);
				commandFactory.createTriangle(100,50,50,100).execute();
				break;
			}
			default: {
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			}
		}

	}
}
