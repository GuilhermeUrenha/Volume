package com.example.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtTitle;
    TextView txtEsfera;
    TextView txtPiramideB;
    TextView txtPiramideA;
    TextView txtErr;

    EditText edtEsferaRaio;
    EditText edtPiramideBase;
    EditText edtPiramideAlt;

    double esferaR;
    double piramideL;
    double piramideA;

    double VolumeEsfera;
    double VolumePiramide;

    String strEsfera;
    String strPiramide;

    public static final String MESSAGE1 = "com.example.volume.MESSAGE1";
    public static final String MESSAGE2 = "com.example.volume.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        txtEsfera = findViewById(R.id.txtEsfera);
        txtPiramideB = findViewById(R.id.txtPiramideB);
        txtPiramideA = findViewById(R.id.txtPiramideA);
        txtErr = findViewById(R.id.err);

        txtTitle.setText(R.string.title);
        txtEsfera.setText(R.string.esfera);
        txtPiramideB.setText(R.string.piramideB);
        txtPiramideA.setText(R.string.piramideA);
        txtErr.setText(R.string.noerr);


        edtEsferaRaio = findViewById(R.id.edtEsfera);
        edtPiramideBase = findViewById(R.id.edtPiramideB);
        edtPiramideAlt = findViewById(R.id.edtPiramideA);
    }

    Intent intentRes;
    public void postResultado(View view){

        if(String.valueOf(edtEsferaRaio.getText()).isEmpty() || String.valueOf(edtPiramideBase.getText()).isEmpty() || String.valueOf(edtPiramideAlt.getText()).isEmpty())
        {
            txtErr.setText(R.string.err);
            return;
        }
        txtErr.setText(R.string.noerr);

        esferaR = Double.parseDouble(String.valueOf(edtEsferaRaio.getText()));
        piramideL = Double.parseDouble(String.valueOf(edtPiramideBase.getText()));
        piramideA = Double.parseDouble(String.valueOf(edtPiramideAlt.getText()));

        VolumeEsfera = 1.00 / 3 * 3.1415 * Math.pow(esferaR, 3);
        VolumePiramide = 1.00 / 3 * piramideL * piramideA;

        strEsfera = String.valueOf(VolumeEsfera);
        strPiramide = String.valueOf(VolumePiramide);

        intentRes = new Intent(this, resultados.class);

        intentRes.putExtra(MESSAGE1, strEsfera);
        intentRes.putExtra(MESSAGE2, strPiramide);
        this.startActivity(intentRes);
    }

    Intent intentCam;
    public void telaCamera(View view){
        intentCam = new Intent(this, camera.class);
        this.startActivity(intentCam);
    }
}
