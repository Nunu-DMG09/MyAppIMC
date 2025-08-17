package com.example.imcapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText alturaInput, pesoInput;
    Button calcularButton, logoutButton;
    TextView resultadoIMC, welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        alturaInput = findViewById(R.id.alturaInput);
        pesoInput = findViewById(R.id.pesoInput);
        calcularButton = findViewById(R.id.calcularButton);
        logoutButton = findViewById(R.id.logoutButton);
        resultadoIMC = findViewById(R.id.resultadoIMC);
        welcomeText = findViewById(R.id.welcomeText);

        // Mostrar nombre de usuario
        String username = getIntent().getStringExtra("USERNAME");
        welcomeText.setText("Bienvenido, " + username);

        // Botón Calcular
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double altura = Double.parseDouble(alturaInput.getText().toString());
                    double peso = Double.parseDouble(pesoInput.getText().toString());
                    double imc = peso / Math.pow(altura, 2);

                    String diagnostico;
                    if (imc < 18.5) {
                        diagnostico = "Insufiencia Ponderal";
                    } else if (imc < 24.9) {
                        diagnostico = "Intervalo Normal";
                    } else if (imc == 25) {
                        diagnostico = "Sobrepeso";
                    } else if (imc <= 29.9) {
                        diagnostico = "Preobesidad";
                    } else if (imc == 30) {
                        diagnostico = "OBESIDAD";
                    } else if (imc <= 34.9) {
                        diagnostico = "Obesidad de clase I";
                    } else if (imc <= 39.9) {
                        diagnostico = "Obesidad de clase II";
                    } else if (imc <= 40) {
                        diagnostico = "Obesidad de clase III";
                    } else{
                        diagnostico = "Considerate una galaxia ❤️";
                    }

                    resultadoIMC.setText("IMC: " + String.format("%.2f", imc) + "\n" + diagnostico);
                } catch (Exception e) {
                    Toast.makeText(HomeActivity.this, "Por favor ingresa valores válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Botón cerrar sesión
        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
