package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;


interface DriverCommand {
    void execute(Job2dDriver job2dDriver);
}

class SetPositionCommand implements DriverCommand {
    private final int x;
    private final int y;


    public SetPositionCommand(int x, int y, Job2dDriver job2dDriver) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(Job2dDriver job2dDriver) {
        job2dDriver.operateTo(this.x, this.y);
    }
}

class OperateToCommand implements DriverCommand {
    private final int x;
    private final int y;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(Job2dDriver job2dDriver) {
        job2dDriver.operateTo(this.x, this.y);
    }

}

class ComplexCommand {
    ArrayList<DriverCommand> driverCommands;

    public ComplexCommand() {
        this.driverCommands = new ArrayList<>();
    }
}
