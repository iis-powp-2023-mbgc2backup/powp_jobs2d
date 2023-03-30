package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureFactory {

    public ComplexCommand makeSquare(Job2dDriver driver){
        ComplexCommand commandQueue = new ComplexCommand();

        commandQueue.queueCommand(new SetPositionCommand(0,0));

        commandQueue.queueCommand(new OperateToCommand(0,1));
        commandQueue.queueCommand(new OperateToCommand(1,1));
        commandQueue.queueCommand(new OperateToCommand(1,0));
        commandQueue.queueCommand(new OperateToCommand(0,0));

        return commandQueue;
    }
}
