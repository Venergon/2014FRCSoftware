
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ArcadeCommand;
import edu.wpi.first.wpilibj.templates.commands.ForkliftLift;
import edu.wpi.first.wpilibj.templates.commands.InBallinCommand;
import edu.wpi.first.wpilibj.templates.commands.OneStickArcadeCommand;
import edu.wpi.first.wpilibj.templates.commands.TankCommand;
import edu.wpi.first.wpilibj.templates.commands.TwoStickArcadeCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick stickLeft = new Joystick(1);
    Joystick stickRight = new Joystick(2);
    Button button1 = new JoystickButton(stickLeft, 1);
    Button button2 = new JoystickButton(stickLeft, 2);
    Button button3 = new JoystickButton(stickLeft, 3);
    Button button4 = new JoystickButton(stickLeft, 4);
    Button button5 = new JoystickButton(stickLeft, 5);
    Button button6 = new JoystickButton(stickLeft, 6);
    Button button7 = new JoystickButton(stickLeft, 7);
    Button button8 = new JoystickButton(stickLeft, 8);
    Button button9 = new JoystickButton(stickLeft, 9);
    Button button10 = new JoystickButton(stickLeft, 10);
    Button button11 = new JoystickButton(stickLeft, 11);
    
    public OI () {
        button1.whenPressed(new InBallinCommand());
        //button2.whenPressed(());
        button3.whenPressed(new TankCommand (stickLeft, stickRight));
        button4.whenPressed(new OneStickArcadeCommand(stickLeft));
        button5.whenPressed(new TwoStickArcadeCommand(stickLeft, stickRight));
        //button6.whenPressed(());
        //button7.whenPressed(());
        //button8.whenPressed(());
        //button9.whenPressed(());
        button10.whenPressed(new ForkliftLift(stickLeft));
        button11.whenPressed(new ForkliftLift(stickLeft));
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

