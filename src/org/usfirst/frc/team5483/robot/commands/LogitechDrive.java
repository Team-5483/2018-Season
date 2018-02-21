/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;


public class LogitechDrive extends Command {
	
	//Solenoid leftSol = new Solenoid(RobotMap.leftSol);
	//Solenoid rightSol = new Solenoid(RobotMap.rightSol);
	DoubleSolenoid  doubleSol = new DoubleSolenoid(RobotMap.leftSol,RobotMap.rightSol);
	
	Compressor c = new Compressor(RobotMap.compressor);
	
	public LogitechDrive() {
		requires(Robot.chassis);
	}
	
	boolean recharging  = false;
	long start;
	@Override
	protected void initialize() {
	
		c.setClosedLoopControl(false);
		
	}

	boolean leftOpen = false,rightOpen = false;
	protected void execute() {
		if(Robot.remote.getStartButtonPressed()) {
			recharging = true;
			start = System.currentTimeMillis();
			
			//c.setClosedLoopControl(!c.getClosedLoopControl());
			c.setClosedLoopControl(true);
		
		}
		if(recharging && (System.currentTimeMillis()- start)/1000 > 20 ) {
			c.setClosedLoopControl(false);
			recharging = false;
		}
		
		if(Robot.remote.getAButton()) {
			doubleSol.set(DoubleSolenoid.Value.kReverse);

			//leftSol.set(leftOpen);
			//rightSol.set(rightOpen);
		}
		else if(Robot.remote.getBButton()) {
			doubleSol.set(DoubleSolenoid.Value.kForward);

			//rightOpen = !rightOpen;
			//rightSol.set(rightOpen);

		} else {
			doubleSol.set(DoubleSolenoid.Value.kOff);

		}
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
