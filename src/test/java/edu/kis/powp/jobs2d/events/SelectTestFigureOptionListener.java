package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.factory.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figureScriptNumber;	//TODO: Add Enum instead of int

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureScriptNumber) {
		this.driverManager = driverManager;
		this.figureScriptNumber = figureScriptNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeFactory shapeFactory = new ShapeFactory(driverManager.getCurrentDriver());
		switch(figureScriptNumber){
			case 1: {FiguresJoe.figureScript1(driverManager.getCurrentDriver()); break;}
			case 2: {FiguresJoe.figureScript2(driverManager.getCurrentDriver()); break;}
			case 3: { shapeFactory.getShape("TRIANGLE").draw(); break; }
			case 4: { shapeFactory.getShape("RECTANGLE").draw(); break; }
			default: break;
		}
	}
}
