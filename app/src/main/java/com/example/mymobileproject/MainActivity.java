package com.example.mymobileproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Boolean LoginRight = false;

    Button button1;
    Button button2;

    Switch Tbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tbtn = (Switch) findViewById(R.id.Cheat);//회원가입 파일 저장 기능이 완성되지 않았기 때문에 위 기능을 추가한다.
        Tbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    LoginRight = true;
                }
                else
                {
                    LoginRight = false;
                }
            }
        });

        button1 = (Button) findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.loginBtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginRight)
                {
                    Intent intent = new Intent(getApplicationContext(),Third.class);
                    startActivity(intent);
                }
                else
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("로그인이 되지 않았습니다");
                    alertDialog.setMessage("아이디와 비밀번호를 정확히 입력해 주십시오.");
                    alertDialog.setPositiveButton("확인", null);
                    alertDialog.show();
                }
            }
        });
    }

}
