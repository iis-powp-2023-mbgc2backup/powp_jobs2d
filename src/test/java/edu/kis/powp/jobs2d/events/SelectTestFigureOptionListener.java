package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.CommandFactory;
import edu.kis.powp.jobs2d.command.SmallSquareFactory;
import edu.kis.powp.jobs2d.command.SquareFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {
	public final String FIGURE1 = "1";
	public final String FIGURE2 = "2";
	public final String FIGURE3 = "3";
	public final String FIGURE4 = "4";
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
		if (command.contains(FIGURE1)){
			FiguresJoe.figureScript1(currDriver);
		}else if (command.contains(FIGURE2)){
			FiguresJoe.figureScript2(currDriver);
		}else if (command.contains(FIGURE3)){
			square.createCommand().execute(currDriver);
		}else if (command.contains(FIGURE4)){
			smallSquare.createCommand().execute(currDriver);

		}


	}
}
