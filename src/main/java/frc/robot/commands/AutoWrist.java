package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.RobotMap;
/**
 *
 */
public class AutoWrist extends Command {
    private double setPoint;
	boolean isFinished = false;
	
	public AutoWrist(double pos) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.wrist);
		setPoint = pos;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

        Robot.wrist.setPosition(setPoint);
	
		isFinished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP, RobotMap.INTAKE_SPEED_STOP);
	}
}