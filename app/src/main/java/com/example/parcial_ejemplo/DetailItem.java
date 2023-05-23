package com.example.parcial_ejemplo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailItem extends AppCompatActivity {

    TextView  code,name,cantidad,sale,size,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        String codigo,nombre,stock,precio,talla,descripcion;

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detalle Prenda");

         Intent intent = getIntent();
        if (intent != null) {
            code = findViewById(R.id.viewStock);
            name = findViewById(R.id.viewTitle);
            sale = findViewById(R.id.viewPrecio);
            size = findViewById(R.id.viewSize);
            description = findViewById(R.id.viewDescription);

            codigo = intent.getStringExtra("code");
            nombre = intent.getStringExtra("name");
            stock = intent.getStringExtra("stock");
            precio = intent.getStringExtra("sale");
            talla = intent.getStringExtra("size");
            descripcion = intent.getStringExtra("description");

            code.setText(codigo+" - "+stock+" Unidades disponibles");
            name.setText(nombre);
            sale.setText("S/. " +precio);
            size.setText("Talla "+talla);
            description.setText(descripcion);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}