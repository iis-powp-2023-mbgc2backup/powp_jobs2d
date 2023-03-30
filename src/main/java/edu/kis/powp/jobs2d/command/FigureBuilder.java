package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

//do zadania 6.
public class FigureBuilder {
    private ComplexCommand complexCommand = new ComplexCommand();
    private Job2dDriver driver;
    public FigureBuilder(Job2dDriver driver)
    {

        this.driver= driver;

    }


    public FigureBuilder setPosition(int a, int b) {
        complexCommand.addCommand(new SetPositionCommand(a,b,driver));
        return this;
    }

    public FigureBuilder operateTo(int a, int b) {
        complexCommand.addCommand(new OperateToCommand(a, b,driver));
        return this;
    }

    public DriverCommand build() {
        return complexCommand;
    }
}