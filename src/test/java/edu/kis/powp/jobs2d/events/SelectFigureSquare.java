package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.CreateTest;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFigureSquare implements ActionListener {

    private DriverManager driverManager;

    public SelectFigureSquare(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateTest createTest = new CreateTest();
        ComplexCommand complexCommand = createTest.squareScript(driverManager.getCurrentDriver());
        complexCommand.execute();
    }
}