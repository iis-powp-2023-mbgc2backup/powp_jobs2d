package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {
    public static ComplexCommand getRectangle(int x, int y, int width, int height) {
        List<DriverCommand> driverCommands = new ArrayList<>();
        driverCommands.add(new SetPositionCommand(x, y));
        driverCommands.add(new OperateToCommand(x + width, y));
        driverCommands.add(new OperateToCommand(x + width, y + height));
        driverCommands.add(new OperateToCommand(x, y + height));
        driverCommands.add(new OperateToCommand(x, y));
        return new ComplexCommand(new ArrayList<>(driverCommands));
    }

    public static ComplexCommand getTriangle(int x, int y, int width, int height) {
        List<DriverCommand> driverCommands = new ArrayList<>();
        driverCommands.add(new SetPositionCommand(x, y));
        driverCommands.add(new OperateToCommand(x + width, y));
        driverCommands.add(new OperateToCommand(x + width / 2, y + height));
        driverCommands.add(new OperateToCommand(x, y));
        return new ComplexCommand(new ArrayList<>(driverCommands));
    }

    public static ComplexCommand getCircle(int x, int y, int radius) {
        List<DriverCommand> driverCommands = new ArrayList<>();
        driverCommands.add(new SetPositionCommand(x, y - radius));
        for (int i = 0; i < 360; i++) {
            driverCommands.add(new OperateToCommand((int) (x + radius * Math.cos(i * Math.PI / 180)), (int) (y + radius * Math.sin(i * Math.PI / 180))));
        }
        return new ComplexCommand(new ArrayList<>(driverCommands));
    }
}
