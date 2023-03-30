/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kis.powp.jobs2d;

/**
 *
 * @author student
 */
public class SetPositionCommand implements DriverCommand
{
    private final int x;
    private final int y;
    
    Job2dDriver driver;
    
    SetPositionCommand(int x, int y, Job2dDriver driver)
    {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }
    
   @Override
   public void execute()
   {
       driver.setPosition(x, y);
   }


   
   
}
