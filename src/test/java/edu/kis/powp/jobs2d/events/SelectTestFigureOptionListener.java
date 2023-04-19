package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("Figure Joe 1")){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}else if(action.equals("Figure Joe 2")){
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}else if(action.equals("SQUARE")){
			ComplexCommandFactory factory = new ComplexCommandFactory(driverManager.getCurrentDriver(),0,0);
			ComplexCommand squareFigure = factory.createRectangle(120,120);
			squareFigure.execute();

		}else if(action.equals("TRIANGLE")){

			ComplexCommandFactory factory = new ComplexCommandFactory(driverManager.getCurrentDriver(),0,0);
			ComplexCommand squareFigure = factory.createTriangle(120,120);
			squareFigure.execute();
		}
	}
}
