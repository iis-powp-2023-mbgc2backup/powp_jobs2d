package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.*;

public class ComplexCommand implements DriverCommand{

    private final List<DriverCommand> commands = new ArrayList<>();

    public void queueCommand(DriverCommand newCommand){
        commands.add(newCommand);
    }

    public void execute(Job2dDriver driver) {
        for (DriverCommand simpleCommand: commands){
            simpleCommand.execute(driver);
        }
    }
}
