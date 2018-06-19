package frc.team422.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team422.robot.subsystems.Subsystems;
import frc.team422.robot.userinterface.UserInterface;

public class TankDrive extends Command {

    private double leftSpeed = 0;
    private double rightSpeed = 0;
    private static final double MAX_CHANGE = 0.08d;

    public TankDrive() {
        super("TankDrive");
        requires(Subsystems.driveBase);
    }

    @Override
    protected void execute() {
        double left = UserInterface.leftJoystick.getY();
        double leftDifference = left - leftSpeed;
        if (leftDifference > MAX_CHANGE) {
            left = leftSpeed + MAX_CHANGE;
        } else if (leftDifference < -MAX_CHANGE) {
            left = leftSpeed - MAX_CHANGE;
        }
        double right = UserInterface.rightJoystick.getY();
        double rightDifference = right - rightSpeed;
        if (rightDifference > MAX_CHANGE) {
            right = rightSpeed + MAX_CHANGE;
        } else if (rightDifference < -MAX_CHANGE) {
            right = rightSpeed - MAX_CHANGE;
        }
        leftSpeed = left;
        rightSpeed = right;
        Subsystems.driveBase.setMotors(left, right);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected void end() {
    }

}