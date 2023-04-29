package edu.kis.powp.jobs2d.command;

public class SquareFactory extends CommandFactory{
    @Override
    public ComplexCommand draw() {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.add(new SetPositionCommand(-120,-120));
        complexCommand.add(new OperateToCommand(120,-120));
        complexCommand.add(new OperateToCommand(120,120));
        complexCommand.add(new OperateToCommand(-120,120));
        complexCommand.add(new OperateToCommand(-120,-120));
        return complexCommand;
    }
}
