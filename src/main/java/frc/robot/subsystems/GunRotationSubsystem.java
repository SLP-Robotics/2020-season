/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;

public class GunRotationSubsystem extends SubsystemBase {
  /**
   * Creates a new GunRotationSubsystem.
   */

   private final Jaguar m_motor = new Jaguar(1);

  public GunRotationSubsystem() {

    System.out.println("Calibrated");

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    }

  //Minimum 28.03
  //Maximum 55.5
  //Set the motor to rotate the gun up
  public void Up()
  {
    m_motor.set(0.3);
  }

  //Set the motor to rotate the gun down
  public void Down()
  {
    m_motor.set(-0.3);
  }

  //Stop the motor
  public void Stop()
  {
    m_motor.stopMotor();
  }
}
