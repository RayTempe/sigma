package com.example.a2k;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText emailField, passwordField;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi view
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);

        // Autofill email jika dikirim dari RegisterActivity
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        if (email != null) {
            emailField.setText(email);
        }

        // Aksi klik tombol login
        loginButton.setOnClickListener(v -> {
            String inputEmail = emailField.getText().toString();
            String inputPassword = passwordField.getText().toString();

            // Ambil data dari SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String registeredEmail = sharedPreferences.getString("email", "");
            String registeredPassword = sharedPreferences.getString("password", "");

            // Validasi email dan password
            if (inputEmail.equals(registeredEmail) && inputPassword.equals(registeredPassword)) {
                // Login berhasil
                Intent secondActivityIntent = new Intent(LoginActivity.this, SecondActivity.class);
                startActivity(secondActivityIntent);
            } else {
                // Jika email atau password salah, tampilkan dialog
                showLoginErrorDialog();
            }
        });
    }

    private void showLoginErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Password salah! Apakah Anda ingin melihat daftar mahasiswa?");

        builder.setPositiveButton("Ya", (dialog, which) -> {
            // Pindah ke activity daftar mahasiswa
            Intent listMahasiswaIntent = new Intent(LoginActivity.this, ListMahasiswaActivity.class);
            startActivity(listMahasiswaIntent);
            finish(); // Menutup LoginActivity agar tidak bisa kembali dengan tombol back
        });

        builder.setNegativeButton("Tidak", (dialog, which) -> {
            // Hanya menutup dialog dan tetap di halaman login
            dialog.dismiss(); // Menutup dialog
            Toast.makeText(LoginActivity.this, "Silakan coba lagi.", Toast.LENGTH_SHORT).show();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
