package edu.kis.powp.jobs2d.commands;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {

    private int startX;
    private int startY;

    public ComplexCommandFactory(int x, int y){
        this.startX = x;
        this.startY = y;
    }

    public ComplexCommand createRectangleCommand(int x, int y, Job2dDriver driver){

        List<DriverCommand> commands = new ArrayList<DriverCommand>();

        commands.add( new SetPositionCommand(startX, startY, driver));
        commands.add( new OperateToCommand(startX, startY + y, driver));
        commands.add( new OperateToCommand(startX + x, startY + y, driver));
        commands.add( new OperateToCommand(startX + x, startY, driver));
        commands.add( new OperateToCommand(startX, startY, driver));

        ComplexCommand rectangleCommand = new ComplexCommand(commands);

        return rectangleCommand;
    }

    public ComplexCommand createTriangleCommand(int x, int y, Job2dDriver driver){
    	
    	List<DriverCommand> commands = new ArrayList<DriverCommand>();
    	
    	commands.add( new SetPositionCommand(startX, startY, driver));
    	commands.add( new OperateToCommand(startX + x, startY, driver));
    	commands.add( new OperateToCommand(startX, startY + y, driver));
    	commands.add( new OperateToCommand(startX, startY, driver));
    	
    	ComplexCommand triangleCommand = new ComplexCommand(commands);
    	
        return triangleCommand;
    }

}
