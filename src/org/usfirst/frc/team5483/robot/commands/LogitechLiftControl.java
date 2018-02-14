package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class LogitechLiftControl extends Command {

    public LogitechLiftControl() {
    	requires(Robot.lift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.lift.lift(0);
    	
    	if(Robot.remote.getBumper(Hand.kLeft)) {
    		Robot.lift.lift(0.65);
    	} else if(Robot.remote.getBumper(Hand.kRight)) {
    		Robot.lift.lift(-0.50);
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
