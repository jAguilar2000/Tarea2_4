package com.example.tarea2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;
import Models.Signaturess;

public class ActivityFirmaDigital extends AppCompatActivity {
    Button btnGuardar, btnRegresar;
    EditText textDescripcion;
    private Dibujar dibujar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firma_digital);

        textDescripcion = (EditText) findViewById(R.id.textDescripcion);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        dibujar = findViewById(R.id.lienzo);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendData();
            }
        });
    }

    private void SendData() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.DBName, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        String firmaBase64 = dibujar.convertirFirmaABase64();
        valores.put(Transacciones.descripcion, textDescripcion.getText().toString());
        valores.put(Transacciones.firmaDigital, firmaBase64);

        Long resultado = db.insert(Transacciones.TableSignatures, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(), "Registro Ingresado con exito " + resultado.toString(), Toast.LENGTH_LONG).show();
        db.close();

    }
}