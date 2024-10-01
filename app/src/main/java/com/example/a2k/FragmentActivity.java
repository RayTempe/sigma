package com.example.a2k;

import android.os.Bundle;  // Import library untuk bekerja dengan bundel dalam activity
import androidx.appcompat.app.AppCompatActivity;  // Import library untuk Activity berbasis AppCompat
import androidx.fragment.app.Fragment;  // Import library untuk bekerja dengan Fragment
import androidx.fragment.app.FragmentManager;  // Import library untuk mengelola Fragment
import androidx.fragment.app.FragmentTransaction;  // Import library untuk transaksi Fragment
import com.example.a2k.databinding.ActivityFragmentBinding;  // Import kelas yang dihasilkan otomatis oleh ViewBinding


// Deklarasi kelas FragmentActivity yang mewarisi AppCompatActivity
public class FragmentActivity extends AppCompatActivity {

    // Deklarasi variabel binding untuk mengikat ViewBinding dari activity_fragment.xml
    private ActivityFragmentBinding binding;

    // Metode onCreate yang dijalankan saat activity pertama kali dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Memanggil metode onCreate superclass

        // Inflate layout menggunakan ViewBinding dan mengaitkan layout activity_fragment.xml
        binding = ActivityFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());  // Mengatur tampilan root layout yang dihasilkan oleh binding

        // Set listener untuk BottomNavigationView agar merespon pilihan item yang di-klik
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            // Ambil ID dari item yang dipilih
            int id = item.getItemId();

            // Cek ID item yang dipilih, lalu ganti fragment yang sesuai
            if (id == R.id.List) {
                replaceFragment(new ListFragment());  // Jika item dengan ID R.id.List dipilih, ganti dengan ListFragment
            } else if (id == R.id.Kontak) {
                replaceFragment(new KontakFragment());  // Jika item dengan ID R.id.Kontak dipilih, ganti dengan KontakFragment
            } else if (id == R.id.Kosong) {
                replaceFragment(new KosongFragment());  // Jika item dengan ID R.id.Kosong dipilih, ganti dengan KosongFragment
            }
            return true;  // Mengembalikan true untuk menandakan bahwa item telah dipilih
        });
    }

    // Metode untuk menggantikan fragment yang ditampilkan di dalam frame layout
    private void replaceFragment(Fragment fragment) {
        // Dapatkan FragmentManager untuk mulai bekerja dengan fragment
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Memulai transaksi fragment, yaitu tindakan untuk mengganti atau menambah fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Mengganti fragment yang ada di frame layout dengan fragment baru
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        // Commit transaksi untuk menerapkan perubahan
        fragmentTransaction.commit();
    }
}
