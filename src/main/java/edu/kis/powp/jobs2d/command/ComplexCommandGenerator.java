package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandGenerator implements Job2dDriver {

    private final Job2dDriver driver;
    private final ComplexCommand commands;

    public ComplexCommandGenerator(Job2dDriver driver) {
        this.driver = driver;
        commands = new ComplexCommand();
    }

    @Override
    public void setPosition(int i, int i1) {
        this.commands.addCommand(new SetPositionCommand(i, i1));
        this.driver.setPosition(i, i1);
    }

    @Override
    public void operateTo(int i, int i1) {
        this.commands.addCommand(new OperateToCommand(i, i1));
        this.driver.operateTo(i, i1);
    }

    public ComplexCommand getCommands() {
        return commands;
    }
}
