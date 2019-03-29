package com.example.priyam.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginstudent extends AppCompatActivity {

    Button loginbtn,registerbtn;
    EditText loginusername,loginpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginstudent);

        loginbtn=(Button)findViewById(R.id.login);
        registerbtn=(Button)findViewById(R.id.register);
        loginusername=(EditText)findViewById(R.id.user);
        loginpassword=(EditText) findViewById(R.id.pass);
        login();
        register();
    }

    public void login(){
        loginbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (loginusername.getText().toString().equals("admin") && loginpassword.getText().toString().equals("admin")){
                            Intent intent= new Intent(loginstudent.this,mainmenu.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(loginstudent.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }



   /* public void login(){
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = loginusername.getText().toString();
                String password = loginpassword.getText().toString();
                BackGroundWorker backgroundworker= new BackGroundWorker(loginstudent.this);
                backgroundworker.execute(username,password);


                Intent intent2 = getIntent();

                String name = intent2.getStringExtra("name");

                if(name.equals("1")){
                    Intent intent3=new Intent(loginstudent.this,mainmenu.class);
                    startActivity(intent3);
                }
                else{
                    Toast.makeText(loginstudent.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }*/
    public void register(){
        registerbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(loginstudent.this,registerstudent.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
