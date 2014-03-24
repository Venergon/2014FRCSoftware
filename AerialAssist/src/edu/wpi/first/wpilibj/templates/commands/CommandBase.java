package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.KickerMechanism;
import edu.wpi.first.wpilibj.templates.subsystems.MicroSwitches;
import edu.wpi.first.wpilibj.templates.subsystems.RevolutionLift;
import edu.wpi.first.wpilibj.templates.subsystems.RevolutionWheel;

//"Compiler says no" Sir Galen 2014

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    //"Compiler says no" Steph McArowell 2014
    
    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static DriveSubsystem driveSubsystem = new DriveSubsystem();
    //public static ForkLift forkLift = new ForkLift();
    //public static ForkLift2 forkLift2 = new ForkLift2();
    public static RevolutionLift revolutionLift = new RevolutionLift();
    public static RevolutionWheel revolutionWheel = new RevolutionWheel();
    public static KickerMechanism kickerMechanism = new KickerMechanism();
    public static MicroSwitches microSwitches = new MicroSwitches();
    
    //"Compiler says no" Sir Gauron 2014
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
