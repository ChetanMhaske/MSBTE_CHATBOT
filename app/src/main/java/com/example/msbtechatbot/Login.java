package com.example.msbtechatbot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {

    private MaterialButton btnThemeToggle, btnLogin;
    private SharedPreferences sharedPreferences;
    private EditText etEmail, etPassword;
    private TextView tvSignUp, tvForgotPassword;

    @SuppressLint("MissingInflatedId")
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

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);

        // Find Views
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvSignUp = findViewById(R.id.tvSignUp);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

         // Set

        // Login Button Click Listener
        btnLogin.setOnClickListener(v -> validateLogin());

        // Sign Up Click Listener
        tvSignUp.setOnClickListener(v -> navigateToSignUp());
    }

    private void validateLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            // Proceed to next activity (if needed)
            // startActivity(new Intent(this, HomeActivity.class));
        }
    }

    private void navigateToSignUp() {
        Toast.makeText(this, "Navigate to Sign Up", Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(this, SignUpActivity.class));
    }
}