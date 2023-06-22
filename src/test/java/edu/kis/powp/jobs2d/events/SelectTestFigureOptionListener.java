package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Constants;
import edu.kis.powp.jobs2d.command.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import javax.swing.*;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int figureIndex;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureIn) {
		this.driverManager = driverManager;
		this.figureIndex = figureIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem pressed = (JMenuItem) e.getSource();
		String action = pressed.getText();
		switch (action){
			case Constants.figureSquare:
				ComplexCommandFactory complexCommandFactory1 = new ComplexCommandFactory(driverManager.getCurrentDriver());
				complexCommandFactory1.createRectangle(0,0);
				break;
			case Constants.figureTriangle:
				ComplexCommandFactory complexCommandFactory2 = new ComplexCommandFactory(driverManager.getCurrentDriver());
				complexCommandFactory2.createTriangle(0,0);
				break;
			case Constants.figure1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case Constants.figure2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
		}

	}
}
