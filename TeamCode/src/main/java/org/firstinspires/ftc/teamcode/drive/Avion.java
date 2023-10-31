package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;

public class Avion {
    public static Servo launcher;
    public static boolean isLaunched;
    public static void init(){
        launcher = SHardware.avion;
        launcher.setPosition(0);
    }
    public static void loop()
    {
        boolean eLansat = isLaunched;
        if(!eLansat)
            launcher.setPosition(0);
        else
            launcher.setPosition(0.3);
    }
    public static void setLauncher(boolean state)
    {
        isLaunched = state;
    }
}
