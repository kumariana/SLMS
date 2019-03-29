package com.example.priyam.project1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class registerstudent extends AppCompatActivity {


    EditText username,password;
    Button register,login;

    String URL="http://127.0.0.1/test/index.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerstudent);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        register=(Button)findViewById(R.id.registerdata);
        login=(Button)findViewById(R.id.login);



    }
}


