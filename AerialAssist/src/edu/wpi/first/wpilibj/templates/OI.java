
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ArcadeCommand;
import edu.wpi.first.wpilibj.templates.commands.ChangeToHigherAccel;
import edu.wpi.first.wpilibj.templates.commands.ChangeToHigherSpeed;
import edu.wpi.first.wpilibj.templates.commands.ChangeToLowerAccel;
import edu.wpi.first.wpilibj.templates.commands.ChangeToLowerSpeed;
import edu.wpi.first.wpilibj.templates.commands.HardKick;
import edu.wpi.first.wpilibj.templates.commands.HolderMove;
import edu.wpi.first.wpilibj.templates.commands.InBallinCommand;
import edu.wpi.first.wpilibj.templates.commands.KickerKick;
import edu.wpi.first.wpilibj.templates.commands.OneStickArcadeCommand;
import edu.wpi.first.wpilibj.templates.commands.RevolutionUp;
import edu.wpi.first.wpilibj.templates.commands.SoftKick;
import edu.wpi.first.wpilibj.templates.commands.TankCommand;
import edu.wpi.first.wpilibj.templates.commands.TurnToTarget;
import edu.wpi.first.wpilibj.templates.commands.TwoStickArcadeCommand;
import edu.wpi.first.wpilibj.templates.subsystems.BallHolder;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
     // number it is.
    Joystick stickLeft   = new Joystick(1);
    Joystick stickRight  = new Joystick(2);
    Joystick xbox        = new Joystick(3);
    Button button1       = new JoystickButton(stickLeft,  1);
    Button button2       = new JoystickButton(stickLeft,  2);
    Button button3       = new JoystickButton(stickLeft,  3);
    Button button4       = new JoystickButton(stickLeft,  4);
    Button button5       = new JoystickButton(stickLeft,  5);
    Button button6       = new JoystickButton(stickLeft,  6);
    Button button7       = new JoystickButton(stickLeft,  7);
    Button button8       = new JoystickButton(stickLeft,  8);
    Button button9       = new JoystickButton(stickLeft,  9);
    Button button10      = new JoystickButton(stickLeft,  10);
    Button button11      = new JoystickButton(stickLeft,  11);
    Button rightButton1  = new JoystickButton(stickRight, 1);
    Button rightButton2  = new JoystickButton(stickRight, 2);
    Button rightButton3  = new JoystickButton(stickRight, 3);
    Button rightButton4  = new JoystickButton(stickRight, 4);
    Button rightButton5  = new JoystickButton(stickRight, 5);
    Button rightButton6  = new JoystickButton(stickRight, 6);
    Button rightButton7  = new JoystickButton(stickRight, 7);
    Button rightButton8  = new JoystickButton(stickRight, 8);
    Button rightButton9  = new JoystickButton(stickRight, 9);
    Button rightButton10 = new JoystickButton(stickRight, 10);
    Button rightButton11 = new JoystickButton(stickRight, 11);
    Button a             = new JoystickButton(xbox,       1);
    Button b             = new JoystickButton(xbox,       2);
    Button x             = new JoystickButton(xbox,       3);
    Button y             = new JoystickButton(xbox,       4);
    Button lb            = new JoystickButton(xbox,       5);
    Button rb            = new JoystickButton(xbox,       6);
    Button L3            = new JoystickButton(xbox,       9);
    Button R3            = new JoystickButton(xbox,       10);
    
    
    public OI () {
        button1.whileHeld(new InBallinCommand(stickLeft, stickRight));
        //button2.whileHeld(new KickerKick(stickLeft.getZ()/4));
        button3.whenPressed(new TankCommand (stickLeft, stickRight));
        button4.whenPressed(new OneStickArcadeCommand(stickLeft));
        button5.whenPressed(new TwoStickArcadeCommand(stickRight, stickLeft));
        button6.whileHeld(new ChangeToHigherAccel());
        button7.whileHeld(new ChangeToLowerAccel());
        //button8.whenPressed(());
        //button9.whileHeld(new TurnToTarget(stickLeft));
        button10.whileHeld(new ChangeToLowerSpeed());
        button11.whileHeld(new ChangeToHigherSpeed());
        //rightButton1.whileHeld(new InBallinCommand (stickLeft, stickRight));
        //rightButton2.whileHeld(new RevolutionUp(stickRight));
        //rightButton3.whileHeld(new RevolutionUp(stickRight));
        //rightButton4.whileHeld(new HolderMove(stickRight));
        //rightButton5.whileHeld(new HolderMove(stickRight));
        //rightButton6.whenPressed();
        //rightButton7.whenPressed();
        //rightButton8.whenPressed(());
        //rightButton9.whenPressed(());
        //rightButton10.whenPressed(());
        //rightButton11.whenPressed(());
        a.whileHeld(new ChangeToLowerSpeed());
        b.whileHeld(new ChangeToHigherAccel());
        x.whileHeld(new ChangeToLowerAccel());
        y.whileHeld(new ChangeToHigherSpeed());
        //lb.whileHeld(new SoftKick(-1));
        //rb.whileHeld(new SoftKick(1));
        //L3.whileHeld(new HardKick(-1));
        //R3.whileHeld(new HardKick(1));
        
    }
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

