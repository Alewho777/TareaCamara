package com.example.appcam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnCam;
    ImageView imageCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCam = findViewById(R.id.btCam);
        imageCam = findViewById(R.id.imagenCam);

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            abrirCamara();
            }
        });
    }

    private void abrirCamara(){
        Intent intentCam= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if (intentCam.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intentCam,1);
        //}
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==1 && resultCode== RESULT_OK){
           Bundle extras= data.getExtras();
           Bitmap imgBitMap= (Bitmap) extras.get("data");
           imageCam.setImageBitmap(imgBitMap);
       }
    }
}