package edu.kis.powp.command;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;

// public interface Job2dDriver {
//    void setPosition(int var1, int var2);
//
//    void operateTo(int var1, int var2);
//}


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
