package edu.kis.powp.jobs2d.commands;

import com.sun.tools.javac.util.List;

public interface Shape {
    List<DriverCommand> createCommands();
}
