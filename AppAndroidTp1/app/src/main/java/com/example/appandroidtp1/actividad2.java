package com.example.appandroidtp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class actividad2 extends AppCompatActivity {

    ImageView imageViewGanador, imageViewPerdedor;
    TextView textViewGanador,textViewPuntaje;
    String nombreRecibido;
    int puntajeFinal;
    Button buttonVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad2);

        Intent i = getIntent();
        nombreRecibido = i.getStringExtra("mensaje_key");
        puntajeFinal = i.getIntExtra("puntos",0);

        textViewGanador = findViewById(R.id.textViewGanador);
        textViewPuntaje = findViewById(R.id.textViewPuntaje);

        imageViewGanador =  findViewById(R.id.imageViewGanador);
        imageViewPerdedor = findViewById(R.id.imageViewPerdedor);

        buttonVolver = findViewById(R.id.buttonVolver);

        if(puntajeFinal>=3){
            textViewGanador.setText("Felicidades "+nombreRecibido+" Ganaste!!");
            textViewPuntaje.setText("Tu puntaje final es: "+puntajeFinal);
            imageViewGanador.setVisibility(View.VISIBLE);
            imageViewPerdedor.setVisibility(View.INVISIBLE);

        }else {
            textViewGanador.setText("Mala suerte ;( "+nombreRecibido+" Perdiste");
            textViewPuntaje.setText("Tu puntaje final es: "+puntajeFinal);
            imageViewGanador.setVisibility(View.INVISIBLE);
            imageViewPerdedor.setVisibility(View.VISIBLE);
        }
    }


    public void volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}