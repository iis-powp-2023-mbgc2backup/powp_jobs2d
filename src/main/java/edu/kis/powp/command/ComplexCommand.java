package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commandsList = new ArrayList<>();

    public ComplexCommand(DriverCommand ..._signleCommand){
        for (DriverCommand command: _signleCommand){
            addSingleCommand(command);
        }
    }
    public void addSingleCommand(DriverCommand singleCommand){
        commandsList.add(singleCommand);
    }

    @Override
    public void execute() {
        for(DriverCommand command: commandsList){
            command.execute();
        }
    }
}
