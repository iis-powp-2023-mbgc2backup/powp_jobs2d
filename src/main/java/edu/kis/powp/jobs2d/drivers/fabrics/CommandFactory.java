package edu.kis.powp.jobs2d.drivers.fabrics;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

public class CommandFactory {

    public ComplexCommand makeTriangle(Job2dDriver driver) {
        ComplexCommand commandQueue = new ComplexCommand();

        commandQueue.addCommand(new SetPositionCommand(0, 0));
        commandQueue.addCommand(new SetPositionCommand(2, 0));
        commandQueue.addCommand(new SetPositionCommand(1, 2));
        commandQueue.addCommand(new SetPositionCommand(0, 0));

        return commandQueue;
    }
}
