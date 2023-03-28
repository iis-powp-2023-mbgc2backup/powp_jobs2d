package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class CreateTest {

    public List<DriverCommand> createSquareCommand() {

        List<DriverCommand> list = new ArrayList<DriverCommand>();

        SetPositionCommand setPositionCommand = new SetPositionCommand(0, 0);
        list.add(setPositionCommand);

        OperateToCommand operateToCommand = new OperateToCommand(10, 0);
        list.add(operateToCommand);

        OperateToCommand operateToCommand1 = new OperateToCommand(10, 10);
        list.add(operateToCommand1);

        OperateToCommand operateToCommand2 = new OperateToCommand(0, 10);
        list.add(operateToCommand2);

        OperateToCommand operateToCommand3 = new OperateToCommand(0, 0);
        list.add(operateToCommand3);
        return list;
    }
}
