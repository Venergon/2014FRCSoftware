/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author FRC
 */
public class RevolutionWheel extends Subsystem {
    Victor armWheels = new Victor (7);
    
    public void intakeIn(double speed) {
        armWheels.set(speed);
    }
    
    public void intakeOut(double speed) {
        armWheels.set(-speed);
    }
    
    public void intakeStop() {
        armWheels.set(0);
    }

    protected void initDefaultCommand() {
   
    }
}
