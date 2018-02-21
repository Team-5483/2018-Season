package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.LogitechLiftControl;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	private Spark lift = new Spark(RobotMap.lift);
	DigitalInput botSwitch, topSwitch;
    public void initDefaultCommand() {
        setDefaultCommand(new LogitechLiftControl());
        botSwitch = new DigitalInput(RobotMap.botSwitch);
        topSwitch = new DigitalInput(RobotMap.topSwitch);
    }
    
    public void lift(double k) {
    	//if(botSwitch.get() && k < 0)
    //		return;
    //	if(topSwitch.get() && k > 0) 
    //		return;
    	lift.set(k);
    }
}

