package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Constants;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverToAbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

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
		default:
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}

	}
}
