package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commands = new ArrayList<>();
    public void addCommand(DriverCommand c){
        commands.add(c);
    }
    public void delLastCommand(){
        commands.remove(commands.size()-1);
    }
    @Override
    public void execute() {
        for (DriverCommand command:commands) {
            command.execute();
        }
    }
}
