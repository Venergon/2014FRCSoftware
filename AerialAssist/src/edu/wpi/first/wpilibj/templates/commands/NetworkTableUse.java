/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author FRC
 */
public class NetworkTableUse extends CommandBase {
    edu.wpi.first.wpilibj.networktables.NetworkTable table;    

    public NetworkTableUse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        table = edu.wpi.first.wpilibj.networktables.NetworkTable.getTable ("SmartDashboard");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
                while (true){
            System.out.println (table.getNumber("SHAPE_SIZE"));
            SmartDashboard.putNumber("Shape Size", table.getNumber("SHAPE_SIZE"));
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    public double shapeXAxis() {
        System.out.println (table.getNumber ("SHAPE_X_COORD"));
        return (table.getNumber ("SHAPE_X_COORD"));
    }
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
}
