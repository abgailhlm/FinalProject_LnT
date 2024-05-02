package com.example.aplikasifinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText loginEmail = findViewById(R.id.loginEmail);
        EditText loginPassword = findViewById(R.id.loginPassword);
        Button loginButton = findViewById(R.id.loginButton);
        Button toregisteractivityButton = findViewById(R.id.toregisteractivityButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempEmail = String.valueOf(loginEmail.getText());
                String tempPassword = String.valueOf(loginPassword.getText());

                if (tempEmail.isEmpty() || tempPassword.isEmpty()){
                    Toast
                       .makeText(LoginActivity.this,"All fields must be filled!", Toast.LENGTH_LONG )
                       .show();
                } else if (!tempEmail.contains("@") ||!tempEmail.endsWith(".com")){
                    Toast
                        .makeText(LoginActivity.this,"Email Format Incorrect!", Toast.LENGTH_LONG )
                        .show();
                } else{
                    Intent toHome =new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(toHome);
                }
            }
        });

        toregisteractivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(toRegister);
                finish();
            }
        });
    }
}