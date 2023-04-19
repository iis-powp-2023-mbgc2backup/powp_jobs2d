package edu.kis.powp.jobs2d.drivers.command;

public class CommandFactory {
    public static ComplexCommand squareSequence(int x, int y, int sl) {
        return rectangleOrSquare(x, y, sl, sl);
    }

    public static ComplexCommand rectangleSequence(int x, int y, int height, int width) {
        return rectangleOrSquare(x, y, height, width);
    }

    private static ComplexCommand rectangleOrSquare(int x, int y, int height, int width) {
        ComplexCommand commandList = new ComplexCommand();

        commandList.addCommand(new SetPositionCommand(x, y));
        commandList.addCommand(new OperateToCommand(x + width, y));
        commandList.addCommand(new OperateToCommand(x + width, y - height));
        commandList.addCommand(new OperateToCommand(x, y - height));
        commandList.addCommand(new OperateToCommand(x, y));

        return commandList;
    }
}