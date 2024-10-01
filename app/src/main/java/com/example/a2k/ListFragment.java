package com.example.a2k;

// Import untuk kelas dan library yang dibutuhkan dalam Fragment
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {

    // Metode ini dipanggil saat fragment dibuat
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Metode untuk membuat tampilan UI fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_list.xml, yaitu layout untuk ListFragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Mengambil array string dari file strings.xml
        // R.array.nama_mhs merujuk pada array yang didefinisikan di file res/values/strings.xml
        String[] data = getResources().getStringArray(R.array.nama_mhs);

        // Inisialisasi ListView yang ada di layout fragment_list.xml dengan ID listViewMahasiswa
        ListView listView = view.findViewById(R.id.listViewMahasiswa);

        // Membuat adapter untuk menghubungkan data array dengan ListView
        // Adapter ini menggunakan layout bawaan android, simple_list_item_1 untuk menampilkan item
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_list_item_1, data);

        // Mengatur adapter ke ListView agar data ditampilkan
        listView.setAdapter(adapter);

        // Mengembalikan View yang telah di-inflate agar fragment ini dapat ditampilkan
        return view;
    }
}
