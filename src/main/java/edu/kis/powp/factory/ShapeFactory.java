package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import java.util.ArrayList;
import java.util.List;


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

    public static DriverCommand getCircle(Job2dDriver job2dDriver, int centerX, int centerY, int radius) {
        int x = radius;
        int y = 0;
        int decisionOver2 = 1 - x;
    
        List<DriverCommand> commands = new ArrayList<>();
    
        while (y <= x) {
            commands.add(new SetPositionCommand(job2dDriver, centerX + x, centerY + y));
            commands.add(new OperateToCommand(job2dDriver, centerX - x, centerY + y));
            commands.add(new OperateToCommand(job2dDriver, centerX + x, centerY - y));
            commands.add(new OperateToCommand(job2dDriver, centerX - x, centerY - y));
            commands.add(new SetPositionCommand(job2dDriver, centerX + y, centerY + x));
            commands.add(new OperateToCommand(job2dDriver, centerX - y, centerY + x));
            commands.add(new OperateToCommand(job2dDriver, centerX + y, centerY - x));
            commands.add(new OperateToCommand(job2dDriver, centerX - y, centerY - x));
    
            y++;
            if (decisionOver2 <= 0) {
                decisionOver2 += 2 * y + 1;
            } else {
                x--;
                decisionOver2 += 2 * (y - x) + 1;
            }
        }
    
        return new ComplexCommand(commands.toArray(new DriverCommand[0]));
    }



}
