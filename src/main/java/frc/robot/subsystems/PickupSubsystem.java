/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Talon;

public class PickupSubsystem extends SubsystemBase {
  /**
   * Creates a new PickupSubsystem.
   */

  private Talon pickupMotor;

  public PickupSubsystem()
  {
    pickupMotor = new Talon(2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Forward()
  {
    pickupMotor.set(0.5);
  }

  public void Backward()
  {
    pickupMotor.set(-0.5);
  }

  public void Stop()
  {
    pickupMotor.stopMotor();
  }

  public void Move(double speed)
  {
    if(speed < 0.6)
    {
      pickupMotor.set(speed);
    }
    else if(speed >= 0.6)
    {
      pickupMotor.set(0.6);
    }
    
  }
}
