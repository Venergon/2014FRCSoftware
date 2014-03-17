/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//"Compiler says no" Steph Rowell 2014

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author FRC
 */
public class InBallinCommand extends CommandBase {

    public InBallinCommand(){
        requires(revolutionWheel);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        revolutionWheel.intakeIn(0.5);
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
