package com.example.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class galeria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        Intent intent = this.getIntent();
        Uri imagemSelecionada = intent.getData();
        //ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ImageView imageView = new ImageView(this);
        imageView.setImageURI(imagemSelecionada);
        GridLayout gl = (GridLayout)findViewById(R.id.gridLayout);
        gl.addView(imageView);
    }
}
