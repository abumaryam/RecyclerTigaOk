package com.dian.recyclertiga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dian.recyclertiga.data.StudentData;

import com.dian.recyclertiga.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;
    private StudentViewModel studentViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        mAdapter = new StudentAdapter();
        mAdapter.notifyDataSetChanged();

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentViewModel.class);
        studentViewModel.setStudents();
        showLoading(true);
        studentViewModel.getStudents().observe(this, new Observer<ArrayList<Student>>() {
            @Override
            public void onChanged(ArrayList<Student> students) {
                if (students != null) {
                    mAdapter.setData(students);
                    showLoading(false);
                }
            }
        });


    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
