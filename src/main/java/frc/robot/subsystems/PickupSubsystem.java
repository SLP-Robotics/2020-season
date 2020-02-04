/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Jaguar;

public class PickupSubsystem extends SubsystemBase {
  /**
   * Creates a new PickupSubsystem.
   */

  private Jaguar pickupMotor;

  public PickupSubsystem()
  {
    pickupMotor = new Jaguar(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Forward()
  {
    pickupMotor.set(1);
  }

  public void Backward()
  {
    pickupMotor.set(-1);
  }

  public void Stop()
  {
    pickupMotor.stopMotor();
  }
}
