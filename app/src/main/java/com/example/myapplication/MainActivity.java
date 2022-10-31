package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        imageView = (ImageView) findViewById(R.id.imageView);
        findViewById(R.id.Cam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });


    }
    public void tirarFoto(){
     Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     startActivityForResult(intent, 1 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras = null;
        if (requestCode == 1 && resultCode == RESULT_OK) {
        }extras = data.getExtras();
        Bitmap imagem = (Bitmap) extras.get("data");
        imageView.setImageBitmap(imagem);
        super.onActivityResult(requestCode, resultCode, data);

    }
}

