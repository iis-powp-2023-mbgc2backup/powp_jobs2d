package edu.kis.powp.command;

import java.util.ArrayList;


interface DriverCommand {
    void execute();
}

class SetPositionCommand implements DriverCommand {
    private final int x;
    private final int y;

    @Override
    public void execute() {

    }

    public SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class OperateToCommand implements DriverCommand {
    private final int x;
    private final int y;

    @Override
    public void execute() {

    }

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class ComplexCommand {
    ArrayList<DriverCommand> driverCommands;

    public ComplexCommand() {
        this.driverCommands = new ArrayList<>();
    }
}
