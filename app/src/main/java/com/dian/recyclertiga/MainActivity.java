package com.dian.recyclertiga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dian.recyclertiga.data.StudentData;

import com.dian.recyclertiga.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Student> mahasiswa = new ArrayList<Student>();

        mahasiswa.addAll(StudentData.getListData());


        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new StudentAdapter(mahasiswa);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.i(TAG,"Mahasiswa ke 3 adalah "+mahasiswa.get(2));

    }
}
