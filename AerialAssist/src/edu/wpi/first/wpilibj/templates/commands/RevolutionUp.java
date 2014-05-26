/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.RevolutionLift;

//"Compiler says no" Steph McAurther 2014

/**
 *
 * @author Segway
 */
public class RevolutionUp extends CommandBase {

    double loadHeight = 1.5;
    double shootHeight = 4.0;
    double threshold = 0.1;
    double target = loadHeight;
    Joystick stick;
    public RevolutionUp(Joystick stick) {
            this.stick = stick;
            requires (revolutionLift);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //double liftVoltage = revolutionLift.getAngle();
        //if (liftVoltage > 0) {
        /*    System.out.println("Forklift wanted is " + stick.getZ() + 
                ". Forklift is currently at " + liftVoltage);
        //}
        
        if (stick.getRawButton(10)) {
            target = loadHeight;
            target += stick.getZ();
        } else if (stick.getRawButton(11)) {
            target = shootHeight;
            target += stick.getZ()/2;
        } 
             
        if (liftVoltage > target + threshold) {
            // Go down
            revolutionLift.moveDown(1);
            System.out.println("Going Down. Target: " + target);
            SmartDashboard.putNumber("Revolution target", target);
        } else if (liftVoltage < target - threshold) {
            System.out.println("Going Up. Target: " + target);
            // Go up
            revolutionLift.moveUp(1);
        } else {
            revolutionLift.moveUp(0);
        }
        */
        //revolutionLift.moveUp(speed);
        if (stick.getRawButton(10)){
            revolutionLift.moveDown(1);
        } else if (stick.getRawButton(11)){
            revolutionLift.moveUp(1);
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
        revolutionLift.moveUp (0);
    }
}