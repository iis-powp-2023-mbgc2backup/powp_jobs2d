package edu.kis.powp.jobs2d.drivers.fabrics;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import java.util.ArrayList;

public class FigureFactory {

    public static ComplexCommand getSquare() {
        return new ComplexCommand(
                new ArrayList<DriverCommand>() {{
                    add(new SetPositionCommand(0, 0));
                    add(new OperateToCommand(50, 0));
                    add(new OperateToCommand(50, 50));
                    add(new OperateToCommand(0, 50));
                    add(new OperateToCommand(0, 0));
                }}
        );
    }

    public static ComplexCommand getTriangle() {
        return new ComplexCommand(
                new ArrayList<DriverCommand>() {{
                    add(new SetPositionCommand(25, 0));
                    add(new OperateToCommand(50, 50));
                    add(new OperateToCommand(0, 50));
                    add(new OperateToCommand(25, 0));
                }}
        );
    }

    public static ComplexCommand getRectangle() {
        return new ComplexCommand(
                new ArrayList<DriverCommand>() {{
                    add(new SetPositionCommand(0, 0));
                    add(new OperateToCommand(100, 0));
                    add(new OperateToCommand(100, 50));
                    add(new OperateToCommand(0, 50));
                    add(new OperateToCommand(0, 0));
                }}
        );
    }
}
