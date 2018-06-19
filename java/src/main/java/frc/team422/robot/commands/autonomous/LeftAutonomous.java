package frc.team422.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team422.robot.commands.*;
import java.lang.String;

public class LeftAutonomous extends CommandGroup {

    public LeftAutonomous(String gameData, boolean scale) {
        addSequential(new GuillotineHold());
        addSequential(new IntakeGrab());
        if (gameData.charAt(1) == 'L' && scale) {
            addSequential(new DriveStraight(275.975f, 0.9f, true, 8.0f));
            addSequential(new Turn(90.0d, 0.7f, 3.0f));
            addSequential(new IntakeRelease());
            addSequential(new GuillotineRaise());
            addSequential(new DriveStraight(1, 0.3f, false, 1.5f));
            addSequential(new DriveStraight(16, 0.5f, true, 1.5f));
            addSequential(new GuillotineKick());
            addSequential(new ArduinoControllerSendCommand());
            addSequential(new DriveStraight(1, 0.3f, true, 1.5f));
            addSequential(new DriveStraight(16, 0.3f, false, 1.5f));
        } else if (gameData.charAt(1) == 'R' && scale) {
            addSequential(new DriveStraight(190.438, 0.9, true, 40));
            addSequential(new Turn(90.0d, 0.7, 40));
            addSequential(new DriveStraight(164.625, 0.9, true, 40));
            addSequential(new Turn(-90.0d, 0.7, 40));
            addParallel(new IntakeRelease());
            addSequential(new GuillotineRaise());
            addSequential(new DriveStraight(1, 0.3, false, 0.5f));
            addSequential(new DriveStraight(52.057, 0.5, true, 1.0d));
            addSequential(new GuillotineKick());
            addSequential(new ArduinoControllerSendCommand());
            addSequential(new DriveStraight(1, 0.3d, true, 1.5d));
            addSequential(new DriveStraight(16, 0.3d, false, 1.5d));
        } else if (gameData.charAt(0) == 'L') {
            // Left-side switch
            addSequential(new DriveStraight(132.275d, 0.9d, true, 6.0d));
            addSequential(new Turn(90.0d, 0.7d, 3.0d));
            addSequential(new GuillotineKick());
            addSequential(new PivotIntakeDown(0.2d));
            addSequential(new IntakeArmsOut());
            addSequential(new ArduinoControllerSendCommand());
            addSequential(new WaitCommand(4));
            addSequential(new IntakeArmsStop());
        } else {
            // Right-side switch
            addSequential(new DriveStraight(187.53, 0.9d, true, 8.0d));
            addSequential(new Turn(90.0d, 0.7d, 3.0d));
            addSequential(new DriveStraight(187.534, 0.9d, true, 1.5d));
            addSequential(new Turn(90.0d, 0.7d, 3.0d));
            addSequential(new DriveStraight(1, 0.3d, false, 1.5d));
            addSequential(new DriveStraight(42.0d, 0.3d, true, 1.0d));
            addSequential(new GuillotineKick());
            addSequential(new PivotIntakeDown(0.1));
            addSequential(new IntakeArmsOut());
            addSequential(new ArduinoControllerSendCommand());
            addSequential(new WaitCommand(3));
            addSequential(new IntakeArmsStop());
        }
    }

}
