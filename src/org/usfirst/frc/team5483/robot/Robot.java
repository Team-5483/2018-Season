package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.robot.commands.auto.BaselineAuto;
import org.usfirst.frc.team5483.robot.commands.auto.DoNothingAuto;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;
import org.usfirst.frc.team5483.robot.subsystems.Intake;
import org.usfirst.frc.team5483.robot.subsystems.Lift;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static OI m_oi;

	//Remote
	public static XboxController remote = new XboxController(RobotMap.remote);
	
	//Subsystems
	public static Chassis chassis;
	public static Lift lift;
	public static Intake intake;
	
	Command autoCommand;
	SendableChooser autoChooser;
	
	@Override
	public void robotInit() {
		chassis = new Chassis();
		lift = new Lift();
		intake = new Intake();
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Base Line", new BaselineAuto());
		autoChooser.addObject("Do Nothing", new DoNothingAuto());
		
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
		m_oi = new OI();
			new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(160, 120);
            
           /* CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 160, 120);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }*/
        }).start();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autoCommand = (Command) autoChooser.getSelected();
		autoCommand.start();
		
		//Scheduler.getInstance().add(new BaselineAuto());
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		//if (m_autonomousCommand != null) {
		//	m_autonomousCommand.cancel();
		//}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
