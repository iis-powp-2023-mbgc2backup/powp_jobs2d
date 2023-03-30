package edu.kis.powp.jobs2d.command;

public class CommandFactory {
    public static ComplexCommand getSquareCommandSequence(int x, int y, int sideLength) {
        ComplexCommand commandList = new ComplexCommand();

        commandList.addCommand(new SetPositionCommand(x, y));
        commandList.addCommand(new OperateToCommand(x + sideLength, y));
        commandList.addCommand(new OperateToCommand(x + sideLength, y + sideLength));
        commandList.addCommand(new OperateToCommand(x - sideLength, y + sideLength));
        commandList.addCommand(new OperateToCommand(x, y));

        return commandList;
    }
}
