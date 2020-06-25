package com.example.appgeometrica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText editNX1;
    private EditText editNX2;
    private EditText editNY1;
    private EditText editNY2;
    private EditText editDistancia;
    private EditText editPendiente;
    private Button btnCalcularDistancia;
    private Button btnCalcularPendiente;

    private void iniciar(){
        editNX1 = (EditText)findViewById(R.id.editNX1);
        editNX2 = (EditText)findViewById(R.id.editNX2);

        editNY1 = (EditText)findViewById(R.id.editNY1);
        editNY2 = (EditText)findViewById(R.id.editNY2);
        editDistancia = (EditText)findViewById(R.id.editDistancia);
        editPendiente = (EditText)findViewById(R.id.editPendiente);

        btnCalcularDistancia = (Button)findViewById(R.id.btnCalcularDistancia);
        btnCalcularPendiente = (Button)findViewById(R.id.btnCalcularPendiente);

        //asignarle un controlador de eventos: listener
        btnCalcularDistancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
        btnCalcularPendiente.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pendiente();
            }
        }));
    }

    private void  calcular() {
        double x1 = Double.parseDouble(editNX1.getText().toString());
        double x2 = Double.parseDouble(editNX2.getText().toString());
        double y1 = Double.parseDouble(editNY1.getText().toString());
        double y2 = Double.parseDouble(editNY2.getText().toString());


        double distancia = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        editDistancia.setText(String.valueOf(distancia));
    }

    private void pendiente() {
        double x1 = Double.parseDouble(editNX1.getText().toString());
        double x2 = Double.parseDouble(editNX2.getText().toString());
        double y1 = Double.parseDouble(editNY1.getText().toString());
        double y2 = Double.parseDouble(editNY2.getText().toString());

        double pendiente = ((y2-y1) / (x2-x1));
        editPendiente.setText(String.valueOf(pendiente));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }
}