package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {
    public static ComplexCommand getRectangle() {
        List<DriverCommand> driverCommands = new ArrayList<>();
        driverCommands.add(new SetPositionCommand(200, -100));
        driverCommands.add(new OperateToCommand(200, 100));
        driverCommands.add(new OperateToCommand(-200, 100));
        driverCommands.add(new OperateToCommand(-200, -100));
        driverCommands.add(new OperateToCommand(200, -100));
        return new ComplexCommand(new ArrayList<>(driverCommands));
    }

    public static ComplexCommand getTriangle() {
        List<DriverCommand> driverCommands = new ArrayList<>();
        driverCommands.add(new SetPositionCommand(100, -100));
        driverCommands.add(new OperateToCommand(100, 100));
        driverCommands.add(new OperateToCommand(-100, 100));
        driverCommands.add(new OperateToCommand(100, -100));
        return new ComplexCommand(new ArrayList<>(driverCommands));
    }

    public static ComplexCommand getCircle() {
        List<DriverCommand> driverCommands = new ArrayList<>();
        driverCommands.add(new SetPositionCommand(0, -100));
        for (int i = 0; i < 360; i++) {
            driverCommands.add(new OperateToCommand((int) (0 + 100 * Math.cos(i * Math.PI / 180)), (int) (0 + 100 * Math.sin(i * Math.PI / 180))));
        }
        return new ComplexCommand(new ArrayList<>(driverCommands));
    }
}
