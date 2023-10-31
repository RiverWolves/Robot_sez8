package org.firstinspires.ftc.teamcode.sebastien.resources;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drive.Avion;
import org.firstinspires.ftc.teamcode.drive.IntakeOutake;
import org.firstinspires.ftc.teamcode.drive.Lift;

public class SGamepad {
    private static float x, y, r, putere_lift;
    private static boolean  buton1, buton2;
    private static Util inchis, roti,rotit,avion;


    private static boolean fc_roti,fc_lift;

    public boolean isTestingAutonomie = true;



    public static void init() {
        x = 0;
        y = 0;
        r = 0;

        putere_lift = 0;
        fc_roti = false;
        fc_lift = false;

        inchis = new Util();
        avion = new Util();
        rotit = new Util();
    }
  public static  void loop(OpMode opMode){
      Gamepad gamepad1 = opMode.gamepad1;
      Gamepad gamepad2 = opMode.gamepad2;
      fc_lift = gamepad2.left_bumper;    //conditie fine control lift
      fc_roti = gamepad1.left_bumper;   //conditie fine control roti
      putere_lift = -gamepad2.left_stick_y;
//Lift
      Lift.setVal(putere_lift);
      //Roti
     x = roti.fineControl(true, gamepad1.left_stick_x);            //setam puterea lui x
      y = roti.fineControl(true, gamepad1.left_stick_y);           //setam puterea lui y
      r = roti.fineControl(true, gamepad1.right_stick_x);        //setam puterea lui r
/*        x = gamepad1.left_stick_x;
      y= gamepad1.left_stick_y;
      r = gamepad1.right_stick_y;*/
      MechanumWheelsProvizorii.setVelXYR(x, -y, -r);


      //Intake
      boolean buton1 = inchis.buttonToSwich(gamepad2.a);
      boolean buton2 = rotit.buttonToSwich(gamepad2.x);
      //avion
      boolean buton3 = avion.buttonToSwich(gamepad2.y);


    IntakeOutake.setInchis(buton1,opMode); //setam starea intake-ului
      IntakeOutake.setRotire(!buton2,opMode);
      Avion.setLauncher(buton3);
      opMode.telemetry.addData("SGamepad:PutereLift: " , putere_lift);
      opMode.telemetry.addData("SGamepad:rotit " , buton2);
      opMode.telemetry.addData("SGamepad:inchis " , buton1);
  }
}
