package com.example.priyam.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button student,librarian;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student=(Button)findViewById(R.id.buttonstud);
        librarian=(Button)findViewById(R.id.buttonlib);
    }

    public void stud(View view){
        Intent intent = new Intent(MainActivity.this,loginstudent.class);
        startActivity(intent);
    }
    public void lib(View view){
        Intent intent = new Intent(MainActivity.this,loginlibrarian.class);
        startActivity(intent);
    }
}
