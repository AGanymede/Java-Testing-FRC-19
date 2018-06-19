package frc.team422.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team422.robot.subsystems.Subsystems;

public class DriveStraight extends Command {

    private int ticks;
    private boolean forward;
    private double speed;

    // private int covertToTicks(double inches)

    public DriveStraight(double inches, double speed, boolean forward, double timeout) {
        super("DriveStraight");
        requires(Subsystems.driveBase);
    }

    @Override
    public void initialize() {
        Subsystems.driveBase.zeroEncoderPosition();
        Subsystems.driveBase.zeroGyroAngle();
    }

    @Override
    public void execute() {
        double correction = Subsystems.driveBase.getGyroAngle();
        correction *= 0.075;
        correction += 1.0;
        if (forward) {
            Subsystems.driveBase.setMotors(-speed, -speed * correction);
        } else {
            Subsystems.driveBase.setMotors(speed * correction, speed);
        }
    }

    @Override
    public boolean isFinished() {
        int leftPosition = Math.abs(Subsystems.driveBase.getLeftPosition());
        int rightPosition = Math.abs(Subsystems.driveBase.getRightPosition());
        return (leftPosition > ticks) || (rightPosition > ticks) || isTimedOut();
    }

    @Override
    public void interrupted() {
        Subsystems.driveBase.setMotors(0,0);
    }


    @Override
    public void end() {
        Subsystems.driveBase.setMotors(0,0);
    }

    public double convertToTicks(float inches) {
        return (4096 / (6 * 3.1415926) * inches);
    }

}
