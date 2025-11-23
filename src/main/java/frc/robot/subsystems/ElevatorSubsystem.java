// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.Motors.TalonMotor;
import frc.demacia.utils.Sensors.LimitSwitch;
import frc.robot.ElevatorConstants;
import frc.robot.ElevatorConstants.ELEVATOR_STATE;
public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */
  private final TalonMotor motor1;
  private final TalonMotor motor2;

  private final LimitSwitch limitSwitchUp;
  private final LimitSwitch limitSwitchDown;
  public ELEVATOR_STATE state;

  public ElevatorSubsystem() {
    limitSwitchUp = new LimitSwitch(ElevatorConstants.LIMIT_SWITCH_UP_CONFIG);
    limitSwitchDown= new LimitSwitch(ElevatorConstants.LIMIT_SWITCH_DOWN_CONFIG);
    motor1 = new TalonMotor(ElevatorConstants.TALON_CONFIG1);
    motor2 = new TalonMotor(ElevatorConstants.TALON_CONFIG2);

    state = ELEVATOR_STATE.IDLE;
    addNT();
  }
    public void addNT(){
      SendableChooser<ELEVATOR_STATE> stateChooser = new SendableChooser<>();
      stateChooser.addOption("L1", ELEVATOR_STATE.L1);
      stateChooser.addOption("L2", ELEVATOR_STATE.L2);
      stateChooser.addOption("L3", ELEVATOR_STATE.L3);
      stateChooser.addOption("L4", ELEVATOR_STATE.L4);
      stateChooser.addOption("DEFAULT", ELEVATOR_STATE.DEFAULT);
      stateChooser.addOption("IDLE", ELEVATOR_STATE.IDLE);

}
    public boolean getLowerLimit(){
      return limitSwitchDown.get();
    }
    public boolean getUpperLimit(){
      return limitSwitchUp.get();
    }
   
    
    public void resetEncoders(){
      motor1.setEncoderPosition(0);
      motor2.setEncoderPosition(0);
    }
    public void stop(){
      motor1.stopMotor();
      motor2.stopMotor();
    }
    public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    builder.addBooleanProperty("upper limit switch ", () -> getUpperLimit(), null);
    builder.addBooleanProperty("lower limit switch", () -> getLowerLimit(), null);
  }
   
  public void setMotion(double distance){
    motor1.setMotion(distance);
    motor2.setMotion(distance);
  }



  public ELEVATOR_STATE getState() {
    return state;
  }
@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

