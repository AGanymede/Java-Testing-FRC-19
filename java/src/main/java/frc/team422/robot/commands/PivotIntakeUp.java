package frc.team422.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team422.robot.subsystems.Subsystems;

public class PivotIntakeUp extends Command {

    private boolean forTimeOnly;
    private double time;

    public PivotIntakeUp(boolean forTimeOnly, double time) {
        super("PivotIntakeUp");
        requires(Subsystems.intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Subsystems.intake.setPivotSpeed(0.6d);
    }

    @Override
    public boolean isFinished() {
        if (forTimeOnly) {
            return isTimedOut();
        } else {
            return Subsystems.intake.getLowerSwitchValue();
        }
    }

    @Override
    public void interrupted() {

    }


    @Override
    public void end() {
        Subsystems.intake.setPivotSpeed(0.0d);
    }

}