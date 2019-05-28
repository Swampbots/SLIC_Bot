package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Car Drive", group = "TeleOp")
public class CarDrive extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor rearLeft;
    public DcMotor rearRight;

    public final boolean BRAKE_ON_ZERO = true;



    public void init() {
        frontLeft   = hardwareMap.dcMotor.get("fl_drive");
        frontRight  = hardwareMap.dcMotor.get("fr_drive");
        rearLeft    = hardwareMap.dcMotor.get("rl_drive");
        rearRight   = hardwareMap.dcMotor.get("rr_drive");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        if(BRAKE_ON_ZERO) {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        } else {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        telemetry.addLine("Ready");
        telemetry.update();
    }

    public void loop() {
        double speed = gamepad1.left_trigger - gamepad1.right_trigger;
        double turn = -gamepad1.left_stick_x;

        double leftSpeed = ((1 - Math.abs(turn)) * speed + (1 - Math.abs(speed)) * turn + turn + speed) / 2;
        double rightSpeed = ((1 - Math.abs(turn)) * speed + (1 - Math.abs(speed)) * turn - turn + speed) / 2;

        frontLeft.setPower(leftSpeed);
        frontRight.setPower(rightSpeed);
        rearLeft.setPower(leftSpeed);
        rearRight.setPower(rightSpeed);

    }
}
