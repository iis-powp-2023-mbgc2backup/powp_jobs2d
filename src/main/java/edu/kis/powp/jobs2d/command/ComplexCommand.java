package edu.kis.powp.jobs2d.command;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commands;
//    Job2dDriver driver;

    public ComplexCommand(List<DriverCommand> commands) {
//    public ComplexCommand(List<DriverCommand> commands, Job2dDriver driver) {
//        this.driver=driver;
        this.commands = commands;
    }


    @Override
    public void execute() {
        for (DriverCommand command : commands) {
            command.execute();
        }
    }

}
