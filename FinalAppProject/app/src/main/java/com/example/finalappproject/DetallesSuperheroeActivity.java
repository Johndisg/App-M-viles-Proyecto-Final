package com.example.finalappproject;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class DetallesSuperheroeActivity extends AppCompatActivity {

    private TextView txtNombre, txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_superheroe);

        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);

        Superheroe superheroe = (Superheroe) getIntent().getSerializableExtra("superheroe");

        if (superheroe != null) {
            txtNombre.setText(superheroe.getNombre());
            txtDescripcion.setText(superheroe.getDescripcion());
        }
    }
}

