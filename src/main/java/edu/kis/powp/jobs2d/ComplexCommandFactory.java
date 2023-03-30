/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.kis.powp.jobs2d;

/**
 *
 * @author student
 */
public class ComplexCommandFactory 
{
    public ComplexCommand getSquareCommand()
    {
        ComplexCommand ret = new ComplexCommand();
        ret.addCommand(new SetPositionCommand(0,0));
        ret.addCommand(new OperateToCommand(0,50));
        ret.addCommand(new OperateToCommand(50,50));
        ret.addCommand(new OperateToCommand(50,0));
        ret.addCommand(new OperateToCommand(0,0));
        return ret;
    }
    
    public ComplexCommand getTriangleCommand()
    {
        ComplexCommand ret = new ComplexCommand();
        ret.addCommand(new SetPositionCommand(0,0));
        ret.addCommand(new OperateToCommand(0,50));
        ret.addCommand(new OperateToCommand(25,25));
        ret.addCommand(new OperateToCommand(0,0));
        return ret;
    }
    
}
