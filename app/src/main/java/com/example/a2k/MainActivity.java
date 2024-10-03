package com.example.a2k;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText fullNameField, usernameField, emailField, passwordField, confirmPasswordField, phoneNumberField, dateBornField;
    Spinner genderSpinner;
    Button registerButton;
    Calendar calendar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi view
        fullNameField = findViewById(R.id.fullName);
        usernameField = findViewById(R.id.username);
        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        confirmPasswordField = findViewById(R.id.confirmPassword);
        genderSpinner = findViewById(R.id.genderSpinner);
        phoneNumberField = findViewById(R.id.phoneNumber);
        dateBornField = findViewById(R.id.dateBorn);
        registerButton = findViewById(R.id.registerButton);

        // Inisialisasi kalender untuk DatePicker
        calendar = Calendar.getInstance();

        // Setup Spinner untuk pilihan gender
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        // Set DatePickerDialog saat field Date of Birth di klik
        dateBornField.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Tampilkan DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Saat tanggal dipilih, update EditText
                        String dateOfBirth = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        dateBornField.setText(dateOfBirth);
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });

        // Aksi klik tombol register
        registerButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();
            String confirmPassword = confirmPasswordField.getText().toString();

            // Validasi password
            if (password.equals(confirmPassword)) {
                // Tampilkan pesan sukses
                Toast.makeText(MainActivity.this, "Registrasi sukses!", Toast.LENGTH_SHORT).show();

                // Pindah ke halaman login dan kirim email dan password
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                loginIntent.putExtra("email", email);
                loginIntent.putExtra("password", password); // Mengirim password
                startActivity(loginIntent);
            } else {
                // Tampilkan pesan error jika password tidak sama
                Toast.makeText(MainActivity.this, "Password tidak cocok!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
