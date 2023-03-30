package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureFactory {

    public static ComplexCommand getRectangleCommand(Job2dDriver job2dDriver)
    {
        Job2dDriver driver = job2dDriver;
        ComplexCommand komendy = new ComplexCommand();
        SetPositionCommand setPositionCommand = new SetPositionCommand(100, 200);

        komendy.addCommand(new SetPositionCommand(0, 0));
        komendy.addCommand(new OperateToCommand(0, 50 ));
        komendy.addCommand(new OperateToCommand(100, 50));
        komendy.addCommand(new OperateToCommand(100, 0 ));
        komendy.addCommand(new OperateToCommand(0, 0 ));

return komendy;
    }
}
