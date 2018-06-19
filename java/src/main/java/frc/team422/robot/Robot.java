package frc.team422.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team422.robot.commands.*;
import frc.team422.robot.commands.autonomous.*;
import frc.team422.robot.subsystems.Subsystems;
import frc.team422.robot.userinterface.UserInterface;

public class Robot extends IterativeRobot {

    private UsbCamera camera;
    private CommandGroup autonomous;

    @Override
    public void robotInit() {
        Subsystems.compressor.start();
        UserInterface.controller.A.whenPressed(new IntakeGrab());
        UserInterface.controller.B.whenPressed(new IntakeRelease());
        UserInterface.controller.LB.whenPressed(new GuillotineHold());
        UserInterface.controller.RB.whenPressed(new GuillotineKick());
        UserInterface.controller.START.whenPressed(new IntakeBox());
        camera = CameraServer.getInstance().startAutomaticCapture();
        Subsystems.arduino.sendCommand("0001111");
        Subsystems.guillotine.zeroLiftPosition();
        SmartDashboard.putString("Auto State", "Destroyed");
    }

    @Override
    public void disabledInit() {
        Subsystems.arduino.sendCommand("0001111");
    }

    @Override
    public void autonomousInit() {
        Subsystems.arduino.sendCommand("0005551");
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
        if (UserInterface.launchpad.getMultiSwitchLeft()) {
            autonomous = new LeftAutonomous(gameData, UserInterface.launchpad.getSwitch1());
        } else if (UserInterface.launchpad.getMultiSwitchInactive()) {
            autonomous = new CenterAutonomous(gameData.charAt(0));
        } else if (UserInterface.launchpad.getMultiSwitchRight()) {
            autonomous = new RightAutonomous(gameData, UserInterface.launchpad.getSwitch1());
        }
        SmartDashboard.putString("Auto State", "Initialized");
        autonomous.start();
    }

    @Override
    public void teleopInit() {
        if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
            Subsystems.arduino.sendCommand("0003331");
        } else {
            Subsystems.arduino.sendCommand("0002221");
        }
    }

    @Override
    public void disabledPeriodic() {
        printDataToSmartDashboard();
    }
    
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        printDataToSmartDashboard();
    }

    @Override
    public void teleopPeriodic() {
        Subsystems.guillotine.setLiftSpeed(0.0f);
        if (UserInterface.controller.getPOVAngle() == 0) {
            Subsystems.intake.release();
            if (Subsystems.guillotine.getLiftPosition() < 1500) {
                Subsystems.guillotine.setLiftSpeed(1.0f);
            } else {
                Subsystems.guillotine.setLiftSpeed(0.25f);
            }
        } else if (UserInterface.controller.getPOVAngle() == 90) {
            Subsystems.intake.release();
            if (Subsystems.guillotine.getLiftPosition() < 1800) {
                Subsystems.guillotine.setLiftSpeed(1.0f);
            } else {
                Subsystems.guillotine.setLiftSpeed(0.25f);
            }
        } else if (UserInterface.controller.getPOVAngle() == 180) {
            Subsystems.intake.release();
            if (Subsystems.guillotine.getLiftPosition() < 2160) {
                Subsystems.guillotine.setLiftSpeed(1.0f);
            } else {
                Subsystems.guillotine.setLiftSpeed(0.25f);
            }
        } else if (UserInterface.controller.X.get()) {
            Subsystems.intake.release();
            Subsystems.guillotine.setLiftSpeed(1.0f);
        } else if (UserInterface.controller.Y.get()) {
            Subsystems.guillotine.setLiftSpeed(-0.4f);
            if (Subsystems.guillotine.getLowerSwitchValue()) {
                Subsystems.guillotine.kick();
            }
        }
        Subsystems.intake.setArmsSpeed(0.0f);
        if (UserInterface.controller.getLeftTrigger() > 0.1f) {
            Subsystems.intake.setArmsSpeed(0.5d);
        } else if (UserInterface.controller.getRightTrigger() > 0.1f) {
            Subsystems.intake.setArmsSpeed(-0.9f);
        }
        Subsystems.intake.setPivotSpeed(0.0f);
        if (UserInterface.controller.getLeftJoystickY() < -0.6f) {
            Subsystems.intake.setPivotSpeed(-UserInterface.controller.getLeftJoystickY());
        } else if (UserInterface.controller.getRightJoystickY() < -0.2f) {
            Subsystems.intake.setPivotSpeed(UserInterface.controller.getRightJoystickY());
        }
        Scheduler.getInstance().run();
        //	printDataToSmartDashboard();
    }

    private void printDataToSmartDashboard() {
        SmartDashboard.putNumber("Ultrasonic", Subsystems.intake.getUltrasonicDistance());
        SmartDashboard.putBoolean("Lift Upper Switch", Subsystems.guillotine.getUpperSwitchValue());
        SmartDashboard.putBoolean("Lift Lower Switch", Subsystems.guillotine.getLowerSwitchValue());
        SmartDashboard.putBoolean("Intake Upper Switch", Subsystems.intake.getUpperSwitchValue());
        SmartDashboard.putBoolean("Intake Lower Switch", Subsystems.intake.getLowerSwitchValue());
        SmartDashboard.putNumber("Guillotine Position", Subsystems.guillotine.getLiftPosition());
        SmartDashboard.putNumber("Left Encoder", Subsystems.driveBase.getLeftPosition());
        SmartDashboard.putNumber("Right Encoder", Subsystems.driveBase.getRightPosition());
        SmartDashboard.putNumber("Left Arm Current", Subsystems.intake.getLeftArmCurrent());
        SmartDashboard.putNumber("Right Arm Current", Subsystems.intake.getRightArmCurrent());
        SmartDashboard.putNumber("Xbox POV", UserInterface.controller.getPOVAngle());
        SmartDashboard.putNumber("Gyro Angle", Subsystems.driveBase.getGyroAngle());

    }
}