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
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.PWMPorts;
import frc.robot.commands.driveCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.blinkinSubsystem;
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
  public static final blinkinSubsystem m_blinkin = new blinkinSubsystem(PWMPorts.kBlinkin);

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
    final JoystickButton l1button = new JoystickButton(m_driveController, Button.kLeftBumper.value);
    final JoystickButton r1button = new JoystickButton(m_driveController, Button.kRightBumper.value);
    final JoystickButton startbutton = new JoystickButton(m_driveController, Button.kStart.value);

    // abutton.whileHeld(() -> m_addressableLED.rainbow(), m_addressableLED);
    abutton.onTrue(Commands.run(() -> m_blinkin.darkBlue(), m_blinkin));
    bbutton.onTrue(Commands.run(() -> m_blinkin.darkRed(), m_blinkin));
    xbutton.onTrue(Commands.run(() -> m_blinkin.chase_blue(), m_blinkin));
    ybutton.onTrue(Commands.run(() -> m_blinkin.chase_red(), m_blinkin));
    l1button.onTrue(Commands.run(() -> m_blinkin.gold(), m_blinkin));
    r1button.onTrue(Commands.run(() -> m_blinkin.violet(), m_blinkin));
    startbutton.onTrue(Commands.run(() -> m_blinkin.wave_ocean(), m_blinkin));

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
