package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	public enum TestCase{
		FIGURE1, FIGURE2
	}

	private final DriverManager driverManager;
	private final TestCase testCase;

	public SelectTestFigureOptionListener(DriverManager driverManager, TestCase testCase) {
		this.driverManager = driverManager;
		this.testCase = testCase;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Job2dDriver currDriver = driverManager.getCurrentDriver();
		switch (this.testCase) {
			case FIGURE1:
				FiguresJoe.figureScript1(currDriver);
				break;
			case FIGURE2:
				FiguresJoe.figureScript2(currDriver);
				break;
		}
	}

}
