package org.firstinspires.ftc.teamcode.sebastien.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.sebastien.drive.Avion;
import org.firstinspires.ftc.teamcode.sebastien.drive.Cleste;
import org.firstinspires.ftc.teamcode.sebastien.drive.Lift;
import org.firstinspires.ftc.teamcode.sebastien.resources.Roti;
import org.firstinspires.ftc.teamcode.sebastien.resources.SGamepad;
import org.firstinspires.ftc.teamcode.sebastien.resources.SHardware;

@TeleOp (name = "TeleOP")
public class STeleop extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        SHardware.init(this,false);
        SGamepad.init();
        Cleste.init();
        Lift.init();
        Avion.init();
        waitForStart();
        if(isStopRequested())return;
        while(opModeIsActive())
        {

        Roti.loop(this);


            SGamepad.loop(this);
            Cleste.loop(this);
            Lift.loop(this);
            Avion.loop();
            telemetry.update();
        }

    }
}
