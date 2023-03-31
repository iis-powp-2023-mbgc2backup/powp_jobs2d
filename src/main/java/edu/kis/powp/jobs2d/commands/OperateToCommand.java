/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

/**
 *
 * @author student
 */
public class OperateToCommand implements DriverCommand
{
    private final int x;
    private final int y;
        
    OperateToCommand(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
   @Override
   public void execute(Job2dDriver driver)
   {
       driver.operateTo(x, y);
   }
    
}
