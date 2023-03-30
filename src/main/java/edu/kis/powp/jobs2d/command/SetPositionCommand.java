package edu.kis.powp.jobs2d.command;

public class SetPositionCommand extends AbstractDriverCommand {
    private int a;
    private int b;

    public SetPositionCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        job2dDriver.setPosition(a, b);
    }
}