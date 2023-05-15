package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
public class CommandFactory {
    public ComplexCommand makeKite(Job2dDriver driver){
        ComplexCommand complexCommandKite = new ComplexCommand();

        complexCommandKite.addCommand(new SetPositionCommand(0,0));
        complexCommandKite.addCommand(new SetPositionCommand(1,2));
        complexCommandKite.addCommand(new SetPositionCommand(1,-2));
        complexCommandKite.addCommand(new SetPositionCommand(-1,-4));
        complexCommandKite.addCommand(new SetPositionCommand(-1,4));
        return complexCommandKite;
    }
}
