package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.robot.subsystems.Chassis;
import org.usfirst.frc.team5483.robot.subsystems.Intake;
import org.usfirst.frc.team5483.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
	public static OI m_oi;

	//Remote
	public static XboxController remote = new XboxController(RobotMap.remote);
	
	//Subsystems
	public static Chassis chassis;
	public static Lift lift;
	public static Intake intake;
	
	@Override
	public void robotInit() {
		chassis = new Chassis();
		lift = new Lift();
		intake = new Intake();
		
		m_oi = new OI();
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
