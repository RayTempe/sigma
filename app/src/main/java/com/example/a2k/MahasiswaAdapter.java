package com.example.a2k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {

    public MahasiswaAdapter(Context context, List<Mahasiswa> mahasiswaList) {
        super(context, 0, mahasiswaList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Dapatkan data mahasiswa untuk posisi ini
        Mahasiswa mahasiswa = getItem(position);

        // Cek apakah ada view yang bisa digunakan kembali; jika tidak, inflasi view baru
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        }

        // Temukan view yang perlu diperbarui
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView emailTextView = convertView.findViewById(R.id.emailTextView);
        TextView phoneTextView = convertView.findViewById(R.id.phoneTextView);
        ImageView profileImageView = convertView.findViewById(R.id.profileImage);

        // Set data ke dalam view
        nameTextView.setText(mahasiswa.getName());
        emailTextView.setText(mahasiswa.getEmail());
        phoneTextView.setText(mahasiswa.getPhoneNumber());
        profileImageView.setImageResource(R.drawable.baseline_person_24); // Ganti dengan drawable profil Anda

        // Kembalikan view yang sudah diperbarui
        return convertView;
    }
}
