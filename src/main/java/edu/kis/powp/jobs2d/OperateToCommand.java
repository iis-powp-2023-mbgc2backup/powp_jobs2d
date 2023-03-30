/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kis.powp.jobs2d;

/**
 *
 * @author student
 */
public class OperateToCommand implements DriverCommand
{
    private int x;
    private int y;
    
    Job2dDriver driver;
    
    OperateToCommand(int x, int y, Job2dDriver driver)
    {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }
    
   @Override
   public void execute()
   {
       driver.operateTo(x, y);
   }
    
}
