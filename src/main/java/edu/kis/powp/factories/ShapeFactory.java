package edu.kis.powp.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;

import java.util.ArrayList;

public class ShapeFactory {
    public static ComplexCommand getSquare() {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(0, 100));
        commands.add(new OperateToCommand(100, 100));
        commands.add(new OperateToCommand(100, 0));
        commands.add(new OperateToCommand(0, 0));
        return new ComplexCommand(commands);
    }

    public static ComplexCommand getTriangle() {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(0, 100));
        commands.add(new OperateToCommand(100, 0));
        commands.add(new OperateToCommand(0, 0));
        return new ComplexCommand(commands);
    }

    public static ComplexCommand getCircle(int radius){
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, radius));
        for (int i = 1; i < 360; i++) {
            commands.add(new OperateToCommand((int) (radius * Math.cos(i * Math.PI / 180)), (int) (radius * Math.sin(i * Math.PI / 180))));
        }
        return new ComplexCommand(commands);
    }
}
