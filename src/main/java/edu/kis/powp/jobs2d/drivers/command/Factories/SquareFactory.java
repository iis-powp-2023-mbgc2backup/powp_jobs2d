package edu.kis.powp.jobs2d.drivers.command.Factories;

import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

public class SquareFactory {

    private ComplexCommand cc;
    //driver.setPosition(0, 0);
    //        driver.operateTo(233, -23);
    //        driver.operateTo(24, 90);
    //        driver.operateTo(-104, 80);
    //        driver.operateTo(11, -22);
    //        driver.operateTo(-33, 44);
    //        driver.operateTo(-66, -88);
    //        driver.operateTo(128, 256);
    public SquareFactory(){
        this.cc = new ComplexCommand();
        cc.append(new SetPositionCommand(0,0));
        cc.append(new OperateToCommand(233,-23));
        cc.append(new OperateToCommand(24,90));
        cc.append(new OperateToCommand(-104,80));
        cc.append(new OperateToCommand(11,-22));
    }



}
