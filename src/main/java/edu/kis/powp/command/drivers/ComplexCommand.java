package edu.kis.powp.command.drivers;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> driverCommands = new ArrayList<>();

    public ComplexCommand(List<DriverCommand> driverCommands){
        this.driverCommands = driverCommands;
    }

    public void addCommand(DriverCommand driverCommand){
        driverCommands.add(driverCommand);
    }

    @Override
    public void execute() {
        for(DriverCommand command : driverCommands){
            command.execute();
        }
    }
}
