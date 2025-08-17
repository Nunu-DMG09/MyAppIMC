package com.example.imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                // Usuario correcto: david / contraseña: 123
                if (user.equals("david") && pass.equals("123")) {
                    Toast.makeText(MainActivity.this, "Login correcto ✅", Toast.LENGTH_SHORT).show();

                    // Pasamos a HomeActivity y mandamos el nombre de usuario
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("USERNAME", user);
                    startActivity(intent);
                    finish(); // cierra el login para que no regrese con el botón atrás
                } else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos ❌", Toast.LENGTH_SHORT).show();
                }
            }
        });

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}