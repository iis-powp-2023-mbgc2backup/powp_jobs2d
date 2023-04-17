package edu.kis.powp.jobs2d.drivers.command.Factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

import java.util.ArrayList;

public class FlounderFactory {

    private ArrayList<DriverCommand> cc;
    //driver.setPosition(0, 0);
    //        driver.operateTo(233, -23);
    //        driver.operateTo(24, 90);
    //        driver.operateTo(-104, 80);
    //        driver.operateTo(11, -22);
    //        driver.operateTo(-33, 44);
    //        driver.operateTo(-66, -88);
    //        driver.operateTo(128, 256);
    public FlounderFactory(Job2dDriver dDriver){ //Tutaj nie wiem, czy trzeba przekazywać driver Job2dDriver driver
        this.cc = new ArrayList<DriverCommand>();
        cc.add(new SetPositionCommand(0,0,dDriver));
        cc.add(new OperateToCommand(233,-23,dDriver));
        cc.add(new OperateToCommand(24,90,dDriver));
        cc.add(new OperateToCommand(-104,80,dDriver));
        cc.add(new OperateToCommand(11,-22,dDriver));
        cc.add(new SetPositionCommand(5,20,dDriver));
        cc.add(new OperateToCommand(5,30,dDriver));

        cc.add(new SetPositionCommand(-10,20,dDriver));
        cc.add(new OperateToCommand(-10,30,dDriver));

        cc.add(new SetPositionCommand(-20,50,dDriver));
        cc.add(new OperateToCommand(0,50,dDriver));

    }

    public ArrayList<DriverCommand> returnSquareFactory()
    {
        return cc;
    }



}
