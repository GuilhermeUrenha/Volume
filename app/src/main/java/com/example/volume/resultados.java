package com.example.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class resultados extends AppCompatActivity {
    TextView txtEsf;
    TextView txtPir;
    EditText edtResEsf;
    EditText edtResPir;

    String VolEsf;
    String VolPir;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        txtEsf = findViewById(R.id.txtResEsf);
        txtPir = findViewById(R.id.txtResPir);
        txtEsf.setText(R.string.lblesf);
        txtPir.setText(R.string.lblpir);

        edtResEsf = findViewById(R.id.edtResEsf);
        edtResPir = findViewById(R.id.edtResPir);

        intent = getIntent();
        VolEsf = intent.getStringExtra(MainActivity.MESSAGE1);
        VolPir = intent.getStringExtra(MainActivity.MESSAGE2);

        edtResEsf.setText(VolEsf);
        edtResPir.setText(VolPir);
    }
}
