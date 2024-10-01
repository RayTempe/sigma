package com.example.a2k;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.a2k.databinding.ActivityFragmentBinding;
import com.example.a2k.R;  // Pastikan ini sudah ada

public class FragmentActivity extends AppCompatActivity {

    private ActivityFragmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout using ViewBinding
        binding = ActivityFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set a listener for the BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.List) {
                replaceFragment(new ListFragment());
            } else if (id == R.id.Kontak) {
                replaceFragment(new KontakFragment());
            } else if (id == R.id.Kosong) {
                replaceFragment(new KosongFragment());
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        // Get FragmentManager and start a FragmentTransaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the frame layout with the selected fragment
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }
}
