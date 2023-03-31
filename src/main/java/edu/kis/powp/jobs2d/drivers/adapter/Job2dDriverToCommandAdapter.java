package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.commands.OperateToCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;

public class Job2dDriverToCommandAdapter implements Job2dDriver
{
    Job2dDriver job2dDriver;

    public Job2dDriverToCommandAdapter(Job2dDriver job2dDriver)
    {
        this.job2dDriver = job2dDriver;
    }

    public void setPosition(int x, int y)
    {
        SetPositionCommand command = new SetPositionCommand(x, y);
        command.execute(job2dDriver);
    }

    public void operateTo(int x, int y)
    {
        OperateToCommand command = new OperateToCommand(x, y);
        command.execute(job2dDriver);
    }

}
