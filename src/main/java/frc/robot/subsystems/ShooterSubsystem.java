/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */

   //private Jaguar[] shootMotors;
  
  public ShooterSubsystem() 
  {
    //shootMotors[0] = new Jaguar(3);
    //shootMotors[1] = new Jaguar(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot()
  {
    //shootMotors[0].set(0.5);
    //shootMotors[1].set(-0.5);
  }

  public void Stop()
  {
    //shootMotors[0].stopMotor();
    //shootMotors[1].stopMotor();
  }

  public void Reverse()
  {
    //shootMotors[0].set(-0.5);
    //shootMotors[1].set(0.5);
  }
}
