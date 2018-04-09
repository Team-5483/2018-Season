package org.usfirst.frc.team5483.robot.commands.auto;

import org.usfirst.frc.team5483.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BaselineAuto extends Command {
	
	private Timer time;
	int yeet = 0;
	public BaselineAuto() {
    	requires(Robot.chassis);
    }
	
	protected void initialize() {
		time = new Timer();
    }

    protected void execute() {
    	yeet++;    		
    	if(yeet < 300) {
    		Robot.chassis.arcadeDrive(-0.75f,0);
    	} else {
    		Robot.chassis.arcadeDrive(0, 0);
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
