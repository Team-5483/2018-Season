package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.DriveRobot;
import org.usfirst.frc.team5483.utils.Maths;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveRobot());
	}
	
	public void arcadeDrive(double l, double r) {
		drive.tankDrive(Maths.sig2(l) + Maths.square(r), Maths.sig2(l) - Maths.square(r));
	}
}
