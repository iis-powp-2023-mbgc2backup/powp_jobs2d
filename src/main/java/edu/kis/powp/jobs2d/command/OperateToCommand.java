package edu.kis.powp.jobs2d.command;

public class OperateToCommand extends AbstractDriverCommand {
    private int a;
    private int b;

    public OperateToCommand(int a, int b) {
        this.a = b;
        this.b = b;
    }

    @Override
    public void execute() {
        job2dDriver.operateTo(a, b);
    }
}
