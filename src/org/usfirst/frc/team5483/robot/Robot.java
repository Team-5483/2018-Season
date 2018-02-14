package org.usfirst.frc.team5483.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;

public class Robot extends TimedRobot {
	public static OI m_oi;

	//Remotes
	public static Joystick primaryRemote = new Joystick(RobotMap.primaryRemote);
	public static Joystick secondaryRemote = new Joystick(RobotMap.secondaryRemote);
	
	//Subsystems
	public static Chassis chassis;
	
	@Override
	public void robotInit() {
		chassis = new Chassis();
	
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
