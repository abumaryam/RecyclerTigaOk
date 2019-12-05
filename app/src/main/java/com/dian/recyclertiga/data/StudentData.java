package com.dian.recyclertiga.data;

import com.dian.recyclertiga.R;
import com.dian.recyclertiga.model.Student;

import java.util.ArrayList;

public class StudentData {
    private static String[] fullName = {
            "Raden Fatahilah",
            "Jonathan Graciano",
            "Yosua",
            "Aliq",
            "Mulvi F",
            "Jody"
    };


    private static String[] nim = {
            "H11121213",
            "H11121214",
            "H11121215",
            "H11121216",
            "H11121217",
            "H11121218",
            "H11121219"
    };

    private static int[] photo = {
        R.drawable.bn01,
        R.drawable.bn02,
        R.drawable.bn03,
        R.drawable.bn04,
        R.drawable.bn05,
        R.drawable.bn06
    };

    public static ArrayList<Student> getListData(){
        ArrayList<Student> list = new ArrayList<>();

        for (int position = 0; position < fullName.length; position++) {
            Student student = new Student();
            student.setFullName(fullName[position]);
            student.setNim(nim[position]);
            student.setPhoto(photo[position]);

            list.add(student);
        }
        return list;

    }

}
