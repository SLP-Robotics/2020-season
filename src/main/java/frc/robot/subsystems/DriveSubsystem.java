/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */

   private WPI_VictorSPX leftMaster;
   private WPI_VictorSPX rightMaster;
   private WPI_VictorSPX leftFollower;
   private WPI_VictorSPX rightFollower;

   private SpeedControllerGroup left;
   private SpeedControllerGroup right;

   private DifferentialDrive m_drive;

   //0 and 3 are left
   //1 and 4 are right

  public DriveSubsystem() {
    leftMaster = new WPI_VictorSPX(2);
    leftFollower = new WPI_VictorSPX(0);

    rightMaster = new WPI_VictorSPX(3);
    rightFollower = new WPI_VictorSPX(1);

    leftMaster.configFactoryDefault();
    leftFollower.configFactoryDefault();
    rightMaster.configFactoryDefault();
    rightFollower.configFactoryDefault();

    leftMaster.setNeutralMode(NeutralMode.Coast);
    rightMaster.setNeutralMode(NeutralMode.Coast);
    rightFollower.setNeutralMode(NeutralMode.Coast);
    leftFollower.setNeutralMode(NeutralMode.Coast);


    left = new SpeedControllerGroup(leftMaster, leftFollower);
    right = new SpeedControllerGroup(rightMaster, rightFollower);

    m_drive = new DifferentialDrive(left, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double x, double y)
  {
    m_drive.arcadeDrive(x, y);
    System.out.println(x + " " + y);
  }
}
