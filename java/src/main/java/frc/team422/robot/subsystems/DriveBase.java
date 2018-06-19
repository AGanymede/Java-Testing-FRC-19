package frc.team422.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team422.robot.RobotMap;
import frc.team422.robot.commands.TankDrive;

public class DriveBase extends Subsystem {

    private TalonSRX leftMasterMotor;
    private TalonSRX rightMasterMotor;

    // If on Clyde
    private TalonSRX leftFollower1;
    private TalonSRX leftFollower2;
    private TalonSRX rightFollower1;
    private TalonSRX rightFollower2;

    // If on Axiom
//    private VictorSPX leftFollower1;
//    private VictorSPX leftFollower2;
//    private VictorSPX rightFollower1;
//    private VictorSPX rightFollower2;

    private ADXRS450_Gyro gyro;

    public DriveBase() {
        super("DriveBase");
        this.leftMasterMotor = new TalonSRX(RobotMap.LEFT_MASTER_MOTOR);
        this.rightMasterMotor = new TalonSRX(RobotMap.RIGHT_MASTER_MOTOR);

        // If on Clyde
        this.leftFollower1 = new TalonSRX(RobotMap.LEFT_FOLLOWER_1);
        this.leftFollower2 = new TalonSRX(RobotMap.LEFT_FOLLOWER_2);
        this.rightFollower1 = new TalonSRX(RobotMap.RIGHT_FOLLOWER_1);
        this.rightFollower2 = new TalonSRX(RobotMap.RIGHT_FOLLOWER_2);

        // If on Axiom
//        this.leftFollower1 = new VictorSPX(RobotMap.LEFT_FOLLOWER_1);
//        this.leftFollower2 = new VictorSPX(RobotMap.LEFT_FOLLOWER_2);
//        this.rightFollower1 = new VictorSPX(RobotMap.RIGHT_FOLLOWER_1);
//        this.rightFollower2 = new VictorSPX(RobotMap.RIGHT_FOLLOWER_2);

        this.gyro = new ADXRS450_Gyro();

        leftMasterMotor.setInverted(true);
        leftFollower1.setInverted(true);
        leftFollower2.setInverted(true);

        leftFollower1.follow(leftMasterMotor);
        leftFollower2.follow(leftMasterMotor);
        rightFollower1.follow(rightMasterMotor);
        rightFollower2.follow(rightMasterMotor);
    }

    @Override
    public void initDefaultCommand() { this.setDefaultCommand(new TankDrive()); }

    public void setMotors(double left, double right) {
        leftMasterMotor.set(ControlMode.PercentOutput, left * 0.8d);
        rightMasterMotor.set(ControlMode.PercentOutput, right * 0.8d);
    }

    public int getLeftPosition() {
        return leftMasterMotor.getSelectedSensorPosition(0);
    }

    public int getRightPosition() {
        return rightMasterMotor.getSelectedSensorPosition(0);
    }

    public int getLeftVelocity() {
        return leftMasterMotor.getSelectedSensorVelocity(0);
    }

    public int getRightVelocity() {
        return rightMasterMotor.getSelectedSensorVelocity(0);
    }

    public double getGyroAngle() {
        return gyro.getAngle();
    }

    public void zeroEncoderPosition() {
        leftMasterMotor.setSelectedSensorPosition(0, 0, 10);
        rightMasterMotor.setSelectedSensorPosition(0, 0, 10);
    }

    public void zeroGyroAngle() { gyro.reset(); }
}
