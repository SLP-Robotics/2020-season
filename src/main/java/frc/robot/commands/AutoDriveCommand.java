/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class AutoDriveCommand extends CommandBase {
  /**
   * Creates a new AutoDriveCommand.
   */

   private DriveSubsystem m_drive;

   private Timer m_timer = new Timer();

  public AutoDriveCommand(DriveSubsystem drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);

    m_drive = drive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return m_timer.get() > 15;
  }
}
