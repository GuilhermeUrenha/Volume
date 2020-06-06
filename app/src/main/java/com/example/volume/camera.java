package com.example.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class camera extends AppCompatActivity {

    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;
    public static final String Extras = "com.example.volume.Extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_camera);
    }

    public void capturarImagem(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.startActivityForResult(intent, CAPTURAR_IMAGEM);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(imageBitmap);
                this.mostrarMensagem("Imagem capturada!");
                this.adicionarNaGaleria();
            } else {
                this.mostrarMensagem("Imagem não capturada!");
            }
        }
        if (resultCode == Activity.RESULT_OK && requestCode == 123)
        {
            Uri img = data.getData();
            Intent intentGal = new Intent(this, galeria.class);
            intentGal.putExtra(Extras, img);
            this.startActivity(intentGal);
        }
    }


    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    /*imagem não é adicionada automaticamente a galeria
    é necessário chamar um serviço de notificação (broadcast para que a imagem seja adicionada a galeria
     */
    private void adicionarNaGaleria() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    public void visualizarImagem(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "image/jpeg");
        this.startActivity(intent);
    }

    public void visualizarGaleria(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        this.startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 123);
    }
}
