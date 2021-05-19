package com.example.photoeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.photoeditor.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_result);

        binding.image.setImageURI(getIntent().getData());
    }
}