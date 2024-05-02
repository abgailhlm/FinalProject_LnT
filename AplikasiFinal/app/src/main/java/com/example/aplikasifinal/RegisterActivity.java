package com.example.aplikasifinal;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText registerEmail = findViewById(R.id.registerEmail);
        EditText registerPassword = findViewById(R.id.registerPassword);
        EditText registerconfirmPassword = findViewById(R.id.registerconfirmPassword);
        EditText IDBimbel = findViewById(R.id.registerIDbimbel);
        EditText registerName = findViewById(R.id.registerName);
        Button registerButton = findViewById(R.id.registerButton);
        Button tologinactivityButton = findViewById(R.id.tologinactivityButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempEmail = String.valueOf(registerEmail.getText());
                String tempPassword = String.valueOf(registerPassword.getText());
                String tempIDBimbel = String.valueOf(IDBimbel.getText());
                String tempName = String.valueOf(registerName.getText());
                String tempregisterconfirmPassword = String.valueOf(registerconfirmPassword.getText());

                if (tempName.isEmpty() || tempEmail.isEmpty() || tempPassword.isEmpty() || tempIDBimbel.isEmpty() || tempregisterconfirmPassword.isEmpty()){
                    Toast
                            .makeText(RegisterActivity.this,"All fields must be filled!", Toast.LENGTH_LONG )
                            .show();
                } else if (!tempEmail.contains("@") ||!tempEmail.endsWith(".com")){
                    Toast
                            .makeText(RegisterActivity.this,"Email format Incorrect!", Toast.LENGTH_LONG )
                            .show();
                } else if (tempName.length()<5){
                    Toast
                            .makeText(RegisterActivity.this, "Name character must be more than 5!", Toast.LENGTH_SHORT)
                            .show();
                } else if (!tempregisterconfirmPassword.equals(tempPassword)){
                    Toast
                            .makeText(RegisterActivity.this, "The password confirmation does not match!", Toast.LENGTH_SHORT)
                            .show();
                } else{
                    SharedPreferences sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", tempName);
                    editor.putString("email", tempEmail);
                    editor.putString("password", tempPassword);
                    editor.putString("idBimbel", tempIDBimbel);
                    editor.apply();
                    Intent toLogin =new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(toLogin);
                    finish();
                }
            }
        });

        tologinactivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(toLogin);
            }
        });
    }
}