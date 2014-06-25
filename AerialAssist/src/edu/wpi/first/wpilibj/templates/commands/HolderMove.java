/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author FRC
 */
public class HolderMove extends CommandBase {
    double loadHeight = 1.5;
    double shootHeight = 4.0;
    double threshold = 0.1;
    double target = loadHeight;
    Joystick stick;
    public HolderMove(Joystick stick) {
        this.stick = stick;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*if (stick.getRawButton(5)){
            ballHolder.moveUp(stick.getZ());
        } else if (stick.getRawButton (4)){
            ballHolder.moveDown(stick.getZ());
        } */
        double holdPotVoltage = ballHolder.getAngle();
        //if (holdPotVoltage > 0) {
        System.out.println("Forklift wanted is " + stick.getZ() + 
                ". Forklift is currently at " + holdPotVoltage);
        //}
        
        if (stick.getRawButton(2)) {
            target = loadHeight;
            target += stick.getZ();
        } else if (stick.getRawButton(3)) {
            target = shootHeight;
            target += stick.getZ()/2;
        } 
             
        if (holdPotVoltage > target + threshold) {
            // Go down
            ballHolder.moveDown(1);
            System.out.println("Going Down. Target: " + target);
            SmartDashboard.putNumber("Revolution target", target);
        } else if (holdPotVoltage < target - threshold) {
            System.out.println("Going Up. Target: " + target);
            // Go up
            ballHolder.moveUp(1);
        } else {
            ballHolder.moveUp(0);
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
        ballHolder.moveUp(0);
    }
}
