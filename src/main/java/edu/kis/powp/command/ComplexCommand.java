package edu.kis.powp.command;
import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    private List<DriverCommand> commandList = new ArrayList<>();

    public int addCommand(DriverCommand command){
        commandList.add(command);
        return 0;
    }
    @Override
    public int execute() {
        for(int i=0;i<commandList.size();i++){
            commandList.get(i).execute();
        }
        return 0;
    }
}
