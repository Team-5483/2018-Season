package org.usfirst.frc.team5483.robot.subsystems;

import org.usfirst.frc.team5483.robot.RobotMap;
import org.usfirst.frc.team5483.robot.commands.ControlSucc;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{

	private Spark leftIntakeMotor = new Spark(RobotMap.leftIntakeMotor);
	private Spark rightIntakeMotor = new Spark(RobotMap.rightIntakeMotor);
	
	private Compressor compressor = new Compressor(RobotMap.compressor);
	private DoubleSolenoid  doubleSolenoids = new DoubleSolenoid(RobotMap.leftSol,RobotMap.rightSol);
	
	private boolean recharging = false;
	private long start;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ControlSucc());
		compressor.setClosedLoopControl(false);
	}
	
	public void recharge() {
		recharging = true;
		start = System.currentTimeMillis();
		
		compressor.setClosedLoopControl(true);
	}
	
	public void cancelRecharge() {
		compressor.setClosedLoopControl(false);
		recharging = false;
	}
	
	public void setSolenoids(DoubleSolenoid.Value value) {
		doubleSolenoids.set(value);
	}
	
	public void in(double k) {
		leftIntakeMotor.set(-k);
		rightIntakeMotor.set(k);
	}
	
	public void out(double k) {
		leftIntakeMotor.set(-k);
		rightIntakeMotor.set(k);
	}
	
	public boolean isRecharging() {
		return recharging;
	}
	
	public long getRechargeStart() {
		return start;
	}

}
