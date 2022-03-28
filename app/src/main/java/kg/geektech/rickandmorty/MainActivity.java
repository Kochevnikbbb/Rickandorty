package kg.geektech.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kg.geektech.rickandmorty.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}