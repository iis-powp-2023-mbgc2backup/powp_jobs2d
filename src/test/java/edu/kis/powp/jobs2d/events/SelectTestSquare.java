package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.CommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestSquare implements ActionListener {
    private DriverManager driverManager;

    public SelectTestSquare(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CommandFactory.square(driverManager.getCurrentDriver()).execute();

    }
}
