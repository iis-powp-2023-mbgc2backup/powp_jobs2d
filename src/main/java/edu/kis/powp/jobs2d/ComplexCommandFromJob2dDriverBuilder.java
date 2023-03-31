package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.commands.ComplexCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.commands.OperateToCommand;

public class ComplexCommandFromJob2dDriverBuilder implements Job2dDriver
{
    private ComplexCommand resultingCommand = new ComplexCommand();

    public ComplexCommand withdrawComplexCommand()
    {
        ComplexCommand ret = resultingCommand;
        resultingCommand = new ComplexCommand();
        return ret;
    }

    public void setPosition(int x, int y)
    {
        resultingCommand.addCommand(new SetPositionCommand(x, y));
    }

    public void operateTo(int x, int y)
    {
        resultingCommand.addCommand(new OperateToCommand(x, y));
    }


}
