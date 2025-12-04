// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Sensors.LimitSwitch;
import frc.robot.ElevatorConstants;
import frc.robot.ElevatorConstants.ELEVATOR_STATE;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */
  private final TalonMotor motor1;

  private final LimitSwitch limitSwitch;
  public ELEVATOR_STATE state;

  public ElevatorSubsystem() {
    limitSwitch = new LimitSwitch(ElevatorConstants.LIMIT_SWITCH);
    motor1 = new TalonMotor(ElevatorConstants.TALON_CONFIG1);

    state = ELEVATOR_STATE.IDLE;
    addNT();
  }

  public void addNT() {
    SendableChooser<ELEVATOR_STATE> stateChooser = new SendableChooser<>();
    stateChooser.addOption("L1", ELEVATOR_STATE.L1);
    stateChooser.addOption("L2", ELEVATOR_STATE.L2);
    stateChooser.addOption("L3", ELEVATOR_STATE.L3);
    stateChooser.addOption("IDLE", ELEVATOR_STATE.IDLE);
    stateChooser.onChange(newState -> this.state = newState);
    SmartDashboard.putData(getName() + "Elevator State Chooser", stateChooser);

  }
  public void setMotorPosition(double positon) {
    motor1.setEncoderPosition(positon);
}

 
  public boolean getLimit() { //need to find a way to seperate the upper magnet and the lower magnet
    return limitSwitch.get();
  }

  public void resetEncoder() {
    motor1.setEncoderPosition(0);
  }

  public void stop() {
    motor1.stopMotor();
  }

  public void setHeight(double height) {
    motor1.setMotion(height);
  }

  public void setState(ELEVATOR_STATE state) {
    this.state = state;
  }
  public void setDuty(double duty) {
    motor1.setDuty(duty);
  }

  public ELEVATOR_STATE getState() {
    return state;
  }

  public double getCurrentHeight() {
    return motor1.getCurrentPosition();
  }
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    builder.addBooleanProperty("limit switch ", () -> getLimit(), null);
    builder.addDoubleProperty("Current Height", () -> getCurrentHeight(), null);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
