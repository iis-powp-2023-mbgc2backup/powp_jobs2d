package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commands = new ArrayList<DriverCommand>();

    public void addCommand(DriverCommand driverCommand){
        commands.add(driverCommand);
    }

    @Override
    public void execute(Job2dDriver job2dDriver) {
        for(DriverCommand command : commands){
            command.execute(job2dDriver);
        }
    }
}
