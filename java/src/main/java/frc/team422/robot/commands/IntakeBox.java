package frc.team422.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeBox extends CommandGroup {

    public IntakeBox() {
        addSequential(new IntakeGrab());
        addSequential(new GuillotineKick());
        addSequential(new PivotIntakeUp(false, 1.5d));
        addSequential(new PivotIntakeUp(true, 0.05d));
        addSequential(new GuillotineHold());
    }


}
