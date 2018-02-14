package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class LogitechIntakeControl extends Command {

    public LogitechIntakeControl() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.in(0);
		Robot.intake.out(0);
    	
		if(Robot.remote.getAButton()) {
			Robot.intake.in(0);
		} else if (Robot.remote.getBButton()) {
			Robot.intake.out(1);
		}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
