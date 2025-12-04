// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.ElevatorConstants.ELEVATOR_STATE;
import frc.robot.subsystems.ElevatorSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ElevatorCommand extends Command {
  /** Creates a new ElevatorCommand. */
  private ElevatorSubsystem elevatorSubsystem;
  ELEVATOR_STATE currentState = ELEVATOR_STATE.IDLE;

  public ElevatorCommand(ElevatorSubsystem elevatorSubsystem) {
    this.elevatorSubsystem = elevatorSubsystem;
    addRequirements(elevatorSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      switch(elevatorSubsystem.getState()){
        case L1,L2,L3,MAXIMUM,MINIMUM:
        elevatorSubsystem.setHeight(elevatorSubsystem.getState().height);
        elevatorSubsystem.setState(ELEVATOR_STATE.IDLE);//need to use ff
        break;
        case IDLE:
        elevatorSubsystem.stop();//need to use ff
        break;
        default:
        elevatorSubsystem.setState(ELEVATOR_STATE.IDLE);
          elevatorSubsystem.stop();
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevatorSubsystem.stop();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
