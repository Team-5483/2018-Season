/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;


public class LogitechDrive extends Command {
	
	Solenoid leftSol = new Solenoid(RobotMap.leftSol);
	Solenoid rightSol = new Solenoid(RobotMap.rightSol);

	Compressor c = new Compressor(RobotMap.compressor);
	
	public LogitechDrive() {
		requires(Robot.chassis);
	}

	@Override
	protected void initialize() {
		c.setClosedLoopControl(true);
	}

	boolean leftOpen = false,rightOpen = false;
	protected void execute() {
		if(Robot.remote.getAButton()) {
			leftOpen = !leftOpen;
			leftSol.set(leftOpen);
		}
		if(Robot.remote.getBButton()) {
			rightOpen = !rightOpen;
			rightSol.set(rightOpen);
		}
		Robot.chassis.arcadeDrive(
				-Robot.remote.getY(Hand.kLeft), 
				Robot.remote.getX(Hand.kRight));
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
