package com.example.tiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    EditText bus_cod;

    EditText pro;
    EditText can;
    EditText pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        bus_cod= (EditText)findViewById(R.id.IDMON);
        pro = (EditText)findViewById(R.id.PRODUCTOMON);
        can = (EditText)findViewById(R.id.CAINTIDADMON);
        pre = (EditText)findViewById(R.id.PRECIOMON);
    }

    public void modificar (View view){
        BaseD dbD = new BaseD(this, "db", null, 1);
        SQLiteDatabase BaseDatos = dbD.getWritableDatabase();

        String icod = bus_cod.getText().toString();
        String Snom = pro.getText().toString();
        String ipreP = can.getText().toString();
        String ipreU = pre.getText().toString();
        if(Snom.isEmpty()||icod.isEmpty()||ipreP.isEmpty()||ipreU.isEmpty()){
            if(Snom.isEmpty())
                pro.setError("Valor no ingresado");
            if(icod.isEmpty())
                bus_cod.setError("Valor no ingresado");
            if(ipreP.isEmpty())
                can.setError("Valor no ingresado");
            if(ipreU.isEmpty())
                pre.setError("Valor no ingresado");
        }else {

            ContentValues reg = new ContentValues();
            reg.put("id", icod);
            reg.put("producto", Snom);
            reg.put("cantidad", ipreP);
            reg.put("precio", ipreU);

            BaseDatos.update("productos", reg, "id=" + icod, null);
            BaseDatos.close();


            Toast.makeText(this, "Producto modificado ", Toast.LENGTH_LONG).show();
            /*Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
            startActivityForResult(intent, 0);
            finish();*/
        }
    }
}