package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.factory.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSquareListener implements ActionListener {

    private DriverManager driverManager;

    public SelectSquareListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command = ShapeFactory.getSquare(driverManager.getCurrentDriver());
        command.execute();
    }
}