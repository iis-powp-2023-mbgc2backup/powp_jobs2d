package edu.kis.powp.jobs2d.commands;

public class OperateToCommand implements DriverCommand{

    private int x = 0, y = 0;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
    }
}
