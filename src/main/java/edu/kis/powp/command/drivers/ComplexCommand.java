package edu.kis.powp.command.drivers;

import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> driverCommands;

    public ComplexCommand(List<DriverCommand> driverCommands){
        this.driverCommands = driverCommands;
    }

    @Override
    public void execute() {
        for(DriverCommand command : driverCommands){
            command.execute();
        }
    }
}
