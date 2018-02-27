package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.ControlLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	private Spark liftMotor = new Spark(RobotMap.lift);
	
    public void initDefaultCommand() {
        setDefaultCommand(new ControlLift());
    }
    
    public void lift(double k) {
    	liftMotor.set(k);
    }
}

