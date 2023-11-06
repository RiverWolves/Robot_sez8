package org.firstinspires.ftc.teamcode.sebastien.drive;

import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;

public class Gyroscop {
    public static BNO055IMU imu;
    public static void init(){
        imu = SHardware.imu;
    }
}
