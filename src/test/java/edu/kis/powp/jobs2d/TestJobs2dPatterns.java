package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.legacy.drawer.shape.line.AbstractLine;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.command.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.adapter.Job2DriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static String FIGURE_JOE_1 = "Figure Joe 1";
	private static String FIGURE_JOE_2 = "Figure Joe 2";

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager());

		application.addTest(FIGURE_JOE_1, selectTestFigureOptionListener);
		application.addTest(FIGURE_JOE_2, selectTestFigureOptionListener);

		application.addTest("Rectangle", new SelectTestFigureOptionListener(DriverFeature.getDriverManager()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				ComplexCommandFactory.createRectangle(DriverFeature.getDriverManager().getCurrentDriver(), 0, 0, 100, 100).execute();
			}
		});

		application.addTest("Triangle", new SelectTestFigureOptionListener(DriverFeature.getDriverManager()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				ComplexCommandFactory.createTriangle(DriverFeature.getDriverManager().getCurrentDriver(), 0, 0, 100, 100).execute();
			}
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

		Job2dDriver testDriver = new Job2DriverAdapter(DrawerFeature.getDrawerController());
		DriverFeature.addDriver("Drawer Simulator", testDriver);

		LineDrawerAdapter lineDrawerAdapter = new LineDrawerAdapter(DrawerFeature.getDrawerController(),
				(AbstractLine) LineFactory.getSpecialLine());
		DriverFeature.addDriver("Special line Simulator", lineDrawerAdapter);

		LineDrawerAdapter lineDrawerAdapter2 = new LineDrawerAdapter(DrawerFeature.getDrawerController(),
				(AbstractLine) LineFactory.getDottedLine());
		DriverFeature.addDriver("Dotted line Simulator", lineDrawerAdapter2);

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
//				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
