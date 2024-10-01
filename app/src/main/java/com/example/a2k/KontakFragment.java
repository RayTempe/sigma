package com.example.a2k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class KontakFragment extends Fragment {

    ListView listView;
    ArrayList<Mahasiswa> mahasiswaList;

    public KontakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        // Inisialisasi ListView
        listView = view.findViewById(R.id.listView);

        // Inisialisasi ArrayList untuk mahasiswa
        mahasiswaList = new ArrayList<>();

        // Tambahkan data mahasiswa
        addMahasiswaData();

        // Buat adapter untuk ListView
        MahasiswaAdapter adapter = new MahasiswaAdapter(getContext(), mahasiswaList);

        // Set adapter ke ListView
        listView.setAdapter(adapter);

        return view;
    }

    private void addMahasiswaData() {
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
