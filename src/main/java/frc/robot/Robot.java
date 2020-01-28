/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

//import java.util.logging.LogManager;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.controller.PIDController;
//import edu.wpi.first.wpilibj;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private DifferentialDrive m_robotDrive;

  private final XboxController m_controller = new XboxController(0);

  private final Timer m_timer = new Timer();

  private final CAN m_can = new CAN(0, 5, 2);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    /*final SpeedController m_frontLeft = new PWMVictorSPX(0)
    final SpeedController m_rearLeft = new PWMVictorSPX(1);
    final SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    final SpeedController m_frontRight = new PWMVictorSPX(2);
    final SpeedController m_rearRight = new PWMVictorSPX(3);
    final SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);*/

    //m_robotDrive = new DifferentialDrive(left, right);
    //m_robotDrive.feedWatchdog();


  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
        m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
        m_robotDrive.stopMotor(); // stop robot
    }
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    
    CommandScheduler.getInstance().cancelAll();
    System.out.println("Initialized! <3");
  }

  /**
   * This function is called periodically during test mode.
   */
   //UP IS NEGATIVE DOWN IS POSITIVE
   //RIGHT IS POSITIVE LEFT IS NEGATIVE
  @Override
  public void testPeriodic() {
    m_robotDrive.feed();
     if(m_controller.getAButtonPressed()) 
     {
       System.out.println("A Button Pressed!");

     }
     m_robotDrive.tankDrive(m_controller.getY(Hand.kLeft), m_controller.getY(Hand.kRight));
  }
}
