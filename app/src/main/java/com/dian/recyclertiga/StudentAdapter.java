package com.dian.recyclertiga;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dian.recyclertiga.model.Student;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    private final ArrayList<Student> mStudentList = new ArrayList<>();
    public void setData(ArrayList<Student> items) {
        mStudentList.clear();
        mStudentList.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list, viewGroup, false);
        return new StudentViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind(mStudentList.get(position));
    }

    @Override
    public int getItemCount() {
        return  mStudentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView studentItemView;
        TextView nimItemView;

        StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentItemView = itemView.findViewById(R.id.student);
            nimItemView = itemView.findViewById(R.id.studentNim);

        }

        void bind(Student students) {
            studentItemView.setText(students.getFullName());
            nimItemView.setText(students.getNim());
        }
    }
}
