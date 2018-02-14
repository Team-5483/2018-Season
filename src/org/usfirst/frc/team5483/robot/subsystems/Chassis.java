package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.LogitechDrive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends Subsystem {
	
	private Spark lfMotor = new Spark(RobotMap.leftFrontMotor);
	private Spark lbMotor = new Spark(RobotMap.leftBackMotor);
	private SpeedControllerGroup lControllers = new SpeedControllerGroup(lfMotor, lbMotor);
	private Spark rfMotor = new Spark(RobotMap.rightFrontMotor);
	private Spark rbMotor = new Spark(RobotMap.rightBackMotor);
	private SpeedControllerGroup rControllers = new SpeedControllerGroup(rfMotor, rbMotor);
	
	private DifferentialDrive drive = new DifferentialDrive(lControllers, rControllers);
	
	//public Talon lift = new Talon(RobotMap.lift);
		
	public void initDefaultCommand() {
		setDefaultCommand(new LogitechDrive());
	}
	
	public void arcadeDrive(double l, double r) {
		drive.tankDrive(l + r, l - r, true);
	}
}
