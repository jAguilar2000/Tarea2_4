package com.example.tarea2_4;

import android.graphics.Bitmap;

public class SetData {
    String descripcion;
    Bitmap firmaBitmap;

    SetData(String descripcion, Bitmap firmaBitmap){
        this.descripcion = descripcion;
        this.firmaBitmap = firmaBitmap;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Bitmap getFirmaBitmap() {
        return firmaBitmap;
    }
}
