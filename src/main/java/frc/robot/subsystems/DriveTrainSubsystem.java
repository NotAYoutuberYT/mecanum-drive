// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PortConstants;

public class DriveTrainSubsystem extends SubsystemBase {
  // constants
  private final static PortConstants constants = new PortConstants();

  // mecanum drive
  private MecanumDrive m_MecanumDrive;

  /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {
    // our neos
    CANSparkMax frontLeftNEO = new CANSparkMax(constants.driveTrainFrontLeftPort, MotorType.kBrushless);
    CANSparkMax frontRightNEO = new CANSparkMax(constants.driveTrainFrontRightPort, MotorType.kBrushless);
    CANSparkMax backLeftNeo = new CANSparkMax(constants.driveTrainBackLeftPort, MotorType.kBrushless);
    CANSparkMax backRightNeo = new CANSparkMax(constants.driveTrainBackRightPort, MotorType.kBrushless);

    frontLeftNEO.setInverted(true);
    backLeftNeo.setInverted(true);

    m_MecanumDrive = new MecanumDrive(frontLeftNEO, backLeftNeo, frontRightNEO, backRightNeo);
  }

  public void drive(double forward, double lateral, double rotation) {
    m_MecanumDrive.driveCartesian(forward, lateral, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
