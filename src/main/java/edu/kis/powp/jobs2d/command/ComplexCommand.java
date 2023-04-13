package edu.kis.powp.jobs2d.command;

import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commands;

    public ComplexCommand(List<DriverCommand> commands)
    {
        this.commands=commands;
    }

    public void addCommand(DriverCommand comm)
    {
        this.commands.add(comm);
    }
    @Override
    public void execute()
    {
            for(DriverCommand command:commands)
            {
                command.execute();
            }
    }
}
