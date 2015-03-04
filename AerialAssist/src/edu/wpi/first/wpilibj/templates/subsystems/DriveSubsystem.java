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
    RobotDrive driveTrain = new RobotDrive(1,3);
    RobotDrive driveTrain2 = new RobotDrive(2,4);
    double leftVelocity = 0;
    double rightVelocity = 0;
    double forwardVelocity = 0;
    double turnVelocity = 0;
    double acceleration = .5;
    double speedCoefficient = 1;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void lowerSpeed(){
        speedCoefficient = 0.5;
        acceleration = 1;
    }
    
    public void higherSpeed(){
        speedCoefficient = 1;
        acceleration = 0.05;
    }
    
    public void lowerAccel(){
        acceleration = 0.1;
    }
    
    public void higherAccel(){
        acceleration = 1;
    }
    
    public void tankDrive (double rightSpeed, double leftSpeed){
        if ((leftSpeed < 0.1) && (leftSpeed > -0.1)) {
            leftSpeed = 0;
        }
        if ((rightSpeed < 0.1) && (rightSpeed > -0.1)){
            rightSpeed = 0;
        }
        
        if (((rightSpeed < 0) && (rightVelocity > 0) || (rightSpeed > 0) && (rightVelocity < 0))){
            rightVelocity = 0;
        }
        
        if (((leftSpeed < 0) && (leftVelocity > 0) || (leftSpeed > 0) && (leftVelocity < 0))){
            leftVelocity = 0;
        }
        
        if (Math.abs(leftSpeed) < Math.abs(leftVelocity)){
            leftVelocity = leftSpeed;
        }
        
        if (Math.abs(rightSpeed) < Math.abs(rightVelocity)){
            rightVelocity = rightSpeed;
        }
        
        leftVelocity += (leftSpeed-leftVelocity)*acceleration;
        rightVelocity += (rightSpeed-rightVelocity)*acceleration;
        forwardVelocity = 0;
        turnVelocity = 0;
        driveTrain.tankDrive(-leftVelocity*speedCoefficient, -rightVelocity*speedCoefficient);
        driveTrain2.tankDrive(-leftVelocity*speedCoefficient, -rightVelocity*speedCoefficient);
        SmartDashboard.putNumber ("leftspeed", leftSpeed);
        SmartDashboard.putNumber ("rightspeed", rightSpeed);
    } 
    public void arcadeDrive (double turnRate, double speed){
       /* System.out.println("the speed is" + speed 
                + ", the turn " + turnRate); */
        if ((speed < 0.1) && (speed > -0.1)) {
            speed = 0;
        }
        if ((turnRate < 0.1) && (turnRate > -0.1)){
            turnRate = 0;
        }
        if (((speed < 0) && (forwardVelocity > 0) || (speed > 0) && (forwardVelocity < 0))){
            forwardVelocity = 0;
        }
        if (((turnRate < 0) && (turnVelocity > 0) || (turnRate > 0) && (turnVelocity < 0))){
            turnVelocity = 0;
        }
        if ((Math.abs(speed) < Math.abs(forwardVelocity))){
            forwardVelocity = speed;
        }
        if (Math.abs(turnRate) < Math.abs(turnVelocity)){
            turnVelocity = turnRate;
        }
        forwardVelocity += (speed-forwardVelocity)*acceleration;
        turnVelocity += (turnRate-turnVelocity)*acceleration;
        leftVelocity = 0;
        rightVelocity = 0;
        SmartDashboard.putNumber ("speed", speed);
        SmartDashboard.putNumber ("turn", turnRate);
        driveTrain.arcadeDrive(-forwardVelocity*speedCoefficient, turnVelocity*speedCoefficient);
        driveTrain2.arcadeDrive(-forwardVelocity*speedCoefficient, turnVelocity*speedCoefficient);
    }
    public void stop (){
        driveTrain.drive(0.0f,0.0f);
        driveTrain2.drive(0.0f,0.0f);
    }
}
