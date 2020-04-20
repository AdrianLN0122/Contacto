package com.example.aplicacionesdeandroidsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InformacionActivity extends AppCompatActivity {

    TextView Nombre;
    TextView Fecha;
    TextView Telefono;
    TextView Email;
    TextView Descricpion;
    Button Editar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Intent j = getIntent();
        final String[]Datos=j.getStringArrayExtra("Datos");

        Nombre= findViewById(R.id.TV_Nombre2);
        Telefono= findViewById(R.id.TV_Telefono2);
        Email= findViewById(R.id.TV_Email2);
        Descricpion= findViewById(R.id.TV_Descripcion2);
        Fecha= findViewById(R.id.TV_Fecha2);
        Editar  =findViewById(R.id.B_Editar);

        Nombre.setText(Nombre.getText()+ Datos[0]);
        Telefono.setText(Telefono.getText()+ Datos[1]);
        Email.setText(Email.getText()+ Datos[2]);
        Descricpion.setText(Descricpion.getText()+ Datos[3]);
        Fecha.setText(Fecha.getText()+ Datos[4]);

        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (InformacionActivity.this, MainActivity.class);
                i.putExtra("Editar", true);
                i.putExtra("Datos",Datos);
                startActivity(i);
                finish();
            }
        });

    }
}
