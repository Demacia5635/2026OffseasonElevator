// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.demacia.utils.Utilities;
import frc.demacia.utils.Controller.CommandController;
import frc.demacia.utils.constants.UtilsContants;
import frc.robot.ElevatorConstants.ElevatorConstants;
import frc.robot.subsystems.ElevatorSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ControllerElevator extends Command {
  /** Creates a new ControllerElevator. */
  ElevatorSubsystem elevatorSubsystem;
  CommandController controller;
  private double joyright;

  public ControllerElevator(CommandController controller, ElevatorSubsystem elevatorSubsystem) {
    this.controller = controller;
    this.elevatorSubsystem = elevatorSubsystem;
    addRequirements(elevatorSubsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    joyright = controller.getLeftY() * -1.0;
   // if (controller.getRightY() > UtilsContants.ControllerConstants.PS5_STICK_DEADBAND)
      elevatorSubsystem.setDuty(joyright);
      System.out.println("Duty = " + joyright);

  //  else
   //   elevatorSubsystem.setDuty(ElevatorConstants.powerToKeepHeight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
