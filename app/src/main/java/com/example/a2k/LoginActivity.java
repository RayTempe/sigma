package com.example.a2k;

import android.content.Intent;
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

        // Autofill email dan password jika dikirim dari RegisterActivity
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password"); // Ambil password dari Intent

        if (email != null) {
            emailField.setText(email);
        }

        // Aksi klik tombol login
        loginButton.setOnClickListener(v -> {
            String inputEmail = emailField.getText().toString();
            String inputPassword = passwordField.getText().toString();

            // Validasi email dan password
            if (inputEmail.equals(email) && inputPassword.equals(password)) {
                // Login berhasil, pindah ke FragmentActivity
                Intent fragmentActivityIntent = new Intent(LoginActivity.this, FragmentActivity.class);
                startActivity(fragmentActivityIntent);
                finish(); // Menutup LoginActivity agar tidak bisa kembali dengan tombol back
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
            dialog.dismiss();
            Toast.makeText(LoginActivity.this, "Silakan coba lagi kawan.", Toast.LENGTH_SHORT).show();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
