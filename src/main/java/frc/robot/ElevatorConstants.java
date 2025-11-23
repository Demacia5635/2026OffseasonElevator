package frc.robot;

import frc.demacia.utils.Motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.Sensors.LimitSwitchConfig;
import frc.demacia.utils.Motors.TalonConfig;

public class ElevatorConstants {
    public static final int motor1_ID = 0;
    public static final Canbus CANBUS = Canbus.CANIvore;
    public static final int motor2_ID = 0;
    public static final double MAX_VELOCITY = 3;
    public static final double MAX_ACCELERATION = 0;
    public static final double MAX_JERK = 0;
    public static final double DIAMETER_1 = 0;
    public static final double DIAMETER_2 = 0;
    public static final double GEAR_RATIO_1 = 0;
    public static final double GEAR_RATIO_2 = 0; 
    public static final double MAX_CURRENT = 0;
    public static final int limitSwitchUpChannel = 1;
    public static final int limitSwitchDownChannel =2;

    
    
    public static final LimitSwitchConfig LIMIT_SWITCH_UP_CONFIG = new LimitSwitchConfig(limitSwitchUpChannel,null);

    public static final LimitSwitchConfig LIMIT_SWITCH_DOWN_CONFIG = new LimitSwitchConfig(limitSwitchDownChannel, null);

    public static final TalonConfig TALON_CONFIG1 = new TalonConfig(motor1_ID, CANBUS, null)
    .withBrake(true)
    .withMeterMotor(GEAR_RATIO_1, DIAMETER_1)
    .withMotionParam(MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK)
    .withCurrent(MAX_CURRENT);


    public static final TalonConfig TALON_CONFIG2 = new TalonConfig(motor2_ID, CANBUS, null)
    .withBrake(true)
    .withMeterMotor(GEAR_RATIO_2, DIAMETER_2)
    .withPID(0, 0, 0, 0, 0, 0, 0)
    .withMotionParam(MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK)
    .withCurrent(MAX_CURRENT);



public static enum ELEVATOR_STATE{
    IDLE(0),
    L1(0),
    L2(0),
    L3(0),
    L4(0),
    DEFAULT(0);

public double height;
ELEVATOR_STATE(double height){
    this.height=height;
        }
    }
}



