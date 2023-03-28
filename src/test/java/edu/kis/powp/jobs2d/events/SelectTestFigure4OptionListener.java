package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.factories.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class SelectTestFigure4OptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFigure4OptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ShapeFactory.getTriangle().execute(driverManager.getCurrentDriver());
    }
}
