/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author FRC
 */
public class RevolutionLift extends Subsystem {
    Talon arm = new Talon(6);
    AnalogChannel revPot = new AnalogChannel(1);
    protected void initDefaultCommand() {
        //throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
        //"Compiler says no" Sir Auron 2014
    
    public void moveUp(double speed) {
        arm.set(speed);
    }
    
    public void moveDown(double speed) {
        arm.set(-speed);
    }

    public void armStop() {
        arm.set(0);
    }
    public double getAngle() {
        return revPot.getVoltage();
    }

}
