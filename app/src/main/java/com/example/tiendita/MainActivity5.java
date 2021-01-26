package com.example.tiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    EditText eli_cod;
    EditText pro;
    EditText can;
    EditText pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        eli_cod=(EditText)findViewById(R.id.ID);
        pro = (EditText)findViewById(R.id.PRODUCTO);
        can = (EditText)findViewById(R.id.CANTIDAD);
        pre = (EditText)findViewById(R.id.PRECIO);
    }

    public void eliminar (View view){

        String icod = eli_cod.getText().toString();

        if(icod.isEmpty()){
            if(icod.isEmpty()) {
                eli_cod.setError("Valor no ingresado");
                Toast.makeText(this, "Ingresa el código", Toast.LENGTH_LONG).show();
            }
        }else {
            BaseD dbD= new BaseD(this, "db", null, 1);
            SQLiteDatabase BaseDatos = dbD.getWritableDatabase();

            if(!icod.isEmpty()) {
                Cursor fila = BaseDatos.rawQuery("select producto, cantidad, precio from productos where id= " +icod, null);
                if(fila.moveToFirst()) {
                    BaseDatos.delete("productos", "id= " + icod, null);
                    BaseDatos.close();
                    eli_cod.setText("");
                    Toast.makeText(this, "Producto eliminado", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "El producto no existe ", Toast.LENGTH_LONG).show();
                    eli_cod.setText("");
                    BaseDatos.close();
                }
            }
        }
    }
}