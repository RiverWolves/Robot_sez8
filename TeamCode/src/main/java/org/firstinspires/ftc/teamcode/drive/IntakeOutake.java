package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;

public class IntakeOutake {
    private static Servo intake, rotire ;
    public static boolean inchis;
    public static boolean rotit;

    public static void init(){
        if (!SHardware.initializat) return;
//
        inchis = false;
        rotit = false;

        intake = SHardware.intake;
        rotire= SHardware.rotire;

        rotire.setPosition(0.4);
        intake.setPosition(0);
    }

    public static void loop(OpMode opMode){

        boolean einchis = inchis;
        boolean erotit = rotit;

        if (einchis) {

            intake.setPosition(0.4);
        }else {


            intake.setPosition(0);
        }
        if (erotit) {

            rotire.setPosition(0.25);
        }else {


            rotire.setPosition(0);
        }



        opMode.telemetry.addData("intake", einchis);


    }

    public static void setInchis(boolean stare1, OpMode opMode){
        inchis = stare1;
        loop(opMode);

    }
    public static void setRotire(boolean stare2, OpMode opMode){
        rotit = stare2;
        loop(opMode);
    }
}
