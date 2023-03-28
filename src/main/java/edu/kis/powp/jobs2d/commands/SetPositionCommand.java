package edu.kis.powp.jobs2d.commands;

public class SetPositionCommand implements DriverCommand{
    private int x = 0, y = 0;

    public SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
    }
}