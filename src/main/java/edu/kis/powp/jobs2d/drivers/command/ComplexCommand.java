package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand{
    private ArrayList<DriverCommand> queueCommand;
    public ComplexCommand(){
        queueCommand = new ArrayList<>();
    }
    @Override
    public void execute(Job2dDriver driver){
        for(DriverCommand command : queueCommand){
            command.execute(driver);
        }
    }

    public void addCommand(DriverCommand command){
        queueCommand.add(command);
    }

}
