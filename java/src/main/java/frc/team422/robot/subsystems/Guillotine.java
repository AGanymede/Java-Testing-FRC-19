package frc.team422.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team422.robot.RobotMap;

public class Guillotine extends Subsystem{

    private DoubleSolenoid kicker;
    private TalonSRX lift;
    private DigitalInput upperSwitch;
    private DigitalInput lowerSwitch;

    public Guillotine() {
        super("Guillotine");
        this.kicker = new DoubleSolenoid(RobotMap.KICKER_FORWARD, RobotMap.KICKER_REVERSE);
        this.lift = new TalonSRX(RobotMap.LIFT);
        this.upperSwitch = new DigitalInput(RobotMap.GUILLOTINE_UPPER_SWITCH);
        this.lowerSwitch = new DigitalInput(RobotMap.GUILLOTINE_LOWER_SWITCH);
    }

    @Override
    protected void initDefaultCommand() {}

    public void hold() {
        kicker.set(DoubleSolenoid.Value.kForward);
    }

    public void kick() {
        kicker.set(DoubleSolenoid.Value.kReverse);
    }

    public void setLiftSpeed(double speed) {
        lift.set(ControlMode.PercentOutput, 0.0d);
        if (speed > 0 ) {
            lift.set(ControlMode.PercentOutput, 0.3d);
        }
        if (speed > 0 && !getUpperSwitchValue()) {
            lift.set(ControlMode.PercentOutput, speed);
        } else if (speed < 0 && !getLowerSwitchValue()) {
            lift.set(ControlMode.PercentOutput, speed);
        }
    }

    public boolean getUpperSwitchValue() {
        return !upperSwitch.get();
    }

    public boolean getLowerSwitchValue() {
        return !lowerSwitch.get();
    }

    public int getLiftPosition() {
        return lift.getSelectedSensorPosition(0);
    }

    public void zeroLiftPosition() {
        lift.setSelectedSensorPosition(0,0,1);
    }

}
