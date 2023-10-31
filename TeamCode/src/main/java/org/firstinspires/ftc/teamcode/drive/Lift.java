package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;
import org.firstinspires.ftc.teamcode.sebastien.resources.Util;

public class Lift {

    public static final int LIMITARE_SUS_LIFT = 10000;

    private static final float LIMITARE_JOS_LIFT = 0;
    private static float y = 0;
    private static float putere = 1;
    private static float pow_nivel = 0.4f;
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

        putere = fineControlls.fineControl(opMode.gamepad2.left_bumper, putere);

        lift1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       /* if (input != 0) {

        }*/
        lift1.setPower(putere);
        lift2.setPower(putere);

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

    public static float getPoz() {
        return pozitie_lift;
    }


}
