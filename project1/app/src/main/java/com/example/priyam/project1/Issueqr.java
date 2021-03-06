package com.example.priyam.project1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class Issueqr extends AppCompatActivity {

    SurfaceView surfaceView;
    TextView textBarcodevalue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int RequestCamera=1001;
    Button btnAction;
    String intentData="";
    boolean isEmail=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issueqr);

        initViews();
    }

    private void initViews(){
        textBarcodevalue=(TextView)findViewById(R.id.txtBarCodeValue);
        surfaceView=findViewById(R.id.sufaceViewbarcode);
        btnAction=findViewById(R.id.btnAction);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmail) {
                    startActivity(new Intent(Issueqr.this, Profile.class).putExtra("email",intentData));
                } else {
                    //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(intentData)));
                    Toast.makeText(getApplicationContext(),"barcode decoded into"+intentData,Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    private void initialiseDetectorsAndSources(){
        Toast.makeText(getApplicationContext(),"Scanner started",Toast.LENGTH_SHORT).show();
        barcodeDetector =new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();
        cameraSource=new CameraSource.Builder(this,barcodeDetector)

                .setRequestedPreviewSize(1920,1080)
        .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceCreated(SurfaceHolder holder){
                try{
                    if(ActivityCompat.checkSelfPermission(Issueqr.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                        cameraSource.start(surfaceView.getHolder());

                    }else{
                        ActivityCompat.requestPermissions(Issueqr.this,new String[]{Manifest.permission.CAMERA},RequestCamera );
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                Toast.makeText(getApplicationContext(),"barcode stopped",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode>barcodes=detections.getDetectedItems();
                if(barcodes.size()!=0){
                    textBarcodevalue.post(new Runnable() {

                        @Override
                        public void run() {

                            if (barcodes.valueAt(0).email != null) {
                                textBarcodevalue.removeCallbacks(null);
                                intentData = barcodes.valueAt(0).email.address;
                                textBarcodevalue.setText(intentData);
                                isEmail = true;
                                btnAction.setText("ADD CONTENT TO THE MAIL");
                            } else {
                                isEmail = false;
                                btnAction.setText("LAUNCH URL");
                                intentData = barcodes.valueAt(0).displayValue;
                                textBarcodevalue.setText(intentData);

                            }
                        }
                    });
                }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialiseDetectorsAndSources();


    }
}
