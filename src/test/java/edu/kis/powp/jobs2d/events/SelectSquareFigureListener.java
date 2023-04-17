package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.Factories.FlounderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSquareFigureListener implements ActionListener {

    private DriverManager driverManager;
    public SelectSquareFigureListener(DriverManager driverManager) {
        super();
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FlounderFactory flounderFactory = new FlounderFactory(this.driverManager.getCurrentDriver());
        ComplexCommand complexCommand = new ComplexCommand(flounderFactory.returnSquareFactory());
        complexCommand.execute();
    }

}
