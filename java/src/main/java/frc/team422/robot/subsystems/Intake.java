package frc.team422.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team422.robot.RobotMap;

public class Intake extends Subsystem {

    private DoubleSolenoid grabber;
    private TalonSRX pivot;
    private TalonSRX leftArm;
    private TalonSRX rightArm;
    private DigitalInput upperSwitch;
    private DigitalInput lowerSwitch;
    private AnalogInput ultrasonic;


    public Intake() {
        super("Intake");
        this.grabber = new DoubleSolenoid(RobotMap.INTAKE_FORWARD, RobotMap.INTAKE_REVERSE);
        this.pivot = new TalonSRX(RobotMap.INTAKE_PIVOT);
        this.leftArm = new TalonSRX(RobotMap.INTAKE_LEFT_ARM);
        this.rightArm = new TalonSRX(RobotMap.INTAKE_RIGHT_ARM);
        this.upperSwitch = new DigitalInput(RobotMap.INTAKE_UPPER_SWITCH);
        this.lowerSwitch = new DigitalInput(RobotMap.INTAKE_LOWER_SWITCH);
        this.ultrasonic = new AnalogInput(RobotMap.INTAKE_ULTRASONIC);
        leftArm.setInverted(true);
        if(RobotMap.COMP_BOT) {
            pivot.setInverted(true);
        }
    }

    @Override
    protected void initDefaultCommand() {}

    public void setArmsSpeed(double speed) {
        leftArm.set(ControlMode.PercentOutput, speed);
        rightArm.set(ControlMode.PercentOutput, speed);
    }

    public void grab() {
        grabber.set(DoubleSolenoid.Value.kForward);
    }

    public void release() {
        grabber.set(DoubleSolenoid.Value.kReverse);
    }

    public void setPivotSpeed(double speed) {
        pivot.set(ControlMode.PercentOutput, 0.0d);
        if (speed > 0 && !getLowerSwitchValue()) {
            pivot.set(ControlMode.PercentOutput, speed);
        } else if (speed < 0 && !getUpperSwitchValue()) {
            pivot.set(ControlMode.PercentOutput, speed);
        }
    }

    public boolean getUpperSwitchValue() {
        return !upperSwitch.get();
    }

    public boolean getLowerSwitchValue() {
        return !lowerSwitch.get();
    }

    public double getLeftArmCurrent() {
        return leftArm.getOutputCurrent();
    }

    public double getRightArmCurrent() {
        return rightArm.getOutputCurrent();
    }

    public double getUltrasonicDistance() {
        return ultrasonic.getAverageVoltage();
    }

}
