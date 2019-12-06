package com.dian.recyclertiga;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dian.recyclertiga.model.Student;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class StudentViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Student>> listStudent = new MutableLiveData<>();

    void setStudents(){
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<Student> listItems = new ArrayList<>();
        String url = "http://sisfo.untan.ac.id/api/mahasiswa";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray datajson = responseObject.getJSONArray("data");
                    for (int i = 0; i < datajson.length(); i++){
                        JSONObject datamhs = datajson.getJSONObject(i);
                        Student student = new Student();
                        student.setNim(datamhs.getString("nim"));
                        student.setFullName(datamhs.getString("nama_mhs"));
                        listItems.add(student);
                    }
                    listStudent.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
        RequestParams rParams = new RequestParams();
        rParams.put("nim", "XX123456");
        rParams.put("nama_mhs", "Baru Saja");
        client.post(url, rParams,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    Log.d("Success",result);
                } catch (Exception e){
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });

    }

    LiveData<ArrayList<Student>> getStudents() {
        return listStudent;
    }
}
