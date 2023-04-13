package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figureScriptNumber;	//TODO: Add Enum instead of int

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureScriptNumber) {
		this.driverManager = driverManager;
		this.figureScriptNumber = figureScriptNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(figureScriptNumber){
			case 1: {FiguresJoe.figureScript1(driverManager.getCurrentDriver()); break;}
			case 2: {FiguresJoe.figureScript2(driverManager.getCurrentDriver()); break;}
			case 3: {
				ComplexCommand complexCommand =  new ComplexCommand();
				complexCommand.addCommand(new SetPositionCommand(-100, -100));
				complexCommand.addCommand(new OperateToCommand(100, -100));
				complexCommand.addCommand(new OperateToCommand(100, 100));
				complexCommand.addCommand(new OperateToCommand(-100, 100));
				complexCommand.addCommand(new OperateToCommand(-100, -100));
				complexCommand.execute(driverManager.getCurrentDriver());
				break;
			}
			default: break;
		}
	}
}
