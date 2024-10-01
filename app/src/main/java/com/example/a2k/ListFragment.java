package com.example.a2k;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Dalam ListFragment.java
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_list.xml
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Mengambil array dari strings.xml
        String[] data = getResources().getStringArray(R.array.nama_mhs);

        // Inisialisasi ListView
        ListView listView = view.findViewById(R.id.listViewMahasiswa);

        // Membuat adapter untuk ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_list_item_1, data);

        // Set adapter ke ListView
        listView.setAdapter(adapter);

        return view;
    }
}
