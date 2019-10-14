package com.example.mymobileproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.Activity;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends MainActivity {
    Boolean IDOK = false;
    Boolean PasswordOK = false;
    Boolean RadioChoose = false;

    Button idBtn;
    Button passwordBtn;
    Button registBtn;
    Button cancleBtn;

    EditText Id;
    EditText passwordt;
    EditText username;
    EditText address;
    EditText dial1,dial2,dial3;
    RadioButton decline, accept;


    public static final Pattern VALID_PASSWOLD_REGEX_ALPHA_NUM = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{6,16}$"); // 6자리 ~ 16자리까지 가능
    // 비밀번호 검사
    public static boolean validatePassword(String pwStr) {
        Matcher matcher = VALID_PASSWOLD_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }

    public static final Pattern Valid_Phone_NUM = Pattern.compile("[0-9]"); //폰 넘버 숫자만
    public static boolean validateNumber(String phonStr){
        Matcher matcher = Valid_Phone_NUM.matcher(phonStr);
        return matcher.matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        decline = (RadioButton)findViewById(R.id.decline);
        accept = (RadioButton)findViewById(R.id.accept);

        idBtn = (Button)findViewById(R.id.isitOK);
        passwordBtn = (Button)findViewById(R.id.password);
        registBtn = (Button)findViewById(R.id.regist); //등록(회원 로그인 정보 파일로 저장 후 첫번째 화면으로)
        cancleBtn = (Button)findViewById(R.id.cancle); // 취소(첫번째 화면으로)

        Id = (EditText)findViewById(R.id.IDresgist);
        address = (EditText)findViewById(R.id.addressregist);
        username = (EditText)findViewById(R.id.username);
        dial1 = (EditText)findViewById(R.id.dial1);
        dial2 = (EditText)findViewById(R.id.dial2);
        dial3 = (EditText)findViewById(R.id.dial3);


        final String idstr = Id.getText().toString();


        idBtn.setOnClickListener(new View.OnClickListener() { //ID중복 확인 버튼
            @Override
            public void onClick(View view) {
                String idstring = (String) Id.getText().toString();
                if(idstring != null) {

                }

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                    alertDialog.setTitle("아이디 사용가능!!");
                    alertDialog.setMessage("사용가능한 아이디입니다.");
                    alertDialog.setPositiveButton("확인", null);
                    alertDialog.show();
                    IDOK = true;


            }
        });

        passwordBtn.setOnClickListener(new View.OnClickListener() { //비밀번호 유효 확인 버튼
            @Override
            public void onClick(View view) {
                passwordt = (EditText)findViewById(R.id.passwordregist);
                String passwordstr = (String) passwordt.getText().toString();
                if(!validatePassword(passwordstr)){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                        alertDialog.setTitle("올바르지 않은 비밀번호 형식!!");
                        alertDialog.setMessage("6자 이상, 특수문자, 영문 대문자, 소문자를 포함하시오.");
                        alertDialog.setPositiveButton("확인", null);
                        alertDialog.show();
                        PasswordOK = false;
                }
                else
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                    alertDialog.setTitle("사용 가능");
                    alertDialog.setMessage("사용가능한 비밀번호 입니다.");
                    alertDialog.setPositiveButton("확인", null);
                    alertDialog.show();
                    PasswordOK = true;
                }
            }
        });

        accept.setOnClickListener(new View.OnClickListener() { //라디오 버튼 스위치
            @Override
            public void onClick(View view) {
                accept.setChecked(true);
                RadioChoose = true;
                decline.setChecked(false);
            }
        });
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decline.setChecked(true);
                RadioChoose = false;
                accept.setChecked(false);
            }
        });

        registBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IDOK && PasswordOK && RadioChoose)
                {

                    finish();

                }
                else if(!IDOK)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                    alertDialog.setTitle("중복확인 바람");
                    alertDialog.setMessage("아이디 중복확인을 하시오.");
                    alertDialog.setPositiveButton("확인", null);
                    alertDialog.show();
                }
                else if(!PasswordOK)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                    alertDialog.setTitle("패스워드 확인 바람");
                    alertDialog.setMessage("패스워드를 확인하시오.");
                    alertDialog.setPositiveButton("확인", null);
                    alertDialog.show();
                }
                else if(!RadioChoose)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
                    alertDialog.setTitle("이용약관이 수락되지 않음");
                    alertDialog.setMessage("동의 하셔야 됩니다.");
                    alertDialog.setPositiveButton("확인", null);
                    alertDialog.show();
                }
            }
        });



    }
    public  void MakeFile()
    {
        String dirPath = getFilesDir().getAbsolutePath();
        File file = new File(dirPath);

        if(!file.exists()){
            file.mkdirs();
            Toast.makeText(this, "사용가능", Toast.LENGTH_SHORT).show();
        }

        String RegistInfoName = Id.getText().toString();


    }

    public void ReadFile()
    {

    }

}
