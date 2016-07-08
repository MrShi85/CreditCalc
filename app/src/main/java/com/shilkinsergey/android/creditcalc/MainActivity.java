package com.shilkinsergey.android.creditcalc;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.FragmentManager;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText mSumCredit;
    private EditText mSumProc;
    private EditText mSumPay;
    private Button mRaschetButton;
    private Button mDialogButton;

    private EditText mSumMonth;
    private EditText mSumPayment;

    private double mSum;
    private double mProc;
    private double mPay;

    private static final String DIALOG_TAG = "DialogTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSumCredit = (EditText)findViewById(R.id.sumCredit);
        mSumProc = (EditText)findViewById(R.id.sumProcent);
        mSumPay = (EditText)findViewById(R.id.sumPay);

        mSumMonth = (EditText)findViewById(R.id.sumMonth);
        mSumPayment = (EditText)findViewById(R.id.sumProc);
        //mSum = Double.parseDouble(c.toString());

        mRaschetButton = (Button) findViewById(R.id.buttonCalc);
        mRaschetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean flag = false;
                int count = 0;
                double sumProc = 0;

                try {
                    mSum = Double.parseDouble(mSumCredit.getText().toString());
                    mProc = Double.parseDouble(mSumProc.getText().toString());
                    mPay = Double.parseDouble(mSumPay.getText().toString());

                } catch (NumberFormatException e) {
                    mSum = 0;
                    mProc = 0;
                    mPay = 0;
                }

                mProc = mProc/12/100;

                while(!flag){
                    if(mSum > mPay) {
                        sumProc = sumProc + mProc * mSum;
                        mSum = mSum - (mPay - (mProc * mSum));
                    }
                    else{
                        flag = true;
                    }
                    count++;
                }

                sumProc = new BigDecimal(sumProc).setScale(2, RoundingMode.UP).doubleValue();

                mSumMonth.setText(Integer.toString(count));
                mSumPayment.setText(Double.toString(sumProc));
            }
        });


        mDialogButton = (Button) findViewById(R.id.buttonDialog);
        mDialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager manager = getSupportFragmentManager();
                DialogClass dialog = new DialogClass();
                dialog.show(manager, DIALOG_TAG);
            }});


        /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage("Покормите кота!")
                .setIcon(R.drawable.ic_android_cat)
                .setCancelable(false)
                .setNegativeButton("ОК, иду на кухню",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();*/



    }
}


