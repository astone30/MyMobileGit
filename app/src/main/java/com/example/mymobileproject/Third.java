package com.example.mymobileproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Third extends MainActivity {

    EditText edit1, edit2;
    Button btnA, btnS, btnM, btnD, btnE;
    Button[] button = new Button[10];
    int[] numbutton = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    TextView textResult;

    int num1, num2;

    Integer Result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("쵸큼 간단한 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnA = (Button) findViewById(R.id.btna);
        btnS = (Button) findViewById(R.id.btns);
        btnM = (Button) findViewById(R.id.btnm);
        btnD = (Button) findViewById(R.id.btnd);
        btnE = (Button) findViewById(R.id.btne);

        textResult = (TextView) findViewById(R.id.result);

        for(int i=0; i<10; i++)
        {
            button[i] = (Button) findViewById(numbutton[i]);
        }

        for(int i=0; i<10; i++)
        {
            final int index;
            index = i;
            button[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String a, b;
                    if(edit1.isFocused() == true){
                        a = edit1.getText().toString()
                                + button[index].getText().toString();
                        edit1.setText(a);
                    }
                    else if(edit2.isFocused() == true){
                        b = edit2.getText().toString()
                                + button[index].getText().toString();
                        edit2.setText(b);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요^^", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



        View.OnClickListener clisten = new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Integer.parseInt(edit1.getText().toString());
                num2 = Integer.parseInt(edit2.getText().toString());

                switch(v.getId()){
                    case R.id.btna :
                        Result = num1 + num2;
                        break;
                    case R.id.btns :
                        Result = num1 - num2;
                        break;
                    case R.id.btnm :
                        Result = num1 * num2;
                        break;
                    case R.id.btnd :
                        Result = num1 / num2;
                        break;
                    case R.id.btne :
                        textResult.setText("계산결과 : "+Result);
                        break;
                }
            }
        };
        btnA.setOnClickListener(clisten);
        btnS.setOnClickListener(clisten);
        btnM.setOnClickListener(clisten);
        btnD.setOnClickListener(clisten);
        btnE.setOnClickListener(clisten);
    }

}


