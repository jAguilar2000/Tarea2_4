package com.example.tarea2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;

public class ActivityList extends AppCompatActivity {

    Button btnRegresar;
    ListView listView;
    SQLiteConexion conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listFirmas);
        btnRegresar = (Button)findViewById(R.id.btnRegresar_menu);

        conexion = new SQLiteConexion(this, Transacciones.DBName, null, 1);
        List<SetData> setData;
        setData = new ArrayList<>();

        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(Transacciones.SelectAllSignaturess, null);

        while(cursor.moveToNext()){
            Bitmap firmaBitmap = VerFirma(cursor.getString(1));
            setData.add(new SetData(cursor.getString(2), firmaBitmap));
        }
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.list_items, setData);

        listView.setAdapter(customAdapter);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private Bitmap VerFirma(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        Bitmap bitmapGlobal = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return bitmapGlobal;
    }
}