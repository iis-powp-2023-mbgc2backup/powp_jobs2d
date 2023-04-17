package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.CreateTest;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFigureCircle implements ActionListener {

    private DriverManager driverManager;

    public SelectFigureCircle(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateTest createTest = new CreateTest();
        ComplexCommand complexCommand = new ComplexCommand(createTest.circleScript(driverManager.getCurrentDriver()));
        complexCommand.execute();
    }
}