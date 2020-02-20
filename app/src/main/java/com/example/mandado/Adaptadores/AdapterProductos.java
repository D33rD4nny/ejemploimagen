package com.example.mandado.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mandado.Modelo.ModUsuario;
import com.example.mandado.R;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterProductos extends BaseAdapter {
    //
    private List<ModUsuario> listUsuario;
    private LayoutInflater inflater;

    public AdapterProductos(Context context, List<ModUsuario>listUsuario){
        this.listUsuario=listUsuario;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){return listUsuario.size();}



    @Override
    public Object getItem(int i) { return this.listUsuario.get(i); }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.oblista, null);
            holder = new ViewHolder();
            holder.tvTitulo = view.findViewById(R.id.obTitulo);
            holder.tvDescripcion = view.findViewById(R.id.obEtDescripcion);
            holder.tvCantidad = view.findViewById(R.id.obEtCantidad);
            holder.tvUnidad = view.findViewById(R.id.obEtUnidad);
            holder.ivImagen = view.findViewById(R.id.obIvImagen);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        switch (listUsuario.get(i).getImagen()) {
            case "Manzana":
                holder.ivImagen.setImageResource(R.drawable.ic_apple);
                break;
            case "Tomate":
                holder.ivImagen.setImageResource(R.drawable.ic_tomato);
                break;
            case "Cebolla":
                holder.ivImagen.setImageResource(R.drawable.ic_onion);
                break;
            case "Leche":
                holder.ivImagen.setImageResource(R.drawable.ic_milk_bottle);
                break;
            case "Huevos":
                holder.ivImagen.setImageResource(R.drawable.ic_eggs);
                break;
            case "Queso":
                holder.ivImagen.setImageResource(R.drawable.ic_cheese);
                break;
        }
        holder.tvTitulo.setText(listUsuario.get(i).getProducto());
        holder.tvDescripcion.setText(listUsuario.get(i).getDescripcion());
        holder.tvCantidad.setText(listUsuario.get(i).getCantidad());
        holder.tvUnidad.setText(listUsuario.get(i).getUnidad());
        return view;
    }

    private class ViewHolder{
        private TextView tvTitulo, tvDescripcion, tvCantidad, tvUnidad;
        private ImageView ivImagen;
    }
}
