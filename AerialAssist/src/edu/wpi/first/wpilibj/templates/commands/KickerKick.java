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
public class KickerKick extends CommandBase {
    Joystick stick;
    double speed;
    int state = 1;
    Timer timer;
    
    
    public KickerKick(Joystick stick) {
        requires (kickerMechanism);
        this.stick = stick;
        timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Kicker started");
        SmartDashboard.putNumber("Kicker State", state);
        state = 1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        speed = stick.getZ()/4;
        if (state == 1) { //Gain momentum so that the hammer can swing up to the top
            if (kickerMechanism.isBottomSwitchSet()== true) {
                state = 2; 
                System.out.println("State 2");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(0.4);
        } else if (state == 2) { //Reverse the hammer to take it up to the top
            if (kickerMechanism.isTopSwitchSet()== true) {
                state = 3;
                System.out.println("State 3");
                SmartDashboard.putNumber("Kicker State", state);
                timer.reset();
                timer.start();
            }
            kickerMechanism.liftUp(0.8);
        } else if (state == 3) {
                System.out.println(timer.get());
            if (timer.get() > 0.5) {
                state = 4;
                System.out.println("State 4");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(0);
        } else if (state == 4) { // Main kick, swing the hammer to hit the ball
            if (kickerMechanism.isBottomSwitchSet()== true) {
                timer.reset();
                timer.start();
                state = 5;
                System.out.println("State 5");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(1);
        } else if (state == 5) { //The follow through
            System.out.println(timer.get());
            if (timer.get() > 0.75) {
                state = 6; 
                System.out.println("State 6");
                SmartDashboard.putNumber("Kicker State", state);
            }
            kickerMechanism.kick(0);
        } else { //Finishing the kick and letting the hammer drop down to neutral position
            kickerMechanism.kick(0);
        }
        
        /*while (microSwitches.isBottomSwitchSet()== false) {
            kickerMechanism.kick(-speed);
        } while (microSwitches.isTopSwitchSet() == false){
            kickerMechanism.kick(speed);
        */
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (state == 6);
    }

    // Called once after isFinished returns true
    protected void end() {
        kickerMechanism.kick(0);
        state = 1;
        SmartDashboard.putNumber("Kicker State",state);
        System.out.println("Kicker sequence complete");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        kickerMechanism.kick(0);
        timer.stop();
        timer.reset();
        state = 1;
        System.out.println("Kicker Interrupted");
    }
}
