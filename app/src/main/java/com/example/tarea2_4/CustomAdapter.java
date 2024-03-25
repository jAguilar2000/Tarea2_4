package com.example.tarea2_4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<SetData>{
    List<SetData> setData;
    int resource;
    Context context;
    public CustomAdapter(Context context, int resource, List<SetData> setData){
        super(context, resource, setData);
        this.context = context;
        this.resource = resource;
        this.setData = setData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        @SuppressLint("ViewHolder") View view = layoutInflater.inflate(resource, null, false);
        TextView textViewDescripcion = view.findViewById(R.id.textDescription);
        ImageView imageViewList = view.findViewById(R.id.listImage);

        final SetData setDataNew = setData.get(position);
        textViewDescripcion.setText(setDataNew.getDescripcion());
        imageViewList.setImageBitmap(setDataNew.getFirmaBitmap());
        return  view;
    }
}
