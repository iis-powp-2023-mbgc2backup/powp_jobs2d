package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.adapter.DrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.fabrics.FigureFactory;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener figure1OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), FigureType.FIGURE1
		);
		SelectTestFigureOptionListener figure2OptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), FigureType.FIGURE2
		);
		SelectTestFigureOptionListener squareOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), FigureType.SQUARE
		);
		SelectTestFigureOptionListener rectangleOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), FigureType.RECTANGLE
		);
		SelectTestFigureOptionListener triangleOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), FigureType.TRIANGLE
		);
		application.addTest("Figure Joe 1", figure1OptionListener);
		application.addTest("Figure Joe 2", figure2OptionListener);
		application.addTest("Figure Square", squareOptionListener);
		application.addTest("Figure Rectangle", rectangleOptionListener);
		application.addTest("Figure Triangle", triangleOptionListener);
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

		DrawPanelController currentController = DrawerFeature.getDrawerController();

		Job2dDriver testDriver = new DrawerAdapter(currentController);
		DriverFeature.addDriver("Buggy Simulator", testDriver);

		Job2dDriver lineDrawerTest = new LineDrawerAdapter(currentController, LineDrawerAdapter.LineType.DOTTED);
		DriverFeature.addDriver("Dotted Line Driver", lineDrawerTest);

		Job2dDriver specialLineTest = new LineDrawerAdapter(currentController, LineDrawerAdapter.LineType.SPECIAL);
		DriverFeature.addDriver("Special Line Driver", specialLineTest);

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
				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}
}
