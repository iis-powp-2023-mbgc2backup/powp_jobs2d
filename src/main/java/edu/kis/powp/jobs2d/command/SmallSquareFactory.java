package edu.kis.powp.jobs2d.command;

public class SmallSquareFactory extends CommandFactory{
    @Override
    public ComplexCommand draw() {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.add(new SetPositionCommand(-60,-60));
        complexCommand.add(new OperateToCommand(60,-60));
        complexCommand.add(new OperateToCommand(60,60));
        complexCommand.add(new OperateToCommand(-60,60));
        complexCommand.add(new OperateToCommand(-60,-60));
        return complexCommand;
    }
}
