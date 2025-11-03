// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Sensors.LimitSwitch;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */
  private final TalonFX motor1;
  private final TalonFX motor2;
  private final Ultrasonic UltrasonicSensor;
  private final LimitSwitch limitSwitch;
  public ElevatorSubsystem() {
    motor1 = new TalonFX(0);
    motor2 = new TalonFX(0);
    UltrasonicSensor = new Ultrasonic(0, 1);
    limitSwitch = new LimitSwitch(null);
  }

@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

