package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.CommandFactory;
import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.command.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectComplexP implements ActionListener {
    private final DriverManager driverManager;
    private final ComplexCommand complexKite = new ComplexCommand();
    private final CommandFactory kiteFactory = new CommandFactory();


    public SelectComplexP(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ComplexCommand drawComplexKite = new ComplexCommand();
        drawComplexKite.addCommand(new CommandFactory().makeP());
        drawComplexKite.execute(driverManager.getCurrentDriver());
    }
}
