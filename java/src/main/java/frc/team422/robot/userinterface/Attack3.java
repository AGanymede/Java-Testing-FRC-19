package frc.team422.robot.userinterface;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Attack3 {

    private Joystick JOYSTICK;
    public final JoystickButton TRIGGER, BUTTON2, BUTTON3, BUTTON4, BUTTON5;

    public Attack3(int port) {
        this.JOYSTICK = new Joystick(port);
        this.TRIGGER = new JoystickButton(JOYSTICK, 1);
        this.BUTTON2 = new JoystickButton(JOYSTICK, 2);
        this.BUTTON3 = new JoystickButton(JOYSTICK, 3);
        this.BUTTON4 = new JoystickButton(JOYSTICK, 4);
        this.BUTTON5 = new JoystickButton(JOYSTICK, 5);

    }

    // NOT USED
    public double getX() {
        return JOYSTICK.getX();
    }

    public double getY() {
        return JOYSTICK.getY();
    }
}