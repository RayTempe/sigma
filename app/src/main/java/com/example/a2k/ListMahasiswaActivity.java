package com.example.a2k;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListMahasiswaActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listView = findViewById(R.id.List);

        // Menggunakan adapter untuk mengisi data dari resource array ke ListView
        adapter = ArrayAdapter.createFromResource(this, R.array.nama_mhs, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        // Menambahkan event listener untuk meng-handle klik pada item di ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = parent.getItemAtPosition(position).toString();
            Toast.makeText(ListMahasiswaActivity.this, "Anda memilih: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
    }
}
