package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
	public enum Figure {
		FIGURE1,
		FIGURE2,
		FIGURE3
	}
	public Figure figure;
	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if (command.contains("1")){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}else if (command.contains("2")){
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}


	}
}
