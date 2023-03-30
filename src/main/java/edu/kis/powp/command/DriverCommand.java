package edu.kis.powp.command;

public interface DriverCommand {
    void execute();
}

class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;
    @Override
    public void execute() {

    }
}

class OperateToCommand implements DriverCommand {
    private int x;
    private int y;
    @Override
    public void execute() {

    }
}