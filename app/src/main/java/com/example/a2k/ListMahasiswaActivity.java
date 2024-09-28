package com.example.a2k;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListMahasiswaActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listView = findViewById(R.id.listView);
        mahasiswaList = new ArrayList<>();

        // Tambahkan 15 data mahasiswa
        addMahasiswaData();

        // Set adapter untuk ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mahasiswaList);
        listView.setAdapter(adapter);
    }

    private void addMahasiswaData() {
        mahasiswaList.add("Mahasiswa 1");
        mahasiswaList.add("Mahasiswa 2");
        mahasiswaList.add("Mahasiswa 3");
        mahasiswaList.add("Mahasiswa 4");
        mahasiswaList.add("Mahasiswa 5");
        mahasiswaList.add("Mahasiswa 6");
        mahasiswaList.add("Mahasiswa 7");
        mahasiswaList.add("Mahasiswa 8");
        mahasiswaList.add("Mahasiswa 9");
        mahasiswaList.add("Mahasiswa 10");
        mahasiswaList.add("Mahasiswa 11");
        mahasiswaList.add("Mahasiswa 12");
        mahasiswaList.add("Mahasiswa 13");
        mahasiswaList.add("Mahasiswa 14");
        mahasiswaList.add("Mahasiswa 15");
    }
}
