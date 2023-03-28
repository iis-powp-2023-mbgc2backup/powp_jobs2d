package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.CommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestRectangle implements ActionListener {
    private DriverManager driverManager;

    public SelectTestRectangle(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CommandFactory.rectangle(driverManager.getCurrentDriver()).execute();

    }
}
