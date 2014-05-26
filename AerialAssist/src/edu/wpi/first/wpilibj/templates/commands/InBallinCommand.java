/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//"Compiler says no" Steph Rowell 2014

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author FRC
 */
public class InBallinCommand extends CommandBase {

    Joystick stick;
    Joystick stick2;
    public InBallinCommand(Joystick stick, Joystick stick2){
        requires(revolutionWheel);
        this.stick = stick;
        this.stick2 = stick2;
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        if (stick.getRawButton(1)) {
            revolutionWheel.intakeIn(1);
        } else if (stick2.getRawButton(1)){
            revolutionWheel.intakeOut (1);
        } else {
            revolutionWheel.intakeIn(0);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    
    }

    protected void interrupted() {
        revolutionWheel.intakeStop();
    }
    
}
