package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlLift extends Command {

    public ControlLift() {
    	requires(Robot.lift);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.lift.lift(Robot.remote.getTriggerAxis(Hand.kRight)-Robot.remote.getTriggerAxis(Hand.kLeft));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
