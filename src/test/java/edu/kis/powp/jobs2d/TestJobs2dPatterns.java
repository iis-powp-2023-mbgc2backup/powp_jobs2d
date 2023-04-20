package edu.kis.powp.jobs2d;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.DrawerAdapterToDriver;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

import static java.awt.Color.*;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , TestFigureType.FIGURE_JOE_1);
		application.addTest("Figure Joe 1", selectTestFigureOptionListener);

		 selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , TestFigureType.FIGURE_JOE_2);
		application.addTest("Figure Joe 2", selectTestFigureOptionListener);

		 selectTestFigureOptionListener = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager() , TestFigureType.FIGURE_JANE);
		application.addTest("Figure Jane",  selectTestFigureOptionListener);

	}

	private static final CustomeLine customeLine = new CustomeLine( );

	private static void setupLine(Application application) {

		application.addComponentMenu(CustomeLine.class, "Lines", 0);

		application.addComponentMenuElement(CustomeLine.class, "blue", (ActionEvent e) -> TestJobs2dPatterns.customeLine.setColor(blue));
		application.addComponentMenuElement(CustomeLine.class, "red", (ActionEvent e) -> TestJobs2dPatterns.customeLine.setColor(red));
		application.addComponentMenuElement(CustomeLine.class, "black", (ActionEvent e) -> TestJobs2dPatterns.customeLine.setColor(black));
		application.addComponentMenuElementWithCheckBox(CustomeLine.class, "Dotted", (ActionEvent e) -> TestJobs2dPatterns.customeLine.setDotted( !TestJobs2dPatterns.customeLine.isDotted() ) ,  false);

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

		Job2dDriver testDriver = new DrawerAdapterToDriver(DrawerFeature.getDrawerController() ) ;
		DriverFeature.addDriver("Buggy Simulator", testDriver);

		Job2dDriver testLineDriver = new DrawerAdapterToDriver(DrawerFeature.getDrawerController()  , customeLine  );
		DriverFeature.addDriver("Special Line Simulator", testLineDriver);

		Job2dDriver abstractDriver = new AbstractDriverAdapter(0,0 );
		DriverFeature.addDriver("Abstract Simulator", abstractDriver);

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
		defaultDrawerWindow.setVisible(false);
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
		EventQueue.invokeLater(() -> {


			Application app = new Application("2d jobs Visio");
			DrawerFeature.setupDrawerPlugin(app);
			setupDefaultDrawerVisibilityManagement(app);

			DriverFeature.setupDriverPlugin(app);

			setupDrivers(app);

			setupLine(app);

			setupPresetTests(app);

			setupLogger(app);

			app.setVisibility(true);
		});
	}

}
