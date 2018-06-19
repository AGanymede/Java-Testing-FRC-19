package frc.team422.robot;

public class RobotMap {

    /**
     *  Whether or not this is the competition bot
     *  Changing this variable will change all the ports accordingly.
     */
    public static final boolean COMP_BOT = true;

    /**
     * Various Ports
     */

    // Talon/Victor IDS
    public static final int LEFT_MASTER_MOTOR = (COMP_BOT) ? 1 : 40;
    public static final int LEFT_FOLLOWER_1 = (COMP_BOT) ? 2 : 44;
    public static final int LEFT_FOLLOWER_2 = (COMP_BOT) ? 3 : 21;
    public static final int RIGHT_MASTER_MOTOR = (COMP_BOT) ? 4 : 39;
    public static final int RIGHT_FOLLOWER_1 = (COMP_BOT) ? 5 : 42;
    public static final int RIGHT_FOLLOWER_2 = (COMP_BOT) ? 6 : 46;
    public static final int INTAKE_PIVOT = (COMP_BOT) ? 43 : 16;
    public static final int INTAKE_LEFT_ARM = (COMP_BOT) ? 9 : 12;
    public static final int INTAKE_RIGHT_ARM = (COMP_BOT) ? 10 : 35;
    public static final int LIFT = (COMP_BOT) ? 11 : 56;

    // Double Solenoid Values
    public static final int INTAKE_FORWARD = 5;
    public static final int INTAKE_REVERSE = 3;
    public static final int KICKER_FORWARD = (COMP_BOT) ? 4 : 2;
    public static final int KICKER_REVERSE = (COMP_BOT) ? 2 : 4;

    // Digital IO Ports
    public static final int INTAKE_UPPER_SWITCH = (COMP_BOT) ? 4 : 5;
    public static final int INTAKE_LOWER_SWITCH = (COMP_BOT) ? 5 : 4;
    public static final int GUILLOTINE_UPPER_SWITCH = 2;
    public static final int GUILLOTINE_LOWER_SWITCH = 3;
//    public static final int BEAM_BRAKE = 6;

    // Analog IO Ports
    public static final int INTAKE_ULTRASONIC = 3;

    // UI Ports
    public static final int XBOX_CONTROLLER = 0;
    public static final int LAUNCHPAD  = 1;
    public static final int LEFT_JOYSTICK  = 2;
    public static final int RIGHT_JOYSTICK  = 3;


}