package edu.kis.powp.command;

import edu.kis.powp.jobs2d.drivers.DriverManager;

public class FigureFactory {
    private final DriverManager driverManager;
    private int x;
    private int y;

    public FigureFactory(DriverManager driverManager, int x, int y) {
        this.driverManager = driverManager;
        this.x = x;
        this.y = y;
    }

    public void ChangeStartPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ComplexCommand createTriangle(int x1, int y1, int x2, int y2) {
        ComplexCommand temp = new ComplexCommand();
        temp.addCommand(new SetPositionCommand(this.x, this.y, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(x1, y1, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(x2, y2, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(this.x, this.y, driverManager.getCurrentDriver()));
        return temp;
    }

    public ComplexCommand createRectangle(int x, int y) {
        ComplexCommand temp = new ComplexCommand();
        temp.addCommand(new SetPositionCommand(this.x, this.y, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(x, this.y, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(x, y, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(this.x, y, driverManager.getCurrentDriver()));
        temp.addCommand(new OperateToCommand(this.x, this.y, driverManager.getCurrentDriver()));
        return temp;
    }
}
