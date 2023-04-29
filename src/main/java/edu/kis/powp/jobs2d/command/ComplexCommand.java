package edu.kis.powp.jobs2d.command;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commands = new ArrayList<> ();

    public void add(DriverCommand command) {
        commands.add(command);
    }
    public void remove(DriverCommand command) {
        commands.remove(command);
    }
    public List<DriverCommand> getCommands() {
        return commands;
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : commands) {
            command.execute(driver);
        }
    }

}
