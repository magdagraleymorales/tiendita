package com.example.tiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }


    public void ALTA(View view) {
        Toast.makeText(this, "ingresaste a dar de alta", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
        finish();

    }
    public void BAJA(View view) {
        Toast.makeText(this, "ingresaste a dar de bajas", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
        finish();

    }
    public void BUSCAR(View view) {
        Toast.makeText(this, "ingresaste a realizar una  busqueda", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
        finish();

    }
    public void MODIFICACION(View view) {
        Toast.makeText(this, "ingresaste a modificar", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
        finish();

    }
}