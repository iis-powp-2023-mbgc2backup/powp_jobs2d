package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.CommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestTriangle implements ActionListener {
    private DriverManager driverManager;

    public SelectTestTriangle(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CommandFactory.triangle(driverManager.getCurrentDriver()).execute();

    }
}
