package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.PrimitivesCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverToJob2DAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.Job2DToDrawPanelAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
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
		final DriverManager driverManager = DriverFeature.getDriverManager();

		application.addTest("Figure Joe 1", (ActionEvent e) -> {
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		});

		application.addTest("Figure Joe 2", (ActionEvent e) -> {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		});

		final AbstractDriverToJob2DAdapter janeAdapter = new AbstractDriverToJob2DAdapter(driverManager);

		application.addTest("Figure Jane", e -> {
			FiguresJane.figureScript(janeAdapter);
		});

		application.addTest("Primitives: Circle ", new ActionListener() {
			private int radius = 5;
			private int segments = 3;

			@Override
			public void actionPerformed(ActionEvent e) {
				DriverCommand cmd = PrimitivesCommandFactory.createCircle(0, 0, radius, segments);
				radius += 10;
				segments += 1;

				cmd.execute(driverManager.getCurrentDriver());
			}
		});

		application.addTest("Primitives: Rectangle ", new ActionListener() {
			private int pos = 5;

			@Override
			public void actionPerformed(ActionEvent e) {
				DriverCommand cmd = PrimitivesCommandFactory.createRectangle(pos, pos, 50, 30);
				pos += 10;
				cmd.execute(driverManager.getCurrentDriver());
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

		DrawPanelController builtinPanelController = DrawerFeature.getDrawerController();

		Job2dDriver testDriver = new Job2DToDrawPanelAdapter(builtinPanelController);
		DriverFeature.addDriver("DrawPanelAdapter Driver", testDriver);

		Job2dDriver basicLineDriver = new LineDrawerAdapter(builtinPanelController, LineFactory::getBasicLine);
		DriverFeature.addDriver("Basic Line Driver", basicLineDriver);

		Job2dDriver dottedLineDriver = new LineDrawerAdapter(builtinPanelController, LineFactory::getDottedLine);
		DriverFeature.addDriver("Dotted Line Driver", dottedLineDriver);

		Job2dDriver specialLineDriver = new LineDrawerAdapter(builtinPanelController, LineFactory::getSpecialLine);
		DriverFeature.addDriver("Special Line Driver", specialLineDriver);

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
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), false);
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
