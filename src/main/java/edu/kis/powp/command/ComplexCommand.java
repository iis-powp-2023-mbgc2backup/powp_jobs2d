package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import java.util.*;

public class ComplexCommand implements DriverCommand{

    public final List<DriverCommand>commands;

    public ComplexCommand() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(DriverCommand command){
        commands.add(command);
    }

    @Override
    public void execute(Job2dDriver driver) {
        for(DriverCommand command: commands){
            command.execute(driver);
        }
    }
}
