package com.study.datepickerdialogdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity implements View.OnClickListener {

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
    private TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        tvText = (TextView) findViewById(R.id.tv_text);
        tvBack = (TextView) findViewById(R.id.tv_back);
        tvBack.setOnClickListener(this);

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
                textDialog(R.style.dialogT1);
                break;
            case R.id.tv_2:
                textDialog(R.style.dialogT2);
                break;
            case R.id.tv_3:
                textDialog(R.style.dialogT3);
                break;
            case R.id.tv_4:
                textDialog(R.style.dialogT4);
                break;
            case R.id.tv_5:
                textDialog(R.style.dialogT5);
                break;
            case R.id.tv_6:
                textDialog(R.style.dialogT6);
                break;
            case R.id.tv_7:
                textDialog(R.style.dialogT7);
                break;
            case R.id.tv_8:
                textDialog(R.style.dialogT8);
                break;
            case R.id.tv_9:
                textDialog(R.style.dialogT9);
                break;
            case R.id.tv_10:
                textDialog(R.style.dialogT10);
                break;
            case R.id.tv_back:
                onBackPressed();
                break;
        }
    }

    private void textDialog(int style) {
        AlertDialog.Builder builder = new AlertDialog.
                Builder(this, style).
                setTitle("文本").
                setPositiveButton("确定", null).
                setNegativeButton("取消", null).
                setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface anInterface, int which) {
                        tvText.setText(items[which]);
                        anInterface.dismiss();
                    }
                });
        builder.show();
    }

}
