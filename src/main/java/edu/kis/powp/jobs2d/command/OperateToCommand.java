package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand extends AbstractDriverCommand {
    private int a;
    private int b;

    public OperateToCommand(int a, int b, Job2dDriver driver) {
        super.setDriver(driver);
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        job2dDriver.operateTo(a, b);
    }
}
