package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.*;

public class FigureFactory {

    public static DriverCommand getRectangle(Job2dDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(-50, -50,driver));
        complexCommand.addCommand(new OperateToCommand(-50, 50,driver));
        complexCommand.addCommand(new OperateToCommand(50, 50,driver));
        complexCommand.addCommand(new OperateToCommand(50, -50,driver));
        complexCommand.addCommand(new OperateToCommand(-50, -50,driver));
        return complexCommand;
    }

    public static DriverCommand getTriangle(Job2dDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(0, -50,driver));
        complexCommand.addCommand(new OperateToCommand(50, 50,driver));
        complexCommand.addCommand(new OperateToCommand(-50, 50,driver));
        complexCommand.addCommand(new OperateToCommand(0, -50,driver));
        return complexCommand;
    }

    public static DriverCommand getCircle(Job2dDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();
        for(int i=0; i<360; i++) {
            double radians = Math.toRadians(i);
            int a = (int) Math.round(50 * Math.cos(radians));
            int b = (int) Math.round(50 * Math.sin(radians));
            if(i == 0) {
                complexCommand.addCommand(new SetPositionCommand(a, b,driver));
            }
            else {
                complexCommand.addCommand(new OperateToCommand(a, b,driver));
            }
        }
        return complexCommand;
    }
}
