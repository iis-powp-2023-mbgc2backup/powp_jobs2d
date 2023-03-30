package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class ShapeFactory {

    public static DriverCommand getSquare(Job2dDriver job2dDriver){
        return new ComplexCommand(
            new SetPositionCommand(job2dDriver,0,0),
            new OperateToCommand(job2dDriver,10,0),
            new OperateToCommand(job2dDriver,10,10),
            new OperateToCommand(job2dDriver,0,10),
            new OperateToCommand(job2dDriver,0,0)
        );
    }

    public static DriverCommand getRectangle(Job2dDriver job2dDriver){
        return new ComplexCommand(
            new SetPositionCommand(job2dDriver,0,0),
            new OperateToCommand(job2dDriver,13,0),
            new OperateToCommand(job2dDriver,13,10),
            new OperateToCommand(job2dDriver,0,10),
            new OperateToCommand(job2dDriver,0,0)
        );
    }

    public static DriverCommand getTriangle(Job2dDriver job2dDriver){
        return new ComplexCommand(
            new SetPositionCommand(job2dDriver,0,0),
            new OperateToCommand(job2dDriver,17,0),
            new OperateToCommand(job2dDriver,9,21),
            new OperateToCommand(job2dDriver,0,0)
        );
    }



}
