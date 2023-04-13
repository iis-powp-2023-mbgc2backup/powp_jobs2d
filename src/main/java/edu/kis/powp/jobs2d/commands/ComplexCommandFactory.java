package edu.kis.powp.jobs2d.commands;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {

    private int startX;
    private int startY;
    private Job2dDriver driver;

    public ComplexCommandFactory(Job2dDriver driver, int x, int y){
        this.driver = driver;
        this.startX = x;
        this.startY = y;
    }

    public ComplexCommand createRectangleCommand(int x, int y){

        List<DriverCommand> commands = new ArrayList<DriverCommand>();

        commands.add( new SetPositionCommand(startX, startY, driver));
        commands.add( new OperateToCommand(startX, startY + y, driver));
        commands.add( new OperateToCommand(startX + x, startY + y, driver));
        commands.add( new OperateToCommand(startX + x, startY, driver));
        commands.add( new OperateToCommand(startX, startY, driver));

        ComplexCommand rectangleCommand = new ComplexCommand(commands);

        return rectangleCommand;
    }

    public ComplexCommand createTriangleCommand(int x, int y){
    	
    	List<DriverCommand> commands = new ArrayList<DriverCommand>();
    	
    	commands.add( new SetPositionCommand(startX, startY, driver));
    	commands.add( new OperateToCommand(startX + x, startY + x, driver));
    	commands.add( new OperateToCommand(startX + y, startY + y, driver));
    	
    	ComplexCommand triangleCommand = new ComplexCommand(commands);
    	
        return triangleCommand;
    }

}
