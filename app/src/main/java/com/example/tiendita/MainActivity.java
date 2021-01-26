package com.example.tiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    private EditText et;
    private EditText con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.tex);
        con = (EditText)findViewById(R.id.con);
        SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et.setText( preferences1.getString("nombre","")   );
        if(preferences1.contains("nombre"))
        {Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
            finish();
        }
    }
        public void GUARDAR(View view)
    {
        //SharedPreferences preferences = getSharedPreferences("dato",0);
        SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences1.edit();
        String datosN = et.getText().toString();
        String Cont = con.getText().toString();
        editor.putString("nombre",datosN);
        editor.putString("contrasena",Cont);
        editor.commit();
        Toast.makeText(this, "Ingresaste", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
        finish();
        editor.clear();

    }
}