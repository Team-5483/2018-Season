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
	
	public void initDefaultCommand() {
		setDefaultCommand(new LogitechDrive());
	}
	
	public void arcadeDrive(double l, double r) {
		drive.tankDrive(sig2(l) + square(r), sig2(l) - square(r));
	}
	public double square(double a) {
		if(a > 0)
			return a*a;
		return -a*a;
	}
	
	public static double cube(double a) {
		return a*a*a;
	}
	
	public static double sig(double a) {
		return 2*(1/( 1 + Math.pow(Math.E,(-1*(5*a))))-0.5);
	}
	
	public static double sig2(double a) {
		int b = 1;
		if( a < 0) b = -1;
		
		return b*((1/(1 + Math.pow(Math.E,((b*-4*a)+3)))) + 0.2);
	}
}
