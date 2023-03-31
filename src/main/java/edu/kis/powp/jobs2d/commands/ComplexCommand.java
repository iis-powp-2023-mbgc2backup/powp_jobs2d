/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kis.powp.jobs2d.commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class ComplexCommand implements DriverCommand
{
    private List<DriverCommand> commands;
    
    ComplexCommand()
    {
        commands = new ArrayList();
    }
    
    public void addCommand(DriverCommand command)
    {
        commands.add(command);
    }
    
    public void clearCommands()
    {
        commands.clear();
    }

    @Override
    public void execute(Job2dDriver driver) 
    {
        for (DriverCommand d : commands)
        {
            d.execute(driver);
        }
        
        commands.clear();
    }
    
}
