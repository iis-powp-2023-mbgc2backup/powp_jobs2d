package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverToDrawPanelControllerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.enums.FigureType;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), FigureType.FIGURE_JOE_1);
		application.addTest("Figure Joe 1", selectTestFigureOptionListener);
		SelectTestFigureOptionListener selectTestFigureOptionListener2 = new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), FigureType.FIGURE_JOE_2);
		application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
		SelectTestFigureOptionListener selectTestFigureOptionListener3 = new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), FigureType.FIGURE_TRIANGLE);
		application.addTest("Triangle", selectTestFigureOptionListener3);
		SelectTestFigureOptionListener selectTestFigureOptionListener4 = new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), FigureType.FIGURE_RECTANGLE);
		application.addTest("Rectangle", selectTestFigureOptionListener4);
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

		DrawPanelController drawPanelController = DrawerFeature.getDrawerController();

		Job2dDriver testDriver = new Job2dDriverToDrawPanelControllerAdapter(drawPanelController);
		DriverFeature.addDriver("Basic Simulator", testDriver);

		LineDrawerAdapter lineDriver = new LineDrawerAdapter(drawPanelController, LineFactory.getSpecialLine());
		DriverFeature.addDriver("Typed Line Simulator", lineDriver);
		setupLineType(application, lineDriver);	// enable switching between line types for lineDriver

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
	 * Setup menu for adjusting line type for Typed Line Simulator
	 *
	 * @param application Application context.
	 * @param lineDrawerAdapter Adapter with special feature to set line type
	 */
	private static void setupLineType(Application application, LineDrawerAdapter lineDrawerAdapter) {
		application.addComponentMenu(LineDrawerAdapter.class, "Line Type", 4);
		application.addComponentMenuElement(LineDrawerAdapter.class, "Basic", (ActionEvent e) -> lineDrawerAdapter.setLine(LineFactory.getBasicLine()));
		application.addComponentMenuElement(LineDrawerAdapter.class, "Dotted", (ActionEvent e) -> lineDrawerAdapter.setLine(LineFactory.getDottedLine()));
		application.addComponentMenuElement(LineDrawerAdapter.class, "Special", (ActionEvent e) -> lineDrawerAdapter.setLine(LineFactory.getSpecialLine()));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);
				app.setVisibility(true);
			}
		});
	}

}
