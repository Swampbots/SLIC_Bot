package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "it do", group = "Testing")
public class Test123 extends OpMode {

    public void init() {
        telemetry.addLine("it do?");
        telemetry.update();
    }

    public void loop() {
        telemetry.addLine("ITS WORKING");
        telemetry.update();
    }
}
