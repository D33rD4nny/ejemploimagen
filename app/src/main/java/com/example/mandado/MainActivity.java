package com.example.mandado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mandado.Adaptadores.AdapterProductos;
import com.example.mandado.Modelo.ModUsuario;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //region VARIABLES
    @BindView(R.id.etArticulo) EditText etArticulo;
    @BindView(R.id.etDescripcion) EditText etDescripcion;
    @BindView(R.id.etCantidad) EditText etCantidad;
    @BindView(R.id.srUnidad)Spinner srUnidad;
    @BindView(R.id.srImagen)Spinner srImagen;
    @BindView(R.id.btnAgregar) Button btnAgregar;
    @BindView(R.id.lvLista) ListView lvLista;
    ArrayAdapter<String> adaptTextKilos;
    List<String> listTextKilos;
    ArrayAdapter<String> adaptImage;
    List<String> listImage;
    List<ModUsuario> listUsuario;
    AdapterProductos productosAdapt;

    //endregion
    //region CONSTRUCTOR
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        InicializarVariable();
        listUsuario= new ArrayList<>();
        productosAdapt= new AdapterProductos(this,listUsuario);
        lvLista.setAdapter(productosAdapt);

    }
    //endregion

    //region METODOS
    private void InicializarVariable(){
        listTextKilos = new ArrayList<>();
        listTextKilos.add("");
        listTextKilos.add("Kg");
        listTextKilos.add("Gr");
        adaptTextKilos=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,listTextKilos);
        srUnidad.setAdapter(adaptTextKilos);

        listImage=new ArrayList<>();
        listImage.add("");
        listImage.add("Manzana");
        listImage.add("Tomate");
        listImage.add("Cebolla");
        listImage.add("Leche");
        listImage.add("Huevos");
        listImage.add("Queso");
        adaptImage= new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,listImage);
        srImagen.setAdapter(adaptImage);
    }
    //endregion

    //region EVENTOS
    @OnClick(R.id.btnAgregar)
    public void Agregar(){
    if (etArticulo.getText().toString().equals("")||etDescripcion.getText().toString().equals("")||etCantidad.toString().equals("")||srImagen.getSelectedItem().toString().equals("")||srUnidad.getSelectedItem().toString().equals(""))
        Toast.makeText(this,"No se introdujeron datos ",Toast.LENGTH_LONG).show();
        else{
        ModUsuario usuario =new ModUsuario();
        usuario.setProducto(etArticulo.getText().toString());
        usuario.setDescripcion(etDescripcion.getText().toString());
        usuario.setCantidad(etCantidad.getText().toString());
        usuario.setUnidad(srUnidad.getSelectedItem().toString());
       usuario.setImagen(srImagen.getSelectedItem().toString());

        listUsuario.add(usuario);
        productosAdapt.notifyDataSetChanged();
        etArticulo.setText("");
        etDescripcion.setText("");
        etCantidad.setText("");

        }
    }
    //endregion
}
