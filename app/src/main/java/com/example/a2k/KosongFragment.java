package com.example.a2k;

import android.os.Bundle;  // Import Bundle untuk menyimpan dan mengambil data antar activity atau fragment
import androidx.fragment.app.Fragment;  // Import Fragment dari AndroidX
import android.view.LayoutInflater;  // Import LayoutInflater untuk menampilkan layout fragment
import android.view.View;  // Import kelas View untuk berinteraksi dengan elemen UI
import android.view.ViewGroup;  // Import ViewGroup sebagai container dari layout fragment

// Deklarasi kelas KosongFragment yang mewarisi Fragment
public class KosongFragment extends Fragment {

    // Deklarasi konstanta untuk nama argument (ARG_PARAM1 dan ARG_PARAM2), digunakan untuk menyimpan parameter yang akan diteruskan ke fragment
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Deklarasi variabel instance untuk menyimpan parameter yang diterima oleh fragment
    private String mParam1;
    private String mParam2;

    // Konstruktor kosong untuk KosongFragment, diperlukan untuk fragment
    public KosongFragment() {
        // Required empty public constructor
    }

    // Metode `newInstance` untuk membuat instance baru dari KosongFragment
    // Digunakan untuk melewatkan data (param1 dan param2) ke fragment
    public static KosongFragment newInstance(String param1, String param2) {
        KosongFragment fragment = new KosongFragment();  // Buat instance baru KosongFragment
        Bundle args = new Bundle();  // Buat Bundle untuk menyimpan parameter
        args.putString(ARG_PARAM1, param1);  // Simpan param1 ke dalam Bundle dengan key ARG_PARAM1
        args.putString(ARG_PARAM2, param2);  // Simpan param2 ke dalam Bundle dengan key ARG_PARAM2
        fragment.setArguments(args);  // Tetapkan Bundle sebagai argument fragment
        return fragment;  // Kembalikan fragment yang baru dibuat
    }

    // Metode onCreate yang dipanggil saat fragment dibuat pertama kali
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Memanggil superclass
        if (getArguments() != null) {  // Cek apakah ada argument yang diteruskan ke fragment
            mParam1 = getArguments().getString(ARG_PARAM1);  // Ambil parameter 1 dari argument
            mParam2 = getArguments().getString(ARG_PARAM2);  // Ambil parameter 2 dari argument
        }
    }

    // Metode onCreateView yang digunakan untuk meng-inflate layout fragment menjadi objek View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_kosong dan kembalikan sebagai objek View
        return inflater.inflate(R.layout.fragment_kosong, container, false);
    }
}
