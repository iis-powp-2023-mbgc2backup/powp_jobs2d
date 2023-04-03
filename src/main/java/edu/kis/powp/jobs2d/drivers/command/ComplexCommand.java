package edu.kis.powp.jobs2d.drivers.command;
import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    private List<DriverCommand> commands;

    public ComplexCommand() {
        this.commands = new ArrayList<>();
    }

    public ComplexCommand(List<DriverCommand> commands) {
        this.commands = commands;
    }

    public void append(DriverCommand com)
    {
        this.commands.add(com);
    }

    @Override
    public void execute() {
        for(DriverCommand command:commands)
        {
            command.execute();
        }
    }
}
