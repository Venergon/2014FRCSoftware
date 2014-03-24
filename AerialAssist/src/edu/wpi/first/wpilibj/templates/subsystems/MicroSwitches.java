/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author FRC
 */
public class MicroSwitches extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    DigitalInput bottomSwitch = new DigitalInput (1);
    DigitalInput topSwitch = new DigitalInput (2);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public boolean isBottomSwitchSet (){
        System.out.println("Bottom switch is ");
        System.out.println(bottomSwitch.get());
        return bottomSwitch.get();
    }
    public boolean isTopSwitchSet () {
        System.out.println("Top switch is ");
        System.out.println(topSwitch.get());
        return topSwitch.get();
    }
    
}
