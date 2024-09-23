package com.example.appandroidtp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cuestionario extends AppCompatActivity {

    RadioButton rButton1,rButton2,rButton3,rButton4;
    TextView txtPreguntaNumero,txtPreguntaCompleta;
    Button btnConfirmar;
    String nombreRecibido;

    int nPregunta = 1;
    int puntajeFinal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuestionario);

        rButton1 = findViewById(R.id.rButton1);
        rButton2 = findViewById(R.id.rButton2);
        rButton3 = findViewById(R.id.rButton3);
        rButton4 = findViewById(R.id.rButton4);

        txtPreguntaNumero = findViewById(R.id.txtPreguntaNumero);
        txtPreguntaCompleta = findViewById(R.id.txtPreguntaCompleta);

        btnConfirmar = findViewById(R.id.btnConfirmar);

        Intent i = getIntent();
        nombreRecibido = i.getStringExtra("mensaje_key");
    }


    public void avanzar(View view){

        if(rButton1.isChecked() == false && rButton2.isChecked() == false &&
                rButton3.isChecked() == false && rButton4.isChecked() == false){
            Toast.makeText(this,"Elija una opcion ",Toast.LENGTH_SHORT).show();

        }else if(nPregunta==1){
            if(rButton1.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            nPregunta = nPregunta+1;
            txtPreguntaNumero.setText("Pregunta 2");
            txtPreguntaCompleta.setText("¿Cómo se llamó la mascota de la Copa Mundial de 1982 en España?");
            rButton1.setText("Juanito");
            rButton2.setText("Fuleco");
            rButton3.setText("Pique");
            rButton4.setText("Naranjito");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);

        }else if(nPregunta==2){
            if(rButton4.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            nPregunta = nPregunta+1;

            txtPreguntaNumero.setText("Pregunta 3");
            txtPreguntaCompleta.setText("¿Cómo se le llamó a la famosa victoria de Uruguay sobre Brasil " +
                    "en la final del torneo mundialista de 1950, " +
                    "cuando los charrúas obtuvieron su segundo título mundial?");

            rButton1.setText("El triunfo del siglo");
            rButton2.setText("El Maracanazo");
            rButton3.setText("El Matabrasileirao");
            rButton4.setText("El Chutazo");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);


        }else if(nPregunta==3){
            if(rButton2.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            nPregunta = nPregunta+1;

            txtPreguntaNumero.setText("Pregunta 4");
            txtPreguntaCompleta.setText("¿Dónde se disputó la Copa Mundial de 1998?");

            rButton1.setText("Italia");
            rButton2.setText("Francia");
            rButton3.setText("Estados Unidos");
            rButton4.setText("Alemania");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);


        }else if(nPregunta==4){
            if(rButton2.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }

            nPregunta = nPregunta+1;

            txtPreguntaNumero.setText("Pregunta 5");
            txtPreguntaCompleta.setText("¿Quién fue el jugador que marcó el gol que le dio el triunfo a " +
                    "España en la final de la Copa del Mundo del 2010 en Sudáfrica?");

            rButton1.setText("Andrés Iniesta");
            rButton2.setText("David Villa");
            rButton3.setText("Raúl González");
            rButton4.setText("Sergio Ramos");

            rButton1.setChecked(false);
            rButton2.setChecked(false);
            rButton3.setChecked(false);
            rButton4.setChecked(false);

        }else if(nPregunta==5){
            if(rButton1.isChecked()){
                puntajeFinal=puntajeFinal+1;
            }
                Intent i = new Intent(this, actividad2.class);
                i.putExtra("mensaje_key",nombreRecibido);
                i.putExtra("puntos",puntajeFinal);
                startActivity(i);


        }



    }


}