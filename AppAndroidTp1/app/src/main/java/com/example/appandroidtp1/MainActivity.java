package com.example.appandroidtp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextMensaje = findViewById(R.id.editTextText);

    }


    public void irCuestionario(View view){
        String nombre = editTextMensaje.getText().toString();

        if(nombre.isEmpty()){
            Toast.makeText(this,"Ingrese su nombre ",Toast.LENGTH_SHORT).show();

        }else{
            Intent i = new Intent(this, cuestionario.class);
            i.putExtra("mensaje_key",nombre);
            startActivity(i);
        }


    }
}