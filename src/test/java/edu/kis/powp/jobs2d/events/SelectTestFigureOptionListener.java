package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private final FIGURE_JOE_1 = "Figure Joe 1";
	private final FIGURE_JOE_2 = "Figure Joe 2";

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case FIGURE_JOE_1 -> FiguresJoe.figureScript1(driverManager.getCurrentDriver());
			case FIGURE_JOE_2 -> FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
	}
}
