/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Segway
 */
public class DriveSubsystem extends Subsystem {
    RobotDrive driveTrain = new RobotDrive(1,2);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void tankDrive (double leftSpeed, double rightSpeed){
        driveTrain.tankDrive(leftSpeed, rightSpeed);
        SmartDashboard.putNumber ("leftspeed", leftSpeed);
        SmartDashboard.putNumber ("rightspeed", rightSpeed);
    } 
    public void arcadeDrive (double speed, double turnRate){
       /* System.out.println("the speed is" + speed 
                + ", the turn " + turnRate); */
        SmartDashboard.putNumber ("speed", speed);
        SmartDashboard.putNumber ("turn", turnRate);
        driveTrain.arcadeDrive(turnRate, speed);
    }
    public void stop (){
        driveTrain.drive(0.0f,0.0f);
    }
}
