package com.dian.recyclertiga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String FULL_NAME = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvFullName = findViewById(R.id.full_name);
        String mFullName = getIntent().getStringExtra(FULL_NAME);

        tvFullName.setText("Halo "+mFullName);
    }
}
