package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Figure Joe 1" -> FiguresJoe.figureScript1(driverManager.getCurrentDriver());
			case "Figure Joe 2" -> FiguresJoe.figureScript2(driverManager.getCurrentDriver());
			case "My test" -> {
				ComplexCommand complexCommand = new ComplexCommand();
				complexCommand.addCommand(new SetPositionCommand(120, 120, driverManager.getCurrentDriver()));
				complexCommand.addCommand(new OperateToCommand(-120, 120, driverManager.getCurrentDriver()));
				complexCommand.addCommand(new OperateToCommand(-120, -120, driverManager.getCurrentDriver()));
				complexCommand.addCommand(new OperateToCommand(120, -120, driverManager.getCurrentDriver()));
				complexCommand.addCommand(new OperateToCommand(120, 120, driverManager.getCurrentDriver()));
				complexCommand.execute();
			}
		}
	}
}
