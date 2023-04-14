package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommandFactory {
    public static ComplexCommand createTriangle(Job2dDriver driver,int x,int y,int width,int height)
    {
        List<DriverCommand> commmands=new ArrayList<DriverCommand>();
        commmands.add(new SetPositionCommand(driver,x,y));
        commmands.add(new OperateToCommand(driver,x+width,y));
        commmands.add(new OperateToCommand(driver,x,y+height));
        commmands.add(new OperateToCommand(driver,x,y));
        ComplexCommand figure=new ComplexCommand(commmands);
        return figure;
    }
    public static ComplexCommand createRectangle(Job2dDriver driver,int x,int y,int width,int height)
    {
        List<DriverCommand> commmands=new ArrayList<DriverCommand>();
        commmands.add(new SetPositionCommand(driver,x,y));
        commmands.add(new OperateToCommand(driver,x,y+height));
        commmands.add(new OperateToCommand(driver,x+width,y+height));
        commmands.add(new OperateToCommand(driver,x+width,y));
        commmands.add(new OperateToCommand(driver,x,y));
        ComplexCommand figure=new ComplexCommand(commmands);
        return figure;
    }
}
