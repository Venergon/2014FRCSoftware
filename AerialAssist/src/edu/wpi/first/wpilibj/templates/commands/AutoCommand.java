/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author FRC
 */
public class AutoCommand extends CommandBase {
    Timer timer;
    int state = 2;
    
    public AutoCommand() {
        requires (kickerMechanism);
        timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
        state = 2;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while((timer.get() < 6) && ((networkTableUse.shapeXAxis() < 250) || (networkTableUse.shapeXAxis() > 350)) ){
            
        }
        /*while (kickerMechanism.isBottomSwitchSet() == false) {
            kickerMechanism.kick(.25);
        }*/
        while (state == 1) { //Gain momentum so that the hammer can swing up to the top
            if (kickerMechanism.isBottomSwitchSet()== true) {
                state = 2; 
                System.out.println("State 2");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(0.4);
        } 
        while (state == 2) { //Reverse the hammer to take it up to the top
            if (kickerMechanism.isTopSwitchSet()== true) {
                state = 3;
                System.out.println("State 3");
                SmartDashboard.putNumber("Kicker State", state);
                timer.reset();
                timer.start();
            }
            kickerMechanism.liftUp(0.5);
        }
        while (state == 3) {
            System.out.println(timer.get());
            if (timer.get() > 0.5) {
                state = 4;
                System.out.println("State 4");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(0);
        }
        while (state == 4) { // Main kick, swing the hammer to hit the ball
            if (kickerMechanism.isBottomSwitchSet()== true) {
                timer.reset();
                timer.start();
                state = 5;
                System.out.println("State 5");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(1);
        }
        while (state == 5) { //The follow through
            System.out.println(timer.get());
            if (timer.get() > 0.75) {
                state = 6; 
                System.out.println("State 6");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(0);
        }
        kickerMechanism.kick(0);
        timer.reset();
        timer.start();
        while(timer.get() < 2) {
            driveSubsystem.tankDrive (1,1);
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
}
