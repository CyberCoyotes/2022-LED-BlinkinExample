/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.PWMPorts;
import frc.robot.commands.driveCommand;
import frc.robot.subsystems.blinkin;
import frc.robot.subsystems.driveSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  //private final driveSubsystem m_driveSubsystem = new driveSubsystem();
  //private final addressableLED m_addressableLED = new addressableLED(PWMPorts.kAddressableLED);
  public static final blinkin m_blinkin = new blinkin(PWMPorts.kBlinkin);

  // Commands
  //private final driveCommand m_driveCommand = new driveCommand(m_driveSubsystem);
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public static XboxController m_driveController = new XboxController(DriveConstants.k_driveController);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //m_driveSubsystem.setDefaultCommand(m_driveCommand);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton abutton = new JoystickButton(m_driveController, Button.kA.value);
    final JoystickButton bbutton = new JoystickButton(m_driveController, Button.kB.value);
    final JoystickButton xbutton = new JoystickButton(m_driveController, Button.kX.value);
    final JoystickButton ybutton = new JoystickButton(m_driveController, Button.kY.value);

    // abutton.whileHeld(() -> m_addressableLED.rainbow(), m_addressableLED);
    abutton.whenPressed(() -> m_blinkin.set(0.65), m_blinkin);    // Orange
    bbutton.whenPressed(() -> m_blinkin.set(-0.99), m_blinkin);   // Rainbow
    xbutton.whenPressed(() -> m_blinkin.set(-0.35), m_blinkin);   // Red Scanner
    ybutton.whenPressed(() -> m_blinkin.set(0.93), m_blinkin);    // White
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // for now return an empty, do nothing, command
    return new InstantCommand();
  }
}
