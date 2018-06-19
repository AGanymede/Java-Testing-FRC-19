package frc.team422.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team422.robot.subsystems.Subsystems;

public class IntakeGrab extends Command {

    public IntakeGrab() {
        super("IntakeGrab");
        requires(Subsystems.intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Subsystems.intake.grab();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void interrupted() {

    }


    @Override
    public void end() {

    }

}
