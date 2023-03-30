package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.line.DottedLine;
import edu.kis.legacy.drawer.shape.line.SpecialLine;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.FigureBuilder;
import edu.kis.powp.jobs2d.command.FigureFactory;
import edu.kis.powp.jobs2d.drivers.adapter.Converter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListenerOne;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListenerTwo;
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
		SelectTestFigureOptionListenerOne selectTestFigureOptionListener1 = new SelectTestFigureOptionListenerOne(
				DriverFeature.getDriverManager());
		SelectTestFigureOptionListenerTwo selectTestFigureOptionListener2 = new SelectTestFigureOptionListenerTwo(
				DriverFeature.getDriverManager());
		application.addTest("Figure Joe 1", selectTestFigureOptionListener1);
		application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
		application.addTest("Rectangle", e->{
			DriverCommand command = FigureFactory.getRectangle(DriverFeature.getDriverManager().getCurrentDriver());
			command.execute();
		});
		application.addTest("Triangle", e->{
			DriverCommand command = FigureFactory.getTriangle(DriverFeature.getDriverManager().getCurrentDriver());
			command.execute();
		});
		application.addTest("Circle", e->{
			DriverCommand command = FigureFactory.getCircle(DriverFeature.getDriverManager().getCurrentDriver());
			command.execute();
		});
		//do zadania 6
		application.addTest("figureScript1", e->{
			FigureBuilder builder = new FigureBuilder(DriverFeature.getDriverManager().getCurrentDriver());
			DriverCommand triangle = builder.setPosition(-120, -120).
					operateTo(120, -120).
					operateTo(120, 120).
					operateTo(-120, 120).
					operateTo(-120, -120).
					operateTo(120, 120).
					setPosition(120, -120).
					operateTo(-120, 120).build();
			triangle.execute();
		});

		application.addTest("figureScript2", e->{
			FigureBuilder builder = new FigureBuilder(DriverFeature.getDriverManager().getCurrentDriver());
			DriverCommand triangle = builder.setPosition(0, 0).
					operateTo(233, -23).
					operateTo(24, 90).
					operateTo(-104, 80).
					operateTo(11, -22).
					operateTo(-33, 44).
					operateTo(-66, -88).
					operateTo(128, 256).build();
			triangle.execute();
		});








	}


	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		Job2dDriver testDriver = new Converter();
		DriverFeature.addDriver("Basic Line Simulator", testDriver);

		Job2dDriver testDriver_2 = new LineDrawerAdapter( new DottedLine());
		DriverFeature.addDriver("Dotted Line Simulator", testDriver_2);

		Job2dDriver testDriver_3 = new LineDrawerAdapter( new SpecialLine());
		DriverFeature.addDriver("Special Line Simulator", testDriver_3);


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
		//defaultDrawerWindow.setVisible(true);
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
