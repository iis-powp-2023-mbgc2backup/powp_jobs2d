package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class CommandFactory {
    private DriverManager driverManager;
    private int x;
    private int y;

    public CommandFactory(DriverManager driverManager, int x, int y) {
        this.driverManager = driverManager;
        this.x = x;
        this.y = y;
    }

    public ComplexCommand createRectangle(int x1, int y1) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x, y, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x1, y, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x1, y1, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x, y1, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x, y, driverManager.getCurrentDriver()));
        return complexCommand;
    }

    public ComplexCommand createTriangle(int x1, int y1, int x2, int y2) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x, y, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x1, y1, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x2, y2, driverManager.getCurrentDriver()));
        complexCommand.addCommand(new OperateToCommand(x, y, driverManager.getCurrentDriver()));
        return complexCommand;
    }



}
