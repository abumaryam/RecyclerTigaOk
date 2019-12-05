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

    private final ArrayList<Student> mStudentList;
    private LayoutInflater mInflater;

    public StudentAdapter(ArrayList<Student> mStudentList) {

        this.mStudentList = mStudentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list, viewGroup, false);
        return new StudentViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, int position) {
        final Student mCurrent = mStudentList.get(position);
        holder.studentItemView.setText(mCurrent.getFullName());
        holder.nimItemView.setText(mCurrent.getNim());
        Glide.with(holder.itemView.getContext())
                .load(mCurrent.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.photoItemView);

        holder.studentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Saya Pilih " + mCurrent.getFullName(), Toast.LENGTH_SHORT).show();
                Intent moveIntent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                moveIntent.putExtra(DetailActivity.FULL_NAME, mCurrent.getFullName());
                holder.itemView.getContext().startActivity(moveIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return  mStudentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView studentItemView;
        TextView nimItemView;
        ImageView photoItemView;




        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentItemView = itemView.findViewById(R.id.student);
            nimItemView = itemView.findViewById(R.id.studentNim);
            photoItemView = itemView.findViewById(R.id.img_item_photo);

        }
    }
}
