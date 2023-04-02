package edu.kis.powp.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class CommandTests implements ActionListener {

    private DriverManager driverManager;
	private int figure;

	public CommandTests(DriverManager driverManager, int figure) {
		this.driverManager = driverManager;
		this.figure = figure;
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		if(figure == 1){
			figureScript1(driverManager.getCurrentDriver());
		} else if (figure == 2){
            figureScript2(driverManager.getCurrentDriver());
        } else if (figure == 3){
            figureScript3(driverManager.getCurrentDriver());
        }
	}

    public static void figureScript1(Job2dDriver driver) {
        SetPositionCommand sc1 = new SetPositionCommand(driver, 200, 100);
        OperateToCommand oc1 = new OperateToCommand(driver, -200, 100);
        OperateToCommand oc2 = new OperateToCommand(driver, -200, 0);
        OperateToCommand oc3 = new OperateToCommand(driver, 200, 0);
        OperateToCommand oc4 = new OperateToCommand(driver, 200, 100);
		sc1.execute();
        oc1.execute();
        oc2.execute();
        oc3.execute();
        oc4.execute();
	}

    public static void figureScript2(Job2dDriver driver){
        CommandsFactory factory = new CommandsFactory();
        DriverCommand command = factory.getComplexFigure1(driver);
        command.execute();
    }

    public static void figureScript3(Job2dDriver driver){
        CommandsFactory factory = new CommandsFactory();
        DriverCommand command = factory.getComplexFigure2(driver);
        command.execute();
    }
    
}
