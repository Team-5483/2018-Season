package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlSucc extends Command {
	
    public ControlSucc() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	//Motors
		if(Robot.remote.getBumper(Hand.kLeft)) {
			Robot.intake.in(-1);
			
		} else if (Robot.remote.getBumper(Hand.kRight)) {
			Robot.intake.out(1);
			
		} else {
			Robot.intake.in(0);
			Robot.intake.out(0);
			
		}
		
		//Pneumatics
		if(Robot.remote.getStartButtonPressed()) {
			Robot.intake.recharge();
		}
		
		if(Robot.intake.isRecharging() && (System.currentTimeMillis()- Robot.intake.getRechargeStart())/1000 > 20 ) {
			Robot.intake.cancelRecharge();
		}
		
		if(Robot.remote.getAButton()) {
			Robot.intake.setSolenoids(DoubleSolenoid.Value.kReverse);
			
		} else if(Robot.remote.getBButton()) {
			Robot.intake.setSolenoids(DoubleSolenoid.Value.kForward);
			
		} else {
			Robot.intake.setSolenoids(DoubleSolenoid.Value.kOff);
			
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
