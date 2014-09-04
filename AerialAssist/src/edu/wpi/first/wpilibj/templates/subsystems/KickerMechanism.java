/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author FRC
 */
public class KickerMechanism extends Subsystem {
    Talon kicker1 = new Talon (7); 
    Talon kicker2 = new Talon (8);
    DigitalInput bottomSwitch = new DigitalInput (1);
    DigitalInput topSwitch = new DigitalInput (2);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void kick(double speed){
        kicker1.set (-speed);
        kicker2.set (-speed);
    }
    public void liftUp(double speed){
        kicker1.set (speed);
        kicker2.set (speed);
    }
   
    public boolean isBottomSwitchSet (){
        System.out.print("Bottom switch is ");
        System.out.println(bottomSwitch.get());
        SmartDashboard.putBoolean("Finishing Switch", bottomSwitch.get());
        return bottomSwitch.get();
    }
    public boolean isTopSwitchSet () {
        System.out.print("Top switch is ");
        System.out.println(topSwitch.get());
        SmartDashboard.putBoolean("Starting Switch", topSwitch.get());
        return topSwitch.get();
    }
}
