package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.LogitechIntakeControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{

	private Spark left = new Spark(RobotMap.leftIntakeMotor);
	private Spark right = new Spark(RobotMap.rightIntakeMotor);
	private SpeedControllerGroup motors = new SpeedControllerGroup(left, right);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LogitechIntakeControl());
	}
	
	public void in(double k) {
		motors.set(k);
	}
	
	public void out(double k) {
		motors.set(k);
	}

}
