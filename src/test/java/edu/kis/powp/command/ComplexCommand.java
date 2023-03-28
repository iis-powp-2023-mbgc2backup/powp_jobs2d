package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements  DriverCommand{

    private final List<DriverCommand> commandList=new ArrayList<DriverCommand>();


    public void addCommand(DriverCommand command) {
      commandList.add(command);
    }
    @Override
    public void execute() {
        for (DriverCommand com:commandList) {
            com.execute();
        }
    }
}
