/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GunRotationSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class HighGoalCommand extends CommandBase {
  /**
   * Creates a new HighGoalCommand.
   */

   ShooterSubsystem m_shooter;
   GunRotationSubsystem m_rotation;

   public boolean running;

   private DigitalInput limitSwitch = new DigitalInput(0);

  Timer m_timer;

  public HighGoalCommand(ShooterSubsystem shooter, GunRotationSubsystem rotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    addRequirements(rotation);

    m_shooter = shooter;
    m_rotation = rotation;

    m_timer = new Timer();
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
    m_shooter.Foward();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!limitSwitch.get())
      m_rotation.Up();
    else
      m_rotation.Stop();

    if(m_timer.get() <= 6 && running)
      m_shooter.Shoot();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.Stop();
    m_shooter.StopConveyor();
    m_rotation.Stop();
    m_timer.stop();
    m_timer.reset();

    running = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(running)
      return true;
    return false;
  }
}
