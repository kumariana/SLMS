package com.example.priyam.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Booksearch extends AppCompatActivity {

    Button bookcoverbtn,booksearchbtn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksearch);

        //.this.getWindow().getDecorView();
       // View.setBackgroundResource(R.color.colorPrimary);


        bookcoverbtn=(Button)findViewById(R.id.bookcover);
        booksearchbtn=(Button)findViewById(R.id.searchbook);
        editText=(EditText)findViewById(R.id.booksearchedittext);

        bookcoversearch();
        booksearch();
    }

    public void bookcoversearch(){
        bookcoverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Booksearch.this,OCR.class);
                startActivity(intent);
            }
        });
    }
    public void booksearch(){
        booksearchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Booksearch.this,Booksearch.class);
                startActivity(intent);
            }
        });
    }
}
