package org.firstinspires.ftc.teamcode.sebastien.drive;

import android.sax.StartElementListener;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;
import org.firstinspires.ftc.teamcode.sebastien.resources.Util;

public class Lift {

    public static final int LIMITARE_SUS_LIFT = 10000,
            pozitieJos=0 ,
            LIMITARE_JOS_LIFT = 0,
            pozitieSus = 10000;

    private static float y = 0;
    private static float putere = 1 ;
    public static int target = 0;
    private static boolean esteRidicat, stateHasChanged;
    public static float pozitie_lift = 0;
    private static Util fineControlls ;

    private static DcMotorEx lift1 = null,
            lift2 = null;

    public static  void init() {
        if (!SHardware.initializat) {
            return;
        }
        if (lift1 == null) {
            lift1 = SHardware.lift1;
        }
        if (lift2 == null) {
            lift2 = SHardware.lift2;
        }

        lift1.setTargetPosition(0);
        lift2.setTargetPosition(0);
        lift1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        lift2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fineControlls = new Util();
        esteRidicat = false;
    }

    public static void loop(OpMode opMode) {
        float input = y;
        pozitie_lift = lift1.getCurrentPosition();

        if (input > 0.3f && pozitie_lift < LIMITARE_SUS_LIFT) {
            putere = 1;
        }
        else if (input < -0.3f && pozitie_lift > LIMITARE_JOS_LIFT) {
            putere = -1;
        }
        else {
            putere = 0;
        }
        if(stateHasChanged && putere ==0)
        {
            if(esteRidicat)
                target = pozitieJos;
            else
                target = pozitieSus;
            lift1.setTargetPosition(target);
            lift2.setTargetPosition(target);
            lift1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            lift2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            stateHasChanged = false;

        }
        else {
            putere = fineControlls.fineControl(opMode.gamepad2.left_bumper, putere);

/*            lift1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            lift2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/

            lift1.setPower(putere);
            lift2.setPower(putere);
        }
        //RUMBLE
        if (input > 0.3f && pozitie_lift >= LIMITARE_SUS_LIFT){
            fineControlls.rumble(opMode.gamepad2);
        }
        else if (input < -0.3f && pozitie_lift <= LIMITARE_JOS_LIFT){
            fineControlls.rumble(opMode.gamepad2);
        }

        opMode.telemetry.addData("input lift: ", input);
        opMode.telemetry.addData("pozitie lift: ", pozitie_lift);
    }

    public static void setVal(float stick) {
    y = stick;
    }

    public static void setNivel(boolean state)
    {
        esteRidicat = state;
        stateHasChanged = true;
    }

    public static float getPoz() {
        return pozitie_lift;
    }


}
