package edu.kis.powp.command;

public abstract class ComplexCommandFactory {
    ComplexCommand complexCommand;

    public static ComplexCommand getCommand(String type) throws UnsupportedOperationException {
        if (type.equals("Rectangle"))
            return new Rectangle();
        if (type.equals("Triangle"))
            return new Triangle();

        throw new UnsupportedOperationException("Only rectangles and triangles!");
    }

}
