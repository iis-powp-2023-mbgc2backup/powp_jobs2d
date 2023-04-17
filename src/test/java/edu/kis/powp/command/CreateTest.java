package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class CreateTest {

    public ArrayList<DriverCommand> triangleScript(Job2dDriver driver) {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0, driver));

        commands.add(new OperateToCommand(200, 0, driver));
        commands.add(new OperateToCommand(100, 100, driver));
        commands.add(new OperateToCommand(0, 0, driver));
        return commands;
    }

    public ArrayList<DriverCommand> squareScript(Job2dDriver driver) {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0, driver));
        commands.add(new OperateToCommand(0, 200, driver));
        commands.add(new OperateToCommand(200, 200, driver));
        commands.add(new OperateToCommand(200, 0, driver));
        commands.add(new OperateToCommand(0, 0, driver));
        return commands;
    }

    public ArrayList<DriverCommand> circleScript(Job2dDriver driver) {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(100, 0, driver));

        for (int i = 0; i <= 100; i++) {
            double angle = 2 * Math.PI * i / 100;
            int x = (int) (0 + 100 * Math.cos(angle));
            int y = (int) (0 + 100 * Math.sin(angle));
            commands.add(new OperateToCommand(x, y, driver));
        }

        return commands;
    }

}
