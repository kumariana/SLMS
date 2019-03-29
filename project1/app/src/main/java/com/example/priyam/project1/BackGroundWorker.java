package com.example.priyam.project1;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.content.Context;

public class BackGroundWorker extends AsyncTask<String,String,String> {
    private int get = 0;
    public Context context;


    BackGroundWorker(Context contex) {
        this.context = contex;

    }

    @Override
    protected void onPreExecute() {

    }

    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "Login Successfull", Toast.LENGTH_LONG).show();
        get=1;
        Intent intent = new Intent(context, loginstudent.class);
        intent.putExtra("name",get);

    }

    @Override
    protected String doInBackground(String... args0) {
        try {
            String username = (String)args0[0];
            String password = (String)args0[1];

            String loginlink="https://4profitdit.000webhostapp.com/login.php";
            String data  = URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");

            URL url = new URL(loginlink);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write( data );
            wr.flush();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }

            return sb.toString();
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());

        }
    }
}
