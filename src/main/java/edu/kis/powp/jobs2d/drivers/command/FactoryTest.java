package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryTest implements ActionListener
{
    private DriverManager driverManager;

    public FactoryTest(DriverManager dm)
    {
        this.driverManager = dm;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Nie rozumiem tego :/
        driverManager.getCurrentDriver();
    }
}
