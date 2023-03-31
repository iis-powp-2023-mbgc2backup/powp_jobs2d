package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Constants;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverToAbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.commands.ComplexCommandFactory;
import edu.kis.powp.jobs2d.ComplexCommandFromJob2dDriverBuilder;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverToCommandAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem pressed = (JMenuItem) e.getSource();
		String action = pressed.getText();
		switch (action)
		{
		case Constants.figure1:
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
			break;
		case Constants.figure2:
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
			break;
		case Constants.figureJane:
			FiguresJane.figureScript(new Job2dDriverToAbstractDriverAdapter(driverManager.getCurrentDriver()));
			break;
		case Constants.figureSquare:
			ComplexCommandFactory.getSquareCommand().execute(driverManager.getCurrentDriver());
			break;
		case Constants.figureTriangle:
			ComplexCommandFactory.getTriangleCommand().execute(driverManager.getCurrentDriver());
			break;
		case Constants.figure1Commands:
			Job2dDriverToCommandAdapter commandAdapter = new Job2dDriverToCommandAdapter(driverManager.getCurrentDriver());
			FiguresJoe.figureScript1(commandAdapter);
			break;
		case Constants.figure2Commands:
			ComplexCommandFromJob2dDriverBuilder commandBuilder = new ComplexCommandFromJob2dDriverBuilder();
			FiguresJoe.figureScript2(commandBuilder);
			commandBuilder.withdrawComplexCommand().execute(driverManager.getCurrentDriver());
			break;

		default:
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}

	}
}
