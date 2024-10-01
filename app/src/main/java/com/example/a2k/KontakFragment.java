package com.example.a2k;

import android.os.Bundle;  // Import library untuk berinteraksi dengan Bundle
import android.view.LayoutInflater;  // Import LayoutInflater untuk menampilkan layout
import android.view.View;  // Import kelas View untuk berinteraksi dengan elemen UI
import android.view.ViewGroup;  // Import ViewGroup sebagai container dari layout
import android.widget.ArrayAdapter;  // Import ArrayAdapter untuk mengelola data ke dalam ListView
import android.widget.ListView;  // Import ListView untuk menampilkan daftar data
import androidx.fragment.app.Fragment;  // Import kelas Fragment untuk membuat fragment
import java.util.ArrayList;  // Import ArrayList untuk menyimpan data dinamis


// Deklarasi kelas KontakFragment yang mewarisi Fragment
public class KontakFragment extends Fragment {

    // Deklarasi variabel ListView dan ArrayList untuk menampung data mahasiswa
    ListView listView;
    ArrayList<Mahasiswa> mahasiswaList;

    // Konstruktor kosong untuk KontakFragment, diperlukan untuk fragment
    public KontakFragment() {
        // Required empty public constructor
    }

    // Metode onCreateView yang akan dipanggil saat fragment ini dibuat
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_kontak dan kaitkan dengan View yang akan digunakan
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        // Inisialisasi ListView dengan ID listView dari layout XML
        listView = view.findViewById(R.id.listView);

        // Inisialisasi ArrayList untuk menyimpan data mahasiswa
        mahasiswaList = new ArrayList<>();

        // Panggil metode untuk menambahkan data mahasiswa ke ArrayList
        addMahasiswaData();

        // Buat adapter yang menghubungkan data ArrayList ke ListView
        MahasiswaAdapter adapter = new MahasiswaAdapter(getContext(), mahasiswaList);

        // Set adapter untuk ListView agar dapat menampilkan data mahasiswa
        listView.setAdapter(adapter);

        // Kembalikan View yang sudah di-inflate untuk ditampilkan pada UI
        return view;
    }

    // Metode untuk menambahkan data mahasiswa ke dalam ArrayList
    private void addMahasiswaData() {
        // Menambahkan data mahasiswa berupa nama, email, dan nomor telepon
        mahasiswaList.add(new Mahasiswa("Mahasiswa 1", "mahasiswa1@example.com", "08123456789"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 2", "mahasiswa2@example.com", "08123456780"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 3", "mahasiswa3@example.com", "08123456781"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 4", "mahasiswa4@example.com", "08123456782"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 5", "mahasiswa5@example.com", "08123456783"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 6", "mahasiswa6@example.com", "08123456784"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 7", "mahasiswa7@example.com", "08123456785"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 8", "mahasiswa8@example.com", "08123456786"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 9", "mahasiswa9@example.com", "08123456787"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 10", "mahasiswa10@example.com", "08123456788"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 11", "mahasiswa11@example.com", "08123456789"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 12", "mahasiswa12@example.com", "08123456790"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 13", "mahasiswa13@example.com", "08123456791"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 14", "mahasiswa14@example.com", "08123456792"));
        mahasiswaList.add(new Mahasiswa("Mahasiswa 15", "mahasiswa15@example.com", "08123456793"));
    }
}
