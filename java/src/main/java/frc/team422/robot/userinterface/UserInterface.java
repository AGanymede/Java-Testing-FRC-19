package frc.team422.robot.userinterface;

import frc.team422.robot.RobotMap;

public class UserInterface {

    public static final Attack3 leftJoystick = new Attack3(RobotMap.LEFT_JOYSTICK);
    public static final Attack3 rightJoystick = new Attack3(RobotMap.RIGHT_JOYSTICK);
    public static final XboxController controller = new XboxController(RobotMap.XBOX_CONTROLLER);
    public static final Launchpad launchpad = new Launchpad(RobotMap.LAUNCHPAD);

}
