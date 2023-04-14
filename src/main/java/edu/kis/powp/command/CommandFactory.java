package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory{
        static public ComplexCommand square(Job2dDriver driver) {
            ComplexCommand complexCommand = new ComplexCommand();
            complexCommand.addCommand(new SetPositionCommand(driver,5,100));
            complexCommand.addCommand(new OperateToCommand(driver,100,100));
            complexCommand.addCommand(new OperateToCommand(driver,100,5));
            complexCommand.addCommand(new OperateToCommand(driver,5,5));
            complexCommand.addCommand(new OperateToCommand(driver,5,100));
            return complexCommand;
        }
        static public ComplexCommand triangle(Job2dDriver driver) {
            ComplexCommand complexCommand = new ComplexCommand();
            complexCommand.addCommand(new SetPositionCommand(driver,5,100));
            complexCommand.addCommand(new OperateToCommand(driver,100,100));
            complexCommand.addCommand(new OperateToCommand(driver,50,5));
            complexCommand.addCommand(new OperateToCommand(driver,5,100));
            return complexCommand;
        }
        static public ComplexCommand circle(Job2dDriver driver){
            ComplexCommand complexCommand = new ComplexCommand();
            int centerX = 100; // współrzędna x środka okręgu
            int centerY = 100; // współrzędna y środka okręgu
            int x = 50; // współrzędna x początkowa
            int y = 0; // współrzędna y początkowa
            int decision = 1 - 50; // początkowa wartość decyzji

            while (x >= y) {
                // Symetrycznie rysuj 8 punktów okręgu
                complexCommand.addCommand(new SetPositionCommand(driver, centerX + x, centerY + y));
                complexCommand.addCommand(new OperateToCommand(driver, centerX + x, centerY + y));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX + y, centerY + x));
                complexCommand.addCommand(new OperateToCommand(driver, centerX + y, centerY + x));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX - y, centerY + x));
                complexCommand.addCommand(new OperateToCommand(driver, centerX - y, centerY + x));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX - x, centerY + y));
                complexCommand.addCommand(new OperateToCommand(driver, centerX - x, centerY + y));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX - x, centerY - y));
                complexCommand.addCommand(new OperateToCommand(driver, centerX - x, centerY - y));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX - y, centerY - x));
                complexCommand.addCommand(new OperateToCommand(driver, centerX - y, centerY - x));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX + y, centerY - x));
                complexCommand.addCommand(new OperateToCommand(driver, centerX + y, centerY - x));
                complexCommand.addCommand(new SetPositionCommand(driver, centerX + x, centerY - y));
                complexCommand.addCommand(new OperateToCommand(driver, centerX + x, centerY - y));

                y++;
                if (decision <= 0) {
                    decision += 2 * y + 1;
                } else {
                    x--;
                    decision += 2 * (y - x) + 1;
                }
            }

            return complexCommand;
        }
}
