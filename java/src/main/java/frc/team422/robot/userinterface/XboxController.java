package frc.team422.robot.userinterface;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxController {

    private Joystick JOYSTICK;
    public final JoystickButton A, B, X, Y, LB, RB, BACK, START;

    public XboxController(int port) {
        this.JOYSTICK = new Joystick(port);
        this.A = new JoystickButton(JOYSTICK, 1);
        this.B = new JoystickButton(JOYSTICK, 2);
        this.X = new JoystickButton(JOYSTICK, 3);
        this.Y = new JoystickButton(JOYSTICK, 4);
        this.LB = new JoystickButton(JOYSTICK, 5);
        this.RB = new JoystickButton(JOYSTICK, 6);
        this.BACK = new JoystickButton(JOYSTICK, 7);
        this.START = new JoystickButton(JOYSTICK, 8);
    }

    public double getLeftJoystickX() { return JOYSTICK.getRawAxis(0); }

    public double getLeftJoystickY() { return JOYSTICK.getRawAxis(1); }

    public double getRightJoystickX() { return JOYSTICK.getRawAxis(4); }

    public double getRightJoystickY() { return JOYSTICK.getRawAxis(5); }

    public double getLeftTrigger() { return JOYSTICK.getRawAxis(2); }

    public double getRightTrigger() { return JOYSTICK.getRawAxis(3); }

    public int getPOVAngle() {
        return JOYSTICK.getPOV(0);
    }
}
