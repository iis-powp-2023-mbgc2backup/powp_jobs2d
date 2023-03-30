package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.CommandFactory;
import edu.kis.powp.jobs2d.command.ComplexCommandGenerator;
import edu.kis.powp.jobs2d.drivers.adapters.*;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		application.addTest("Figure Joe 1", (ActionEvent e) -> FiguresJoe.figureScript1(DriverFeature.getDriverManager().getCurrentDriver()));
		application.addTest("Figure Joe 2", (ActionEvent e) -> FiguresJoe.figureScript2(DriverFeature.getDriverManager().getCurrentDriver()));
		application.addTest("Figure Jane 1", (ActionEvent e) -> FiguresJane.figureScript(new AbstractDriverToJob2DAdapter(DriverFeature.getDriverManager().getCurrentDriver())));
		application.addTest("Draw Square", (ActionEvent e) -> CommandFactory.getSquareCommandSequence(10, 10, 100).execute(DriverFeature.getDriverManager().getCurrentDriver()));
		application.addTest("Draw Circle", (ActionEvent e) -> CommandFactory.getCircleCommandSequence(10, 10, 50).execute(DriverFeature.getDriverManager().getCurrentDriver()));
		application.addTest("Complex command generated from Figure Joe 1", (ActionEvent e) -> {
			Logger logger = Logger.getLogger("global");
			ComplexCommandGenerator generator = new ComplexCommandGenerator(DriverFeature.getDriverManager().getCurrentDriver());
			FiguresJoe.figureScript1(generator);
			logger.info(generator.getCommands().toString());
		});
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		Job2dDriver testNormalLineDriver = new DriverToDrawerNormalLineAdapter(DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Normal line Simulator", testNormalLineDriver);

		Job2dDriver testSpecialLineDriver = new DriverToDrawerSpecialLineAdapter(DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Special line Simulator", testSpecialLineDriver);

		Job2dDriver testDottedLineDriver = new DriverToDrawerDottedLineAdapter(DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Dotted line Simulator", testDottedLineDriver);

		Job2dDriver testEditableLineDriver = new DriverToDrawerEditableLineAdapter(DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Editable line Simulator", testEditableLineDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(true);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);

				//unnecessary visibility toggle
				//setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
