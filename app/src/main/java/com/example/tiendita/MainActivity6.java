package com.example.tiendita;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    EditText bus_cod;
    EditText pro;
    EditText can;
    EditText pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        bus_cod= (EditText)findViewById(R.id.IDTEX);
        pro = (EditText)findViewById(R.id.PRODUCTOTEX);
        can = (EditText)findViewById(R.id.CANTIDADTEX);
        pre = (EditText)findViewById(R.id.PRECIOTEX);
    }
    public void BUSCAR (View view)
    {
        BaseD dbD = new BaseD(this, "db", null, 1);
        SQLiteDatabase BaseDatos = dbD.getReadableDatabase();

        String icod= bus_cod.getText().toString();
        pro.setText("");
        can.setText("");
        pre.setText("");

        if(icod.isEmpty()){
            if(icod.isEmpty()) {
                bus_cod.setError("Valor no ingresado");
                Toast.makeText(this, "Ingresa el código", Toast.LENGTH_LONG).show();

            }
        }else {
            if (!icod.isEmpty()) {
                Cursor fila = BaseDatos.rawQuery("select producto, cantidad, precio from productos where id= " + icod, null);
                if (fila.moveToFirst()) {
                    pro.setText(fila.getString(0));
                    can.setText(fila.getString(1));
                    pre.setText(fila.getString(2));
                    BaseDatos.close();
                    bus_cod.setText("");
                } else {
                    Toast.makeText(this, "El producto no existe ", Toast.LENGTH_LONG).show();

                    BaseDatos.close();
                }
            }
        }
    }
}