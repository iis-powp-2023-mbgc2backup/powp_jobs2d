package edu.kis.powp.command;

public abstract class ComplexCommandFactory {
    private ComplexCommand complexCommand;

    public static ComplexCommand getCommand(FigureType type) throws UnsupportedOperationException {
        if (type == FigureType.RECTANGLE)
            return new Rectangle();
        if (type == FigureType.TRIANGLE)
            return new Triangle();

        throw new UnsupportedOperationException("Only rectangles and triangles!");
    }

}
