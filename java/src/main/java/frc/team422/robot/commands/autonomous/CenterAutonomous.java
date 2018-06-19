package frc.team422.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team422.robot.commands.*;

public class CenterAutonomous extends CommandGroup{

    public CenterAutonomous(char c) {
        addSequential(new GuillotineHold());
        addSequential(new IntakeGrab());
        if (c == 'L') {
            // Score on the left side on the front of the switch
            addSequential(new DriveStraight(10.968, 0.5, true, 5));
            addSequential(new Turn(-50.0d, 0.7, 5));
            addSequential(new DriveStraight(59.877, 0.5, true, 5));
            addSequential(new Turn(50.0d, 0.7, 5));
            addSequential(new DriveStraight(50, 0.5, true, 2));
            addSequential(new GuillotineKick());
            addSequential(new PivotIntakeDown(0.3f));
            addSequential(new WaitCommand(0.5f));
            addSequential(new IntakeArmsOut());
            addSequential(new WaitCommand(4));
            addSequential(new IntakeArmsStop());
            addSequential(new ArduinoControllerSendCommand());
        } else if (c == 'R') {
            // Score on the right side on the front of the switch
            addSequential(new DriveStraight(10.968, 0.5, true, 5));
            addSequential(new Turn(50.0d, 0.7, 5));
            addSequential(new DriveStraight(54.877, 0.5, true, 5));
            addSequential(new Turn(-50.0d, 0.7, 5));
            addSequential(new DriveStraight(50, 0.5, true, 2));
            addSequential(new GuillotineKick());
            addSequential(new PivotIntakeDown(0.3f));
            addSequential(new WaitCommand(0.5f));
            addSequential(new IntakeArmsOut());
            addSequential(new WaitCommand(4));
            addSequential(new IntakeArmsStop());
            addSequential(new ArduinoControllerSendCommand());
        }
    }

}
