package org.firstinspires.ftc.teamcode.sebastien.resources;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

public class SHardware {
    public static boolean initializat = false;

    public static DcMotorEx ss, sf, ds, df,lift1, lift2;

    public static Servo intake, rotire, avion;
    public static BNO055IMU imu;
    public static void init(OpMode opMode, boolean auto)
    {
        imu = (BNO055IMU) opMode.hardwareMap.get(IMU.class, "imu");
        /*BNO055IMU.Parameters parameters = new BNO055IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD)
        );*/
/*        imu.initialize(parameters);*/

        //intake
        intake =(Servo) opMode.hardwareMap.get("cleste");
        rotire =(Servo) opMode.hardwareMap.get("rotire");
        avion =(Servo) opMode.hardwareMap.get("avion");



        if (!auto) {
            //MOTOARE

            ss = (DcMotorEx) opMode.hardwareMap.get("ss");
            sf = (DcMotorEx) opMode.hardwareMap.get("sf");
            ds = (DcMotorEx) opMode.hardwareMap.get("ds");
            df = (DcMotorEx) opMode.hardwareMap.get("df");

//            ds.setDirection(DcMotorSimple.Direction.REVERSE);
            sf.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        //LIFT


       lift1 = opMode.hardwareMap.get(DcMotorEx.class, "lift1");
        MotorConfigurationType mconf = lift1.getMotorType().clone(); mconf.setAchieveableMaxRPMFraction(1.0);
        lift1.setMotorType(mconf);
        lift1.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        lift1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        lift2 = opMode.hardwareMap.get(DcMotorEx.class, "lift2");
        MotorConfigurationType mconf2 = lift2.getMotorType().clone(); mconf2.setAchieveableMaxRPMFraction(1.0);
        lift2.setMotorType(mconf2);
        lift2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        lift2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift2.setDirection(DcMotorEx.Direction.REVERSE);



        initializat = true;
        opMode.telemetry.addData("Hardware initializat: ", initializat);
    }

}
