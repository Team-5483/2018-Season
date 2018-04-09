package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveRobot extends Command {
	
	public DriveRobot() {
		requires(Robot.chassis);
	}
	
	protected void initialize() {
		
	}
	double mul = 1;
	protected void execute() {
		//double mul = 1;
		//if(Robot.remote.getXButton()) {
		//	mul = 0.7f;
		//}
		if(Robot.remote.getXButtonPressed()) {
			if(mul == 1) {
				mul = 0.7;
			} else {
				mul = 1;
			}
		}
		
		Robot.chassis.arcadeDrive(
				(-Robot.remote.getY(Hand.kLeft))*mul, 
				(Robot.remote.getX(Hand.kRight))*mul);
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
