package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.CreateTest;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFigureTriangle implements ActionListener {

    private DriverManager driverManager;

    public SelectFigureTriangle(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateTest createTest = new CreateTest();
        ComplexCommand complexCommand = createTest.triangleScript(driverManager.getCurrentDriver());
        complexCommand.execute();
    }
}