package com.example.appandroidtp1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad2);

        TextView textViewMensaje = findViewById(R.id.textView);

        String mensajeRecibido = getIntent().getStringExtra("mensaje_key");


        String data = "Nombre: " + mensajeRecibido;
        textViewMensaje.setText(mensajeRecibido);

    }

    public void finalizar(View view){
        finish();
    }




}