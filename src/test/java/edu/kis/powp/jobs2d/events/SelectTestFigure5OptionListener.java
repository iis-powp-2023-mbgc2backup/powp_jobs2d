package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.factories.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class SelectTestFigure5OptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFigure5OptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ShapeFactory.getCircle(200).execute(driverManager.getCurrentDriver());
    }
}
