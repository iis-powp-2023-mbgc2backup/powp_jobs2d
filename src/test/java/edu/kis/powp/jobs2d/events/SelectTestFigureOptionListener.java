package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.CustomeLine;
import edu.kis.powp.jobs2d.TestFigureType;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final TestFigureType testFigureType;

	public SelectTestFigureOptionListener(DriverManager driverManager, TestFigureType testFigureType) {
		this.driverManager = driverManager;
		this.testFigureType = testFigureType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (testFigureType){

			case FIGURE_JOE_1: {
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			}
			case FIGURE_JOE_2: {
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			}
			case FIGURE_JANE: {
				FiguresJane.figureScript(new AbstractDriverAdapter(0,0));
				break;
			}
			default:
				break;

		}


	}
}
