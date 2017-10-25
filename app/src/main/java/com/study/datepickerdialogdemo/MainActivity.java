package com.study.datepickerdialogdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private DateTimePickerDialog dtpd;
    private TextView tvTime;
    private TextView tvText;
    private String[] items = new String[]{"文本1", "文本2"};
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tvClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvText = (TextView) findViewById(R.id.tv_text);
        tvText.setOnClickListener(this);
        tvClock = (TextView) findViewById(R.id.tv_clock);
        tvClock.setOnClickListener(this);

        tv1 = (TextView) findViewById(R.id.tv_1);
        tv1.setOnClickListener(this);

        tv2 = (TextView) findViewById(R.id.tv_2);
        tv2.setOnClickListener(this);

        tv3 = (TextView) findViewById(R.id.tv_3);
        tv3.setOnClickListener(this);

        tv4 = (TextView) findViewById(R.id.tv_4);
        tv4.setOnClickListener(this);

        tv5 = (TextView) findViewById(R.id.tv_5);
        tv5.setOnClickListener(this);

        tv6 = (TextView) findViewById(R.id.tv_6);
        tv6.setOnClickListener(this);

        tv7 = (TextView) findViewById(R.id.tv_7);
        tv7.setOnClickListener(this);

        tv8 = (TextView) findViewById(R.id.tv_8);
        tv8.setOnClickListener(this);

        tv9 = (TextView) findViewById(R.id.tv_9);
        tv9.setOnClickListener(this);

        tv10 = (TextView) findViewById(R.id.tv_10);
        tv10.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                timeDialog1();
                break;
            case R.id.tv_2:
                timeDialog2();
                break;
            case R.id.tv_3:
                timeDialog3();
                break;
            case R.id.tv_4:
                timeDialog4();
                break;
            case R.id.tv_5:
                timeDialog5();
                break;
            case R.id.tv_6:
                timeDialog6();
                break;
            case R.id.tv_7:
                timeDialog7();
                break;
            case R.id.tv_8:
                timeDialog8();
                break;
            case R.id.tv_9:
                timeDialog9();
                break;
            case R.id.tv_10:
                timeDialog10();
                break;
            case R.id.tv_text:
                Intent intent = new Intent(this, TextActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_clock:
                Intent intent1 = new Intent(this, ClockActivity.class);
                startActivity(intent1);
                break;
        }
    }


    private void timeDialog1() {

        dtpd = new DateTimePickerDialog(this, R.style.dialog1);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog2() {

        dtpd = new DateTimePickerDialog(this, R.style.dialog2);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog3() {

        dtpd = new DateTimePickerDialog(this, R.style.dialog3);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog4() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog4);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog5() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog5);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog6() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog6);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog7() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog7);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog8() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog8);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog9() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog9);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }

    private void timeDialog10() {
        dtpd = new DateTimePickerDialog(this, R.style.dialog10);
        dtpd.setOnSelectedListener(new DateTimePickerDialog.OnSelectedListener() {
            @Override
            public void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute) {
                tvTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                dialog.dismiss();
            }

            @Override
            public void cancel(DateTimePickerDialog dialog) {
                dialog.dismiss();
            }
        });

        dtpd.show();
    }



}
