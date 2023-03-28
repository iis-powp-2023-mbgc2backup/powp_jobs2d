package edu.kis.powp.jobs2d.commands;

import com.sun.tools.javac.util.List;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.util.Arrays;

public class Rectangle implements Shape {

    @Override
    public List<DriverCommand> createCommands() {
        SetPositionCommand setPositionCommand = new SetPositionCommand(0, 0);
        setPositionCommand.setDriver(DriverFeature.getDriverManager().getCurrentDriver());

        OperateToCommand operateToCommand1 = new OperateToCommand(10, 0);
        operateToCommand1.setDriver(DriverFeature.getDriverManager().getCurrentDriver());

        OperateToCommand operateToCommand2 = new OperateToCommand(10, 10);
        operateToCommand2.setDriver(DriverFeature.getDriverManager().getCurrentDriver());

        OperateToCommand operateToCommand3 = new OperateToCommand(0, 10);
        operateToCommand3.setDriver(DriverFeature.getDriverManager().getCurrentDriver());

        OperateToCommand operateToCommand4 = new OperateToCommand(0, 0);
        operateToCommand4.setDriver(DriverFeature.getDriverManager().getCurrentDriver());

        return (List<DriverCommand>) Arrays.asList(setPositionCommand, operateToCommand1, operateToCommand2, operateToCommand3, operateToCommand4);
    }
}
