package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.awt.*;
import java.util.ArrayList;

public class ComplexCommand implements DriverCommand{
    ArrayList<DriverCommand> commands = new ArrayList<>();

    public void setCommands(ArrayList<DriverCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : commands) {
            command.execute(driver);
        }
    }

}
