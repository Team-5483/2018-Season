/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5483.robot.Robot;


public class LogitechDrive extends Command {
	public LogitechDrive() {
		requires(Robot.chassis);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.chassis.arcadeDrive(
				Robot.primaryRemote.getX(Hand.kLeft), 
				Robot.primaryRemote.getY(Hand.kRight));
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
