package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

public class DriveRobot extends Command {
	
	public DriveRobot() {
		requires(Robot.chassis);
	}
	
	protected void initialize() {
	}

	protected void execute() {		
		Robot.chassis.arcadeDrive(
				(-Robot.remote.getY(Hand.kLeft)), 
				(Robot.remote.getX(Hand.kRight)));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
