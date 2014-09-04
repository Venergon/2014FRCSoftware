/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Segway
 */
public class SoftKick extends CommandBase {    
    double speed;
    
    public SoftKick(double speed) {
        requires (kickerMechanism);
        this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         if (speed == 1){
            kickerMechanism.kick(.25);            
        }
        if (speed == -1){
            kickerMechanism.kick(-.25);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        kickerMechanism.kick(0);
    }
}