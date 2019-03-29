package com.example.priyam.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainmenu extends AppCompatActivity {

    Button issueqr,reissue,profile,book;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        issueqr=(Button)findViewById(R.id.issue);
        reissue=(Button)findViewById(R.id.reissue);
        profile=(Button)findViewById(R.id.profile);
        book=(Button)findViewById(R.id.search);
        issue();
        reissue();
        profile();
        book();
    }

    public void issue(){
        issueqr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(mainmenu.this,Issueqr.class);
                        startActivity(intent);
                    }
                }
        );
    }
    public void reissue(){
        reissue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(mainmenu.this,Issueqr.class);
                        startActivity(intent);
                    }
                }
        );
    }public void profile(){
        profile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(mainmenu.this,Profile.class);
                        startActivity(intent);
                    }
                }
        );
    }public void book(){
        book.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(mainmenu.this,Booksearch.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
