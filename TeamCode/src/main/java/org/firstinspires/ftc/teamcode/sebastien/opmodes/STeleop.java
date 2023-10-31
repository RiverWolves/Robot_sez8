package org.firstinspires.ftc.teamcode.sebastien.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drive.Avion;
import org.firstinspires.ftc.teamcode.drive.IntakeOutake;
import org.firstinspires.ftc.teamcode.drive.Lift;
import org.firstinspires.ftc.teamcode.sebastien.resources.MechanumWheelsProvizorii;
import org.firstinspires.ftc.teamcode.sebastien.resources.SGamepad;
import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;

@TeleOp (name = "TeleOP")
public class STeleop extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        SHardware.init(this,false);
        SGamepad.init();
        IntakeOutake.init();
        Lift.init();
        Avion.init();
        waitForStart();
        if(isStopRequested())return;
        while(opModeIsActive())
        {

        MechanumWheelsProvizorii.loop(this);


            SGamepad.loop(this);
            IntakeOutake.loop(this);
            Lift.loop(this);
            Avion.loop();
            telemetry.update();
        }

    }
}
