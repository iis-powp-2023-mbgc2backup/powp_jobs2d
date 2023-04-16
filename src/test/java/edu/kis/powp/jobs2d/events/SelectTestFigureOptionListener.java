package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.factory.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.enums.FigureType;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final FigureType figureType;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureType figureType) {
		this.driverManager = driverManager;
		this.figureType = figureType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeFactory shapeFactory = new ShapeFactory(driverManager.getCurrentDriver());
		switch(figureType){
			case FIGURE_JOE_1: {FiguresJoe.figureScript1(driverManager.getCurrentDriver()); break;}
			case FIGURE_JOE_2: {FiguresJoe.figureScript2(driverManager.getCurrentDriver()); break;}
			case FIGURE_TRIANGLE:
			case FIGURE_RECTANGLE: { shapeFactory.getShape(figureType).draw(); break; }
			default: break;
		}
	}
}
