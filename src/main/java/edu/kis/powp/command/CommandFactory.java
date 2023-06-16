package edu.kis.powp.command;

public class CommandFactory {
    int scale = 30;

    public ComplexCommand makeKite() {

        ComplexCommand complexCommandKite = new ComplexCommand();

        complexCommandKite.addCommand(new SetPositionCommand(0, 0));
        complexCommandKite.addCommand(new OperateToCommand(1 * scale, 2 * scale));
        complexCommandKite.addCommand(new OperateToCommand(1 * scale, (-2) * scale));
        complexCommandKite.addCommand(new OperateToCommand((-1) * scale, (-4) * scale));
        complexCommandKite.addCommand(new OperateToCommand((-1) * scale, 4 * scale));
        return complexCommandKite;
    }

    public ComplexCommand makeP() {
        ComplexCommand complexCommandP = new ComplexCommand();
        complexCommandP.addCommand(new SetPositionCommand(0, 0));
        complexCommandP.addCommand(new OperateToCommand(0, 2 * scale));
        complexCommandP.addCommand(new OperateToCommand(1 * scale, 0));
        complexCommandP.addCommand(new OperateToCommand(0, (-1) * scale));
        complexCommandP.addCommand(new OperateToCommand((-1) * scale, 0));
        return complexCommandP;
    }
}
