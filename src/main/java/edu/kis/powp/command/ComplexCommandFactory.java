package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {
    public static ComplexCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        DriverCommand[] commands = new DriverCommand[4];
        commands[0] = new SetPositionCommand(driver, x, y);
        commands[1] = new OperateToCommand(driver, x + width, y);
        commands[2] = new OperateToCommand(driver, x + width, y + height);
        commands[3] = new OperateToCommand(driver, x, y + height);
        return new ComplexCommand(commands);
    }

    public static ComplexCommand createTriangle(Job2dDriver driver, int x, int y, int width, int height) {
        DriverCommand[] commands = new DriverCommand[3];
        commands[0] = new SetPositionCommand(driver, x, y);
        commands[1] = new OperateToCommand(driver, x + width, y);
        commands[2] = new OperateToCommand(driver, x + width / 2, y + height);
        return new ComplexCommand(commands);
    }
}
