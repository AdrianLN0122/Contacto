package com.example.aplicacionesdeandroidsemana2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView TV_Nombre;
    TextView TV_Telefono;
    TextView TV_Email;
    TextView TV_Descripcion;
    Button B_Siguiente;
    CalendarView calendario;
    long fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_Nombre= findViewById(R.id.TV_Nombre);
        TV_Telefono= findViewById(R.id.TV_Telefono);
        TV_Email= findViewById(R.id.TV_Email);
        TV_Descripcion= findViewById(R.id.TV_Descripcion);
        B_Siguiente= findViewById(R.id.B_Siguiente);
        calendario= (CalendarView) findViewById(R.id.CV_Calendario);

        final String[] Datos = new String[5];
        String[] Datos2 = new String[5];
        boolean Editar;

        Intent j = getIntent();
        Editar= j.getBooleanExtra("Editar", false);

        if(Editar){
            Datos2= j.getStringArrayExtra("Datos");
            fecha = j.getLongExtra("Fecha",0);
            TV_Nombre.setText(Datos2[0]);
            TV_Telefono.setText(Datos2[1]);
            TV_Email.setText(Datos2[2]);
            TV_Descripcion.setText(Datos2[3]);
        }

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Datos[4]= i2 + "/" + (i1+1)+"/" +i;
            }
        });

        B_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InformacionActivity.class);
                Datos[0]= TV_Nombre.getText().toString();
                Datos[1]= TV_Telefono.getText().toString();
                Datos[2]= TV_Email.getText().toString();
                Datos[3]= TV_Descripcion.getText().toString();
                i.putExtra("Datos",Datos);
                fecha= calendario.getDate();
                startActivity(i);
                finish();
            }
        });
    }
}
