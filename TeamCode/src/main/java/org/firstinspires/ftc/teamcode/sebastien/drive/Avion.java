package org.firstinspires.ftc.teamcode.sebastien.drive;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;

public class Avion {
    public static Servo launcher;
    public static boolean saLansat;
    public static void init(){
        launcher = SHardware.avion;
        launcher.setPosition(0);
    }
    public static void loop()
    {
        if(saLansat)
            launcher.setPosition(0.3);
    }
    public static void setLauncher(boolean state)
    {
        saLansat = state;
    }
}
