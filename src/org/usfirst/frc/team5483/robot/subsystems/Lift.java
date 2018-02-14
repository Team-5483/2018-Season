package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.LogitechLiftControl;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	private Spark lift = new Spark(RobotMap.lift);
	
    public void initDefaultCommand() {
        setDefaultCommand(new LogitechLiftControl());
    }
    
    public void lift(double k) {
    	lift.set(k);
    }
}

