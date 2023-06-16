package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import java.util.ArrayList;
import java.util.List;

public class FiguresJack {

    public static List<DriverCommand> figureScript1(Job2dDriver driver) {
        List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(-120, -120));
        driver.operateTo(120, -120);
        driver.operateTo(120, 120);
        driver.operateTo(-120, 120);
        driver.operateTo(-120, -120);
        return commands;
    }
}
