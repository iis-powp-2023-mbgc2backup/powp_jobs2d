package edu.kis.powp.jobs2d.command;

public class CommandFactory {
    public static ComplexCommand getSquareCommandSequence(int x, int y, int sideLength) {
        ComplexCommand commandList = new ComplexCommand();

        commandList.addCommand(new SetPositionCommand(x, y));
        commandList.addCommand(new OperateToCommand(x + sideLength, y));
        commandList.addCommand(new OperateToCommand(x + sideLength, y - sideLength));
        commandList.addCommand(new OperateToCommand(x, y - sideLength));
        commandList.addCommand(new OperateToCommand(x, y));

        return commandList;
    }

    public static ComplexCommand getCircleCommandSequence(int centerX, int centerY, int radius) {
        ComplexCommand commandList = new ComplexCommand();

        // calculate radius of circle
        int x = 0, y = radius, u = 0, v = 2 * radius - 1, E = 0;
        while (x < y) {
            commandList.addCommand(new SetPositionCommand(centerX + x, centerY + y));
            commandList.addCommand(new OperateToCommand(centerX + x, centerY + y));
            commandList.addCommand(new SetPositionCommand(centerX + y, centerY - x));
            commandList.addCommand(new OperateToCommand(centerX + y, centerY - x));
            commandList.addCommand(new SetPositionCommand(centerX - x, centerY - y));
            commandList.addCommand(new OperateToCommand(centerX - x, centerY - y));
            commandList.addCommand(new SetPositionCommand(centerX - y, centerY + x));
            commandList.addCommand(new OperateToCommand(centerX - y, centerY + x));
            ++x;
            E += u;
            u += 2;
            if (v < 2 * E) {
                y--; E -= v; v -= 2;
            }
            if (x > y)
                break;

            commandList.addCommand(new SetPositionCommand(centerX + y, centerY + x));
            commandList.addCommand(new OperateToCommand(centerX + y, centerY + x));
            commandList.addCommand(new SetPositionCommand(centerX + x, centerY - y));
            commandList.addCommand(new OperateToCommand(centerX + x, centerY - y));
            commandList.addCommand(new SetPositionCommand(centerX - y, centerY - x));
            commandList.addCommand(new OperateToCommand(centerX - y, centerY - x));
            commandList.addCommand(new SetPositionCommand(centerX - x, centerY + y));
            commandList.addCommand(new OperateToCommand(centerX - x, centerY + y));
        }

        return commandList;
    }
}
