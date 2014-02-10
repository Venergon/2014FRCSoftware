/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Segway
 *
public class GreasyDrive extends CommandBase {
    private Joystick stick;
    public GreasyDrive(Joystick stick) {
        requires(gyroSubsystem);
        requires(robotDriveSubsystem);
        this.stick = stick;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gyroSubsystem.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double yAxis = stick.getY();
        double xAxis = stick.getX();
        double angle = Math.toDegrees(arctan(yAxis, xAxis));
        double speed = 0.5;
        SmartDashboard.getNumber("Wanted Angle", angle);
        System.out.println ("wanted angle " + angle);
        
        if (gyroSubsystem.read() < angle-5){
            robotDriveSubsystem.drive(speed, -speed);
        } else if (gyroSubsystem.read() > angle+5){
            robotDriveSubsystem.drive (-speed,speed);
        } else {
           robotDriveSubsystem.drive(speed, speed);
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
    }
    
    private double arctan(double opp, double adj)
    {
        double z = opp/adj;
        double result = (z -
                (z*z*z)/3 +
                (z*z*z*z*z)/5 -
                (z*z*z*z*z*z*z)/7 +
                (z*z*z*z*z*z*z*z*z)/9 -
                (z*z*z*z*z*z*z*z*z*z*z)/11 +
                (z*z*z*z*z*z*z*z*z*z*z*z*z)/13);
        return result;
    }
    
}*/