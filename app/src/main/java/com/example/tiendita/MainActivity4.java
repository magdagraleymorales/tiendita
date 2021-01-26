package com.example.tiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


import android.view.View;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
EditText co;
    EditText pro;
    EditText can;
    EditText pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        co = (EditText)findViewById(R.id.idtex);
        pro = (EditText)findViewById(R.id.productotex);
        can = (EditText)findViewById(R.id.cantidadtex);
        pre = (EditText)findViewById(R.id.preciotex);
    }

    public void alta(View view)
    {
        BaseD db1 = new BaseD(this, "db", null, 1);
        SQLiteDatabase BaseDatos = db1.getWritableDatabase();
        String codigo = co.getText().toString();
        String producto = pro.getText().toString();
        String cantidad = can.getText().toString();
        String precio = pre.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("id",codigo);
        registro.put("producto",producto);
        registro.put("cantidad",cantidad);
        registro.put("precio",precio);

        BaseDatos.insert("productos", null,registro );
        BaseDatos.close();
    }
}