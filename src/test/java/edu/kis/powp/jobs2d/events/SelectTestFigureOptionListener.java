package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.TestJobs2dPatterns;
import edu.kis.powp.jobs2d.command.CommandFactory;
import edu.kis.powp.jobs2d.command.SmallSquareFactory;
import edu.kis.powp.jobs2d.command.SquareFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		CommandFactory square = new SquareFactory();
		CommandFactory smallSquare = new SmallSquareFactory();
		Job2dDriver currDriver=driverManager.getCurrentDriver();
		switch (command) {
			case "Figure 1":
				FiguresJoe.figureScript1(currDriver);
				break;
			case "Figure 2":
				FiguresJoe.figureScript2(currDriver);
				break;
			case "Figure 3":
				square.createCommand().execute(currDriver);
				break;
			case "Figure 4":
				smallSquare.createCommand().execute(currDriver);
				break;
		}


	}
}
