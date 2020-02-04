/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PickupSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveSubsystem m_driveTrain = new DriveSubsystem();

  private final PickupSubsystem m_PickupSubsystem = new PickupSubsystem();

  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();

//  private final XboxController m_controller = new XboxController(0);
  private final Joystick m_primaryTank = new Joystick(0);
  private final Joystick m_primaryTurn = new Joystick(1);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    System.out.println("Creating RobotContainer");

    // Configure the button bindings
    configureButtonBindings();

    m_driveTrain.setDefaultCommand(
      new RunCommand(
//        () -> m_driveTrain.drive(m_controller.getY(Hand.kLeft), m_controller.getX(Hand.kLeft)),
        () -> m_driveTrain.drive(m_primaryTank.getY(), m_primaryTurn.getX()),
        m_driveTrain
      )
    );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton intakeButton = new JoystickButton(m_primaryTank, 5);
    JoystickButton shooterButton = new JoystickButton(m_primaryTank, 1);
    JoystickButton reverseIntake = new JoystickButton(m_primaryTank, 4);

    intakeButton.whenPressed(() -> m_PickupSubsystem.Forward());
    intakeButton.whenReleased(() -> m_PickupSubsystem.Stop());
    reverseIntake.whenReleased(() -> m_PickupSubsystem.Stop());
    reverseIntake.whenPressed(() -> m_PickupSubsystem.Backward());

    //shooterButton.whenPressed(() -> m_ShooterSubsystem)

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }


}
